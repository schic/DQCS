package org.datacleaner.extension.emailing;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class responsible for sending emails
 */
public class EmailDispatcher {

    private static final Logger logger = LoggerFactory.getLogger(EmailDispatcher.class);

    private final String _from;
    private final String _username;
    private final String _password;
    private final Properties props;

    /**
     * Creates an unauthenticated {@link EmailDispatcher}.
     * 
     * @param smtpHost
     * @param smtpPort
     * @param from
     * @param tls
     * @param ssl
     */
    public EmailDispatcher(String smtpHost, int smtpPort, String from, boolean tls, boolean ssl) {
        this(smtpHost, smtpPort, null, null, from, tls, ssl);
    }

    /**
     * Creates an authenticated {@link EmailDispatcher}.
     * 
     * @param smtpHost
     * @param smtpPort
     * @param smtpUsername
     * @param smtpPassword
     * @param from
     * @param tls
     * @param ssl
     */
    public EmailDispatcher(String smtpHost, int smtpPort, String smtpUsername, String smtpPassword, String from,
            boolean tls, boolean ssl) {
        _username = smtpUsername;
        _password = smtpPassword;
        _from = from;

        props = new Properties();
        props.setProperty("mail.smtp.host", smtpHost);
        props.setProperty("mail.smtp.port", smtpPort + "");

        if (smtpUsername != null && smtpPassword != null) {
            props.setProperty("mail.smtp.auth", "true");
        }

        if (ssl) {
            props.put("mail.smtp.socketFactory.port", smtpPort + "");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        }

        if (tls) {
            props.setProperty("mail.smtp.starttls.enable", "true");
        }
    }

    public EmailResult sendMail(final String to, final String subject, final String charset, final String bodyPlain,
            final String bodyHtml, long sleepTimeMillis) {
        if (sleepTimeMillis < 0) {
            // concurrent sending
            return sendEmailInternal(to, subject, charset, bodyPlain, bodyHtml);
        } else {
            // sequential sending
            synchronized (this) {
                if (sleepTimeMillis > 0) {
                    try {
                        Thread.sleep(sleepTimeMillis);
                    } catch (InterruptedException e) {
                        // do nothing
                        logger.debug("Sleeping was interrupted", e);
                    }
                }
                return sendEmailInternal(to, subject, charset, bodyPlain, bodyHtml);
            }
        }
    }

    private EmailResult sendEmailInternal(String to, String subject, String charset, String bodyPlain, String bodyHtml) {
        try {
            final Session session;
            if (_username != null && _password != null) {
                session = Session.getDefaultInstance(props, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(_username, _password);
                    }
                });
            } else {
                session = Session.getDefaultInstance(props);
            }
            session.setDebug(false);

            final MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(_from));
            message.setRecipient(RecipientType.TO, new InternetAddress(to));

            message.setSubject(subject);

            if (bodyPlain != null) {
                message.setContent(bodyPlain, "text/plain; charset=" + charset);
            }

            if (bodyHtml != null) {
                message.setContent(bodyHtml, "text/html; charset=" + charset);
            }

            Transport.send(message);
            
            logger.info("Succesfully sent '{}' to {}", subject, to);
            
            return EmailResult.success();
        } catch (Exception e) {
            if (logger.isDebugEnabled()) {
                final String body = (bodyHtml == null ? bodyPlain : bodyHtml);
                logger.warn("Failed to send '" + subject + "' to " + to + ": " + body, e);
            } else {
                logger.warn("Failed to send '" + subject + "' to " + to, e);
            }

            return EmailResult.failure(to, e);
        }
    }
}