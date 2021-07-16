package edu.cecar.modelo;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class EnvioCorreo {

	public static void mandarCorreo() {
		  // El correo gmail de envío
		  String correoEnvia = "mariaprimercorreo@hotmail.com";
		  String claveCorreo = "maria123";
		  
		  try {
		  
		  // La configuración para enviar correo
		  Properties properties = new Properties();
		 
		  properties.put("mail.smtp.host", "smtp.live.com");
		  properties.put("mail.smtp.starttls.enable", "true");
		  properties.put("mail.smtp.port", "25");
		  properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		 

		  //properties.put("mail.smtp.starttls.enable", "true");
		  properties.put("mail.smtp.auth", "true");
		  properties.put("mail.user", correoEnvia);
		  properties.put("mail.password", claveCorreo);
		 
		  // Obtener la sesion
		  Session session = Session.getDefaultInstance(properties);
		  int aviso = 0;
		  
		   // Crear el cuerpo del mensaje
		   MimeMessage mimeMessage = new MimeMessage(session);
		 
		   // Agregar quien envía el correo
		   mimeMessage.setFrom(new InternetAddress(correoEnvia, "Empresa ACME"));
		   
		   // Agregar los destinatarios al mensaje
		   mimeMessage.addRecipient(Message.RecipientType.TO, new 
				   InternetAddress("juan.benavides@cecar.edu.co"));
		 
		    
		   // Los destinatarios
		   InternetAddress[] internetAddresses = {new InternetAddress("juan.benavides@cecar.edu.co")};
//		     new InternetAddress("correo2@gmail.com"),
//		     new InternetAddress("correo3@gmail.com") };
		 
		  
		   // Agregar el asunto al correo
		   mimeMessage.setSubject("ADJUNTO DOCUMENTO");
		 
		   // Creo la parte del mensaje
		   MimeBodyPart mimeBodyPart = new MimeBodyPart();
		   mimeBodyPart.setText("Te envío este documento como prueba de que funciona mi programa de envio de correo.");
		 
		  MimeBodyPart mimeBodyPartAdjunto = new MimeBodyPart();
		   mimeBodyPartAdjunto.attachFile("C:/Users/ADMIN/workspace/AppCoranovirus/recursos/20200812-covid-19-sitrep-205.pdf");

			// Crear el multipart para agregar la parte del mensaje anterior
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(mimeBodyPart);
			multipart.addBodyPart(mimeBodyPartAdjunto);
		   
		   // Agregar el multipart al cuerpo del mensaje
		   mimeMessage.setContent(multipart);
		 
		   // Enviar el mensaje
		   Transport transport = session.getTransport("smtp");
		   
		   transport.connect(correoEnvia, claveCorreo);
		   transport.sendMessage(mimeMessage, mimeMessage.getRecipients(Message.RecipientType.TO));
		   
		   transport.close();
		 
		  } catch (Exception ex) {
		   ex.printStackTrace();
		   JOptionPane.showMessageDialog(null, "Error: "+ex.getMessage());
		   //aviso = 1;
		  }
		  //if (aviso==0) {
			  JOptionPane.showMessageDialog(null, "¡Correo electrónico enviado exitosamente!");
		  }
		 

	public static void main(String[] args) {
		EnvioCorreo.mandarCorreo();
	}

		  


	}


