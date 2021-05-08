/**
 * DataCleaner (community edition)
 * Copyright (C) 2014 Free Software Foundation, Inc.
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
package org.datacleaner;

import java.util.Map;

import org.h2.util.StringUtils;

import junit.framework.TestCase;

public class MainTest extends TestCase {

    public void testInitializeSystemProperties() throws Exception {
        final Map<String, String> properties = Main.initializeSystemProperties(
                "-job hey.xml -Dfoo=bar -Dfoo=bar -DdatastoreCatalog.orderdb.url=foobar -hello world".split(" "));
        assertEquals(2, properties.size());
        assertEquals("foobar", properties.get("datastoreCatalog.orderdb.url"));
        assertEquals("bar", properties.get("foo"));

        // clean up
        System.clearProperty("datastoreCatalog.orderdb.url");
        System.clearProperty("foo");
    }

    // A simple main method "integration test" which assumes that the
    // JettyRunner of the DC monitor is running. This will emulate how the JNLP
    // client of DC monitor starts up.
    public static void main(final String[] foo) {
        final String hostname = "localhost";

        final boolean https = true;
        final String port = "8080";
        final String context = "/DataCleaner_monitor_ui_war_exploded";
        final String tenant = "demo";
        final String username = "admin";
        final String datastore = "orderdb";
        final String jobName = "test";

        final String securityMode = "CAS";
        final String casServerUrl = "http://localhost:8080/cas";

        final String confLocation;
        final String jobLocation;
        if (StringUtils.isNullOrEmpty(jobName)) {
            confLocation = "http://" + hostname + ":" + port + context + "/repository/" + tenant
                    + "/conf.xml";
            jobLocation = null;
        } else {
            confLocation = "http://" + hostname + ":" + port + context + "/repository/" + tenant
                    + "/conf.xml";
            jobLocation = "http://" + hostname + ":" + port + context + "/repository/" + tenant + "/jobs/" + jobName + ".analysis.xml";
        }
        final String fullArguments =
                "-conf " + confLocation + (jobLocation != null ? " -job " + jobLocation : "") + (StringUtils
                        .isNullOrEmpty(datastore) ? "" : " -ds " + datastore)
                        + " -Ddatacleaner.ui.visible=true -Ddatacleaner.embed.client=dq-monitor -Ddatacleaner.sandbox=true"
                        + " -Ddatacleaner.monitor.hostname=" + hostname + " -Ddatacleaner.monitor.port=" + port
                        + " -Ddatacleaner.monitor.context=" + context + "/ -Ddatacleaner.monitor.https=" + https
                        + " -Ddatacleaner.monitor.tenant=" + tenant + " -Ddatacleaner.monitor.username=" + username
                        + " -Ddatacleaner.monitor.security.mode=" + securityMode
                        + " -Ddatacleaner.monitor.security.casserverurl=" + casServerUrl;
        final String[] args = fullArguments.split(" ");
        Main.main(args);
    }
}
