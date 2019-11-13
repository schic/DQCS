/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Neopost - Customer Information Management
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.datacleaner.documentation.swagger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Own implementation of Swagger JSON provider.
 */
@Controller
@RequestMapping(SwaggerJSONController.SWAGGER_JSON_PATH)
public class SwaggerJSONController {

    private static final Logger logger = LoggerFactory.getLogger(SwaggerJSONController.class);

    static final String SWAGGER_JSON_PATH="/swagger.json";
    static final String ORIGINAL_URL_HEADER="X-Original-Url";

    @Autowired
    private ApplicationContext ctx;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SwaggerConfiguration generateSwaggerJSON(HttpServletRequest httpServletRequest) {
        String host;
        String basePath;
        String scheme;
        try {

            // If The DC MOnitor is running behind a reverse-proxy like NGINX, it is necessary to
            // configure it to provide the original url of the reverse proxy, not the url of the backend server where
            // the DC monitor is actually running on. The original url must be provided in this HTTP header.
            // Nginx configuration snippet:
            // proxy_set_header X-Original-Url $scheme://$http_host:$server_port$request_uri;
            final String originalUrl = httpServletRequest.getHeader(ORIGINAL_URL_HEADER);
            final String servletUrl = httpServletRequest.getRequestURL().toString();

            final String serviceUrl = (originalUrl != null && !originalUrl.isEmpty()) ?
                    originalUrl : httpServletRequest.getRequestURL().toString();
            URL url;
            try {
                url = new URL(serviceUrl);
            } catch(MalformedURLException e) {
                logger.warn("Malformed X-Original-Url header: " + e.toString());
                url = new URL(servletUrl);
            }

            host = url.getHost();
            if(url.getPort() != -1) {
                host = host + ":" + url.getPort();
            }
            basePath = url.getPath();
            if(basePath.endsWith(SWAGGER_JSON_PATH)) {
                basePath = basePath.substring(0, basePath.length() - SWAGGER_JSON_PATH.length());
            }

            scheme = url.getProtocol();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        SwaggerBuilder swagger = new SwaggerBuilder(host, basePath, scheme);
        for(Object controller: getControllers()) {
            swagger.addClass(controller.getClass());
        }
        return swagger.build();
    }

    private Collection<Object> getControllers() {
        Map<String, Object> controllerBeans = ctx.getBeansWithAnnotation(Controller.class);
        return controllerBeans.values();
    }

    private static class SwaggerBuilder {

        private Class<?> serviceClass = null;
        private String serviceUrlPrefix = null;
        private SwaggerConfiguration swaggerConfiguration = null;

        public SwaggerBuilder(String host, String basePath, String scheme) {
            swaggerConfiguration = new SwaggerConfiguration();
            swaggerConfiguration.setHost(host);
            swaggerConfiguration.setBasePath(basePath);
            swaggerConfiguration.setSchemes(new String[] {scheme});
            Map<String, Object> basicSecDefinition = new HashMap<>();
            basicSecDefinition.put("type", "basic");
            swaggerConfiguration.addSecurityDefinition("basicAuth", basicSecDefinition);

            Map<String, String[]> securityRequirement = new HashMap<>();
            securityRequirement.put("basicAuth", new String[0]);
            swaggerConfiguration.getSecurity().add(securityRequirement);

            SwaggerSchema genericObjSchema = new SwaggerSchema("object");
            genericObjSchema.put("properties", new HashMap<>());
            swaggerConfiguration.getDefinitions().put("GenericObject", genericObjSchema);
        }

        public void addClass(Class<?> controllerClass) {
            serviceClass = controllerClass;
            addClassServices();
        }

        public SwaggerConfiguration build() {
            return swaggerConfiguration;
        }

        private void addClassServices() {
            RequestMapping classRequestMapping = (RequestMapping) AnnotationUtils.findAnnotation(serviceClass, RequestMapping.class);

            if (classRequestMapping == null) {
                return;
            }

            serviceUrlPrefix = classRequestMapping.value()[0];

            for (Method method : serviceClass.getMethods()) {
                addMethod(method);
            }

            swaggerConfiguration.getTags().add(createSwaggerTag());
        }

        private SwaggerTag createSwaggerTag() {
            SwaggerTag swaggerTag = new SwaggerTag();
            swaggerTag.setName(serviceClass.getSimpleName());

            return swaggerTag;
        }

        private void addMethod(Method method) {
            RequestMapping methodRequestMapping = method.getAnnotation(RequestMapping.class);

            if (methodRequestMapping == null) {
                return;
            }

            String url = getMethodURL(methodRequestMapping.value());

            if (!swaggerConfiguration.getPaths().containsKey(url)) {
                swaggerConfiguration.getPaths().put(url, new HashMap<>());
            }

            addHTTPMethods(url, method);
        }

        private String getMethodURL(String[] methodRequestMappingValues) {
            String methodUrl = "";

            if (methodRequestMappingValues.length > 0) {
                methodUrl = methodRequestMappingValues[0];
            }

            return serviceUrlPrefix + methodUrl;
        }

        private void addHTTPMethods(String url, Method method) {
            RequestMapping methodRequestMapping = method.getAnnotation(RequestMapping.class);
            Map<String, SwaggerMethod> swaggerMethods = swaggerConfiguration.getPaths().get(url);

            for (RequestMethod requestMethod : methodRequestMapping.method()) {
                SwaggerMethod swaggerMethod = createSwaggerMethod(methodRequestMapping, method);
                String httpMethodName = requestMethod.name().toLowerCase();

                if (httpMethodName.isEmpty()) {
                    logger.warn("HTTP method of a service method is empty ({}). ", method.getName());
                    continue;
                }

                swaggerMethods.put(httpMethodName, swaggerMethod);
            }
        }

        private SwaggerMethod createSwaggerMethod(RequestMapping methodRequestMapping, Method method) {
            SwaggerMethod swaggerMethod = new SwaggerMethod();

            swaggerMethod.setOperationId(method.getName());
            swaggerMethod.setDescription(methodRequestMapping.name());
            swaggerMethod.setConsumes(methodRequestMapping.consumes());
            swaggerMethod.setProduces(methodRequestMapping.produces());
            swaggerMethod.setParameters(createSwaggerParameterArray(method));
            swaggerMethod.getTags().add(serviceClass.getSimpleName());
            SwaggerResponse responseOk = new SwaggerResponse();
            responseOk.setDescription("Unknown Description");
            swaggerMethod.getResponses().put("200", responseOk);

            return swaggerMethod;
        }

        private SwaggerParameter[] createSwaggerParameterArray(Method method) {
            List<SwaggerParameter> swaggerParameterList = new ArrayList<>();
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            Class<?>[] parameterTypes = method.getParameterTypes();

            for (int i = 0; i < parameterTypes.length; i++) {
                SwaggerParameter swaggerParameter = getSwaggerParameter(parameterTypes[i], parameterAnnotations[i]);

                if (swaggerParameter != null) {
                    swaggerParameterList.add(swaggerParameter);
                }
            }

            return swaggerParameterList.toArray(new SwaggerParameter[swaggerParameterList.size()]);
        }

        private SwaggerParameter getSwaggerParameter(Class<?> parameterType, Annotation[] parameterAnnotations) {
            SwaggerParameter swaggerParameter = null;
            RequestBody requestBody = (RequestBody) findAnnotation(parameterAnnotations, RequestBody.class);
            RequestParam requestParam = (RequestParam) findAnnotation(parameterAnnotations, RequestParam.class);
            PathVariable pathVariable = (PathVariable) findAnnotation(parameterAnnotations, PathVariable.class);
            String parameterName = "";

            if (requestBody != null) {
                swaggerParameter = new SwaggerParameter();
                swaggerParameter.setRequired(requestBody.required());
                swaggerParameter.setIn(SwaggerParameter.In.BODY.getValue());
                parameterName = "body";
            } else if (requestParam != null) {
                swaggerParameter = new SwaggerParameter();
                swaggerParameter.setRequired(requestParam.required());
                swaggerParameter.setIn(SwaggerParameter.In.QUERY.getValue());
                parameterName = requestParam.value();
            } else if (pathVariable != null) {
                swaggerParameter = new SwaggerParameter();
                swaggerParameter.setRequired(true);
                swaggerParameter.setIn(SwaggerParameter.In.PATH.getValue());
                parameterName = pathVariable.value();
            }

            if (swaggerParameter != null) {
                swaggerParameter.setName(parameterName);
                swaggerParameter.setTypeByClass(parameterType);
            }

            return swaggerParameter;
        }

        private Annotation findAnnotation(Annotation[] allAnnotations, Class<?> requiredType) {
            for (Annotation annotation : allAnnotations) {
                if (annotation.annotationType().equals(requiredType)) {
                    return annotation;
                }
            }

            return null;
        }
    }
}
