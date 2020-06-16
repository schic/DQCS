package org.datacleaner.extension.sendjmsmessage;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
 
public class JMSConsumerForTesting {
 
    private final static String brokerURL = "tcp://localhost:61616";
    private final static String queueName = "queue1";
    
    public static void main(String[] args) throws Exception {
        new Thread(new Consumer()).start();;
    }
 
    public static class Consumer implements Runnable, ExceptionListener {
        public void run() {

            while (true){
                try {
                    // Create a ConnectionFactory
                    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerURL);
     
                    // Create a Connection
                    Connection connection = connectionFactory.createConnection();
                    connection.start();
     
                    connection.setExceptionListener(this);
     
                    // Create a Session
                    Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
     
                    // Create the destination (Topic or Queue)
                    Destination destination = session.createQueue(queueName);
     
                    // Create a MessageConsumer from the Session to the Topic or Queue
                    MessageConsumer consumer = session.createConsumer(destination);
     
                    // Wait for a message
                    Message message = consumer.receive(1000);
     
                    if (message instanceof TextMessage) {
                        TextMessage textMessage = (TextMessage) message;
                        String text = textMessage.getText();
                        System.out.println("ID: " + textMessage.getJMSCorrelationID());
                        System.out.println("BODY: " + text);
                    } else {
                        System.out.println("Received: " + message);
                    }
     
                    consumer.close();
                    session.close();
                    connection.close();
                } catch (Exception e) {
                    System.out.println("Caught: " + e);
                    e.printStackTrace();
                }
            }    
        }
 
        public synchronized void onException(JMSException ex) {
            System.out.println("JMS Exception occured.  Shutting down client.");
        }
    }
}