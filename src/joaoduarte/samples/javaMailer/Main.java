package joaoduarte.samples.javaMailer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import javax.mail.*;
import javax.mail.internet.*;
import javax.mail.Session;
import javax.mail.Transport;

/**
 * JAVA MAILER | 2022
 * @author https://www.javatpoint.com/example-of-sending-email-using-java-mail-api-through-gmail-server
 */
public class Main {
    private static boolean keepRunning = true;
    private static final Scanner keyboard = new Scanner(System.in);
    private static String fromEmail = "", fromPassword = "";
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
        appBanner();
        System.out.println("\n    Login:");
        fromEmail = readString(keyboard,"   Email: ");
        fromPassword = readString(keyboard, "   Password: ");
        String control = "";
        System.out.println("    Email:");
        while(keepRunning){
            send(fromEmail,fromPassword,readString(keyboard, "      To: "),readString(keyboard,"      Email Subject: "),readString(keyboard,"      Email Body: "));
            control = readString(keyboard, "    Send Another Email? (Y/N) ");
            if(control.equalsIgnoreCase("n") || control.equalsIgnoreCase("no")){
                keepRunning = false;
            }else{
                keepRunning = true;
            }
        }
        System.out.println("### Logged Out, Process Finished! ###");
    }

    /**
     * Displays the application banner and Runtime Warnings!
     */
    private static final void appBanner(){
        System.out.println("### JAVA MAILER | " + new SimpleDateFormat("yyyy").format(new Date()) + " ###\n");
        System.out.println("    |---------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("    |   Warning:                                                                                                                |");
        System.out.println("    |---------------------------------------------------------------------------------------------------------------------------|");
        System.out.println("    |     - This program is configured to use Gmail as the Email server;                                                        |");
        System.out.println("    |     - Be aware that your password is/may be exposed on screen!                                                            |");
        System.out.println("    |     - For the Email protocol to work, you must have \"External Apps Access\" enabled in your google Account Control Panel;  |");
        System.out.println("    |---------------------------------------------------------------------------------------------------------------------------|");

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
            System.out.println("    Sending Message ...");
            Transport.send(message);
            System.out.println("    Message Sent Successfully!");
        } catch (MessagingException e) {
            System.out.println(" !!! Error Sending the Message !!!\nHere's what Happened:\n");
            e.printStackTrace();
        }

    }

    /**
     * Read User Keyboard Inputed Strings
     * @param aKeyboard Scanner Object
     * @param aMsg Message to Show when "requesting" the data
     * @return String - User Keyboard provided data
     */
    public static String readString(Scanner aKeyboard, String aMsg) {
        System.out.print("  " + aMsg);
        return aKeyboard.nextLine();
    }

}

