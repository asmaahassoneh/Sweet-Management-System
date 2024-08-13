package production_cods;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.util.Properties;

public class NotificationSource extends Application {
    public static final String MANAGER_EMAIL = "mohammed.xxmoxx@gmail.com";
    private static final String SENDER_EMAIL = "mohammed.xxmoxx@gmail.com";
    private static final String SENDER_PASSWORD = "xbaj apyu ugwv ktcp";
        @Override
        public void start(Stage primaryStage){
            primaryStage.setTitle("Send Email For Special order");

            GridPane gridPane = new GridPane();
            gridPane.setPadding(new Insets(10, 10, 10, 10));
            gridPane.setVgap(8);
            gridPane.setHgap(10);

            Label subjectLabel = new Label("Subject:");
            GridPane.setConstraints(subjectLabel, 0, 0);

            TextField subjectInput = new TextField();
            GridPane.setConstraints(subjectInput, 1, 0);

            Label messageLabel = new Label("Message:");
            GridPane.setConstraints(messageLabel, 0, 1);

            TextArea messageInput = new TextArea();
            messageInput.setWrapText(true);
            GridPane.setConstraints(messageInput, 1, 1);

            Button sendButton = new Button("Send");
            GridPane.setConstraints(sendButton, 1, 2);

            sendButton.setOnAction(e -> {
                String subject = subjectInput.getText();
                String message = messageInput.getText();
                sendEmail(MANAGER_EMAIL, subject, message);
            });

            gridPane.getChildren().addAll(subjectLabel, subjectInput, messageLabel, messageInput, sendButton);

            Scene scene = new Scene(gridPane, 600, 300);
            primaryStage.setScene(scene);
            primaryStage.show();
        }

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
                JOptionPane.showMessageDialog(null,"You have send an Email for the Manager for Special Request ");

            } catch (MessagingException mex) {
                mex.printStackTrace();
            }
        }
    }

















