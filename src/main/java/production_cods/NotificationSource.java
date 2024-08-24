package production_cods;

import java.util.logging.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class NotificationSource {
    private static final Logger logger =  Logger.getLogger(NotificationSource.class.getName());
    private static final String SENDER_EMAIL = "mohammed.xxmoxx@gmail.com";
    private static final String SENDER_PASSWORD = System.getenv("xbaj apyu ugwv ktcp");


        public void sendEmail (String to, String subject, String message){
            String host = "smtp.gmail.com";
            Properties properties = System.getProperties();
            properties.put("mail.smtp.host", host);
            properties.put("mail.smtp.port", "587");
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");

            Session session = Session.getInstance(properties, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(SENDER_EMAIL, SENDER_PASSWORD);
                }
            });

            try {
                MimeMessage mimeMessage = new MimeMessage(session);
                mimeMessage.setFrom(new InternetAddress(SENDER_EMAIL));
                mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
                mimeMessage.setSubject(subject);
                mimeMessage.setText(message);

                Transport.send(mimeMessage);

            } catch (MessagingException mex) {
                logger.info(mex.getMessage());
            }
        }
    }

















