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

public class TverifyMailSender {
	
	public String GenerateVCode()
	{
		Random rnd = new Random();
		int n = rnd.nextInt(999999);
		String code = Integer.toString(n);
		return(code);
	}
	
	public boolean SendEmail(TregistrationInfoCarrier user)
	{
		boolean flag = false;
		
		try
		{
			String fromMail = "";
			String pass = "";
			String toMail = user.getTemail();
			
			Properties pr = new Properties();
			//SETTING UP Host & Port
			pr.setProperty("mail.smtp.host", "smtp.gmail.com");
			pr.setProperty("mail.smtp.port", "587");
			pr.setProperty("mail.smtp.auth", "true");
			pr.setProperty("mail.smtp.starttls.enable", "true");
			pr.setProperty("mail.smtp.socketFactory.port", "587");
			pr.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			
			//Mail Session
			Session session = Session.getInstance(pr, new Authenticator () {
				
				@Override
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(fromMail,pass);
				}
				
			});
			
			//MEssage in Mail
			Message mess = new MimeMessage(session);
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
