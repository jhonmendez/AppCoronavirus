package edu.cecar.modelo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class EnviarGmail {

static final String from = "empresaacme2021@gmail.com";  // GMail user name (just the part before "@gmail.com")
static final String fromname = "nombreremitente";
static final String to = "juan.benavides@cecar.edu.co";
static final String smtp_username = "empresaacme2021@gmail.com";
static final String smtp_password = "acme2021";
static final String configset = "configSet";
static final String host = "smtp.gmail.com";
static final int port = 587;
static final String subjet = "envio de correo desde java";
static final String body = String.join(System.getProperty(
		"line.separator"), "prueba de envio de correo");




public static void main(String[] args) throws Exception {
   
	Properties props = System.getProperties();
	java.util.Properties props1 = new java.util.Properties();
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.transpor.protocol", "tls");
	props.put("mail.smtp.port", port);
	props.put("mail.smtp.host", host);
	props.put("mail.smtp.starttls.enable", "true");
	props.put("mail.smtp.auth", "true");
	props.setProperty("mail.user", smtp_username);
	props.setProperty("mail.password", smtp_password);
	//props1.put("mail.smtp.socketFactory.port", port);
	//props1.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	//props1.put("mail.smtp.socketFactory.fallback", "false");
	
	
	Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {

	    protected PasswordAuthentication getPasswordAuthentication() {
	      return new PasswordAuthentication(smtp_username, smtp_password);
	    }
	  });
	
	MimeMessage msg = new MimeMessage(session);
	msg.setFrom(new InternetAddress(from, fromname));
	msg.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
	msg.setSubject(subjet);
    msg.setContent(body, "text/html");
    msg.setHeader("x-ses-configuration-set", configset);
    Transport transport = session.getTransport();
    
    
    try {
    	System.out.println("enviando mensaje...");
    	transport.connect(host, smtp_username,smtp_password);
    	transport.sendMessage(msg, msg.getAllRecipients());
    	System.out.println("mensaje enviado");
		
    } 
    catch (Exception e) {
		System.out.println("el mensaje no se ha podido envia");
		System.out.println("error:" + e.getMessage());
	}
    
    finally {
		transport.close();
	}
    
    
    
    
    
    
    
    
    
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			

	
   } 
}