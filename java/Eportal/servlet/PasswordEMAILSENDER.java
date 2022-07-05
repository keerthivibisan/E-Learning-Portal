package Eportal.servlet;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class PasswordEMAILSENDER {

	public boolean SendPassword(String Uemail, String password)
	{
		boolean flag = false;
		
		String fromMail = "";
		String fromPass = "";
		
		//Setting up Mail Host
		Properties pr = new Properties();
		pr.setProperty("mail.smtp.host", "smtp.gmail.com");
		pr.setProperty("mail.smtp.port", "587");
		pr.setProperty("mail.smtp.auth", "true");
		pr.setProperty("mail.smtp.starttls.enable", "true");
		pr.setProperty("mail.smtp.socketFactory.port", "587");
		pr.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		
		try
		{
			//Mail Sesssion
			Session session = Session.getInstance(pr, new Authenticator() {
				
				@Override  //Giving access to our mail that it can send mail
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromMail,fromPass);
				}
				
			});
			
			Message mess = new MimeMessage(session);
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(Uemail));
			mess.setFrom(new InternetAddress(fromMail));
			
			mess.setSubject("Here is your Password");
			mess.setText("Now you can Login with your password which we retrived, Don't share this mail or password with anyone. Your PASSWORD: "+password);
			
			Transport.send(mess);
			flag = true;
		}
		
		catch(Exception e)
		{
			
		}
		
		
		return(flag);
	}
	
}
