package edu.cecar.modelo;

import com.sun.mail.smtp.SMTPTransport;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.StringTokenizer;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
 
public class EnvioCorreoHotmail
{
 
	public static void main(String[] args)
	{
		
		String correoEnvia = "mariaprimercorreo@hotmail.com";
		  String claveCorreo = "maria123";
		Properties props = new Properties();
 
		props.put("mail.smtp.host", "smtp.live.com");
		props.put("mail.smtp.socketFactory.port","25");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth","true");
		props.put("mail.smtp.port","25");
		props.put("mail.smtp.starttls.enable","true");
		props.put("mail.user", correoEnvia);
		props.put("mail.password", claveCorreo);
 
		Session session = Session.getDefaultInstance(props);
		
			
 
		try
		{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(correoEnvia,"MiCorreo@hotmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("MiotroCorreo@hotmail.com"));
			message.setSubject("Hi this is me");
			message.setText("Hola!!!!!");
			
			Transport transport = session.getTransport("smtp");
			Transport.send(message);
			 transport.connect(correoEnvia, claveCorreo);
			   transport.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
			   
			   transport.close();
 
			System.out.println("ok");
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
 
	}
 
}