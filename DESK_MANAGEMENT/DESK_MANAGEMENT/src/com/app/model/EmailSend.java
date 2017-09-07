package com.app.model;

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import org.springframework.stereotype.Component;

@Component
public class EmailSend {
	
	
	
	public EmailSend() {
		// TODO Auto-generated constructor stub
	}

	public void sendMail(String name, String emailId, String  pass, String EId){
		
		
		final String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
		  // Get a Properties object
		     Properties props = System.getProperties();
		     props.setProperty("mail.smtp.host", "smtp.gmail.com");
		     props.setProperty("mail.smtp.socketFactory.class", SSL_FACTORY);
		     props.setProperty("mail.smtp.socketFactory.fallback", "false");
		     props.setProperty("mail.smtp.port", "465");
		     props.setProperty("mail.smtp.socketFactory.port", "465");
		     props.put("mail.smtp.auth", "true");
		     props.put("mail.debug", "true");
		     props.put("mail.store.protocol", "pop3");
		     props.put("mail.transport.protocol", "smtp");
		     
		     //Set your mail-id  And password
		     final String username = "deskmanagement2017@gmail.com";//
		     final String password = "deskms2017";
		     
		     try{
		     Session session = Session.getDefaultInstance(props, 
		                          new Authenticator(){
		                             protected PasswordAuthentication getPasswordAuthentication() {
		                                return new PasswordAuthentication(username, password);
		                             }});

		   // -- Create a new message --
		     Message msg = new MimeMessage(session);

		  // -- Set the FROM and TO fields --
		     msg.setFrom(new InternetAddress("deskmanagement2017@gmail.com"));
		     msg.setRecipients(Message.RecipientType.TO, 
		                      InternetAddress.parse(emailId
		                    		  ,false));
		     
		     //Add Subject 
		     msg.setSubject("Hello , "+name);
		     msg.setText("Hello "+name+""
		     		+ ""
		     		+ "  Your Employee ID is : "+EId+
		     		""
		     		+ "  Your Password is : "+pass+
		     		""
		     		+ "  Click here For Login  www.awscloudg4.cf");
		     msg.setSentDate(new Date());
		     Transport.send(msg);
		     System.out.println("Message sent.");
		  }catch (MessagingException e){ System.out.println("Error, cause: " + e);}
		  }  
	}


