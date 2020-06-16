package org.datacleaner.extension.sendjmsmessage;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.junit.Test;

public class SendMessageToJMSQueueAnalyzerTest extends TestCase {

    SendMessageToJMSQueueAnalyzer analyzer = new SendMessageToJMSQueueAnalyzer();

    @Test
    public void testBuildMessageBodyFromTemplate() {
        String template = "a;b";
        String[] keys = { "a", "b" };
        List<Object> values = new ArrayList<Object>();
        values.add("foo$");
        values.add("bar");
        String messageBody = analyzer.buildMessageBodyFromTemplate(template, keys, values);
        assertEquals("a;b" + "\n" + "foo$;bar", messageBody);

        values = new ArrayList<Object>();
        values.add(Integer.valueOf(1));
        values.add(Integer.valueOf(2));
        messageBody = analyzer.buildMessageBodyFromTemplate(template, keys, values);
        assertEquals(messageBody, "a;b\n1;2");

    }

    @Test
    public void testBuildMessageBodyFromTemplateWithEmptyValues() {
        String template = "a;b;c";
        String[] keys = { "a", "b", "c" };
        List<Object> values = new ArrayList<Object>();
        values.add("foo");
        values.add("");
        values.add("baz");
        String messageBody = analyzer.buildMessageBodyFromTemplate(template, keys, values);
        assertEquals("a;b;c" + "\n" + "foo;;baz", messageBody);

        values = new ArrayList<Object>();
        values.add("");
        values.add(Integer.valueOf(2));
        values.add(Integer.valueOf(3));
        messageBody = analyzer.buildMessageBodyFromTemplate(template, keys, values);
        assertEquals(messageBody, "a;b;c\n;2;3");

    }

    @Test
    public void testBuildMessageBodyFromTemplateWithNullValuesShouldBecomeEmpty() {
        String template = "a;b;c";
        String[] keys = { "a", "b", "c" };
        List<Object> values = new ArrayList<Object>();
        values.add("foo");
        values.add(null);
        values.add("baz");
        String messageBody = analyzer.buildMessageBodyFromTemplate(template, keys, values);
        assertEquals("a;b;c" + "\n" + "foo;;baz", messageBody);

        values = new ArrayList<Object>();
        values.add(null);
        values.add(Integer.valueOf(2));
        values.add(Integer.valueOf(3));
        messageBody = analyzer.buildMessageBodyFromTemplate(template, keys, values);
        assertEquals(messageBody, "a;b;c\n;2;3");

    }

}
