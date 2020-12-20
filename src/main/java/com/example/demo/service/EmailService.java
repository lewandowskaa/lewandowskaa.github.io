package com.example.demo.service;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

@Service
public class EmailService {

    // klasa servis odpowiedzialna za przechowywanie logiki biznesowej związanej z możliwością wysyłania wiadomości email
    // odbiera informacje z kontrolera na temat wiadomosci ktore uzytkownik chce wyslac po czym przekazyje je dalej na adres dog-sky@wp.pl


    private final String USERNAME = "dogskypage@gmail.com";//nie da się zmienić, bo final ostateczna wersja
    private final String PASSWORD = "dogSky2020";////nie da się zmienić, bo final ostateczna wersja

    public void sendEmail(String firstName, String email, String phone, String context) {

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");

        try {
            Session session = Session.getInstance(prop,
                    new Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(USERNAME, PASSWORD);
                        }
                    });

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("dogskypage@gmail.com"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("dog-sky@wp.pl")
            );
            message.setSubject("DogSky");
            message.setText
                    (
                            "Imie : " + firstName +
                                    "\nEmail : " + email +
                                    "\nTelefon : " + phone +
                                    "\nWiadomość : " + context +
                                    "\n\nTHIS IS AN AUTOMATED MESSAGE - PLEASE DO NOT REPLY DIRECTLY TO THIS EMAIL"
                    );
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
