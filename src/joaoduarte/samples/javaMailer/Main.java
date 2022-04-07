package joaoduarte.samples.javaMailer;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Session;
import javax.mail.Transport;

/**
 * JAVA MAILER | 2022
 * @author https://www.javatpoint.com/example-of-sending-email-using-java-mail-api-through-gmail-server
 */
public class Main {
    /*Use Instruction:
        A) How to Include Jar files in IntellIJ:
            1. Open your installed IntelliJ IDEA Project and.
            2. Go to the File > Project Structure.
            3. Select Modules at the left panel and select the Dependencies tab.
            4. Select the + icon and select 1 JARs or Directories option.
            5. select your JAR file or you can select the directories.
            6. Click on the OK button.
          B) Jar Files Needed:
            1. javax.mail.jar
            2.activation-1.1.1.jar (Download: https://jar-download.com/?search_box=javax.activation=
    */

    /**
     * Main Class
     * @param args  --null--
     */
    public static void main(String[] args) {
        System.out.println("### JAVA MAILER ###\n");
        send("from@email.com","fromEmail_password","to@email.com","email_subject","email_body");
        System.out.println("__ BYE __");
    }

    /**
     * Send Mail Void
     * @param from - Email From
     * @param password - Email from password
     * @param to - Email To
     * @param sub - Email Subject
     * @param msg - Email Body
     */
    public static void send(String from,String password,String to,String sub,String msg){
        //Get properties object
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        //Get Session
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from,password);
                    }
                });

        //Compose Message
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
            //Send Message
            System.out.println("Sending Message ...");
            Transport.send(message);
            System.out.println("Message Sent Successfully!");
        } catch (MessagingException e) {
            System.out.println("Error Sending the Message!\nHere's what Happened:\n");
            e.printStackTrace();
        }

    }


}

