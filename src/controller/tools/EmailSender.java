package controller.tools;

import controller.baseDeDatos.Configuracion;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.Security;
import java.util.Properties;

/**
 * Esta clase permite enviar un email
 * @author Fernando
 */
public class EmailSender implements Configuracion {


    /**
     * Este metodo permite enviar un email
     * @param to direccion de correo del destinatario
     * @param subject asunto del correo
     * @param message cuerpo del correo
     * @throws MessagingException en caso de que no se pueda enviar el email
     * @author Fernando
     */
    public static void sendEmail(String to, String subject, String message) throws MessagingException {
        Properties props = new Properties();
        System.setProperty("https.protocols", "TLSv1.2");
        Security.setProperty("jdk.tls.disabledAlgorithms", "");
        Security.setProperty("jdk.tls.client.protocols", "TLSv1.2");
        Security.setProperty("jdk.tls.client.cipherSuites", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384,TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256");

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL, EMAIL_PASSWORD);
            }
        });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(EMAIL));
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        msg.setSubject(subject);
        msg.setText(message);

        Transport.send(msg);
    }

}
