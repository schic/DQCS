package org.datacleaner.util;

/**
 * @Author: wuyj.
 * @Description:  国际化支持
 * @Date:Created in 2020/3/26 22:36.
 * @Modified By:
 */


import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;

import java.io.IOException;

import java.io.InputStream;

import java.util.Arrays;
import java.util.Properties;


public class PropertyUtil {
	private static final Logger logger =  LoggerFactory.getLogger(PropertyUtil.class);
	private static Properties props;
	static {
		loadProps();
	}
	synchronized static private void loadProps() {
		props = new Properties();
		InputStream in = null;
		try {
			in = PropertyUtil.class.getClassLoader().getResourceAsStream("language/en_US.properties");
			props.load(in);

		} catch (FileNotFoundException e) {

			logger.error("dbconfig.properties文件未找到");

		} catch (IOException e) {

			logger.error("出现IOException");

		} finally {

			try {

				if (null != in) {

					in.close();

				}

			} catch (IOException e) {

				logger.error("dbconfig.properties文件流关闭出现异常");

			}

		}

		logger.info("加载properties文件内容完成...........");

		logger.info("properties文件内容：" + props);
	}

	public static String getProperty(String key) {
		if (null == props) {
			loadProps();
		}
		String[] str = key.split(" ");
		String name = StringUtils.join(str, "_");
		return props.getProperty(name);
	}

	public static String getProperty(String key, String defaultValue) {
		if (null == props) {
			loadProps();
		}
		String[] str = key.split(" ");
		String name = StringUtils.join(str, "_");
		return props.getProperty(name, defaultValue);
	}
}
