# JavaMailer

This is a sample program that focus on Email sending through an external [Java](https://www.java.com/en/) application.

## Needed Dependencies
For the program to work, it needs two main Java Libraries:
* javax.mail ([download here](https://jar-download.com/?search_box=javax.mail));
* javax.activation ([download here](https://jar-download.com/?search_box=javax.activation));

## Email Server
This program is configured to use public Google SMTP settings:
* Host: stmp.gmail.com;
* Port: 495;
* Require Auth: True;

For using the program with other Email servers, please change this settings.

## Important Warnings
* This program does not provide any "privacy treatment". For that reason, be aware when using it, because your credentials will be visible on the execution console;
* For the Email protocol to work, you must have "External Applications Access" enabled in your Google Account Control Panel;

## Usage Snapshots
### Login and Send Email
![Login and Send Email](https://github.com/jduarte98/JavaMailer/blob/main/out/1_login_sendEmail.png)
### Message Sent and Exit
![Message Sent and Exit](https://github.com/jduarte98/JavaMailer/blob/main/out/2_sent_exit.png)

## Author
* General Program Use: João Duarte - [GitHub](https://github.com/jduarte98) | [LinkedIn](https://www.linkedin.com/in/jo%C3%A3o-duarte-453bb9199);
* Email Protocol: [javaTpoint.com](https://www.javatpoint.com/example-of-sending-email-using-java-mail-api-through-gmail-server);
