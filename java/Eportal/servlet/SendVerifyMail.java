package Eportal.servlet;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendVerifyMail {
	
	public String generateCode()
	{
		Random rnd = new Random();
		int code = rnd.nextInt(999999);
		return String.format("%06d", code);
	}
	
	public boolean sendEmail(RegistrationInfoCarrier user)
	{
		boolean flag=false;
		
		try
		{
			//Your Email & Pass here
			String fromMail = "";
			String pass = "";
			String toMail = user.getEmail();
			
			//Setting up
			Properties pr = new Properties();
			pr.setProperty("mail.smtp.host", "smtp.gmail.com");
			pr.setProperty("mail.smtp.port", "587");
			pr.setProperty("mail.smtp.auth", "true");
			pr.setProperty("mail.smtp.starttls.enable", "true");
			pr.setProperty("mail.smtp.socketFactory.port", "587");
			pr.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			
			//Mail Session
			Session session = Session.getInstance(pr, new Authenticator() {
				
				@Override  //Giving access to our mail that it can send mail
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromMail,pass);
				}
				
			});
			
			//BUILDING MAIL
			Message mess = new MimeMessage(session);
			
			//SETTING RECIEVER & SENDER
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toMail));
			mess.setFrom(new InternetAddress(fromMail));
			
			//SETTING MESSAGE
			mess.setSubject("User Verification Email");
			mess.setText("Here is Your 6-Digit Verification Code, Confirm your Registration, Please dont share the Code. YOUR CODE: "+user.getCode());
			
			Transport.send(mess);
			flag=true;
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return(flag);
	}

}
