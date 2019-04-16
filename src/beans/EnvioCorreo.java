package beans;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.UUID;

import javax.activation.DataHandler;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

public class EnvioCorreo {

	Properties emailProperties;
	Session mailSession;
	MimeMessage emailMessage;
	
	String emailHost = "smtp.gmail.com";
	String fromUser = "actividadestob@gmail.com";
	String fromUserEmailPassword = "Proyecto2019";

	public static void main(String args[]) throws AddressException, MessagingException, IOException {
		String pCorreoRecipiente = "<brandon.sce@gmail.com>";
		//String pCorreoRecipiente = "<Masissara12@gmail.com>";
		//String pCorreoRecipiente = "<sergiozelos@gmail.com>";
		//String pCorreoRecipiente = "<alejandro.r.13@hotmail.com>";
		String pNombreActividad = "Cloud Computing";
		String pFechaActividad = "15/04/2019";
		String pHoraActividad = "11:00 - 13:00";
		String pEncargadoActividad = "Julian Solano";
		
		String[] pDetallesActividad = {pNombreActividad,pFechaActividad,pHoraActividad,pEncargadoActividad};
		
		EnvioCorreo correo = new EnvioCorreo();
		correo.setMailServerProperties();
		//correo.crearCorreoConfirmacion(pCorreoRecipiente,pDetallesActividad);
		//correo.crearCorreoComprobante(pCorreoRecipiente,pDetallesActividad);
		correo.generarInvitacion(pCorreoRecipiente,pDetallesActividad);
		correo.enviarCorreo();
	}

	public void setMailServerProperties() {
		String emailPort = "465";//gmail's smtp port
		emailProperties = System.getProperties();
		emailProperties.put("mail.smtp.port", emailPort);
		emailProperties.put("mail.smtp.auth", "true");
		emailProperties.put("mail.smtp.starttls.enable", "true");
	}

	public void crearCorreoConfirmacion(String pCorreoRecipiente,String[] pDetallesActividad) throws AddressException, MessagingException{
		String pTituloCorreo = "Correo Confirmacion Actividad TOB";
		String pTextoCorreo = "<h1>Bienvenido al TOB!</h1><h2><p>Detalles de la actividad: </p></h2><ul><li>Nombre de la Actividad: "+pDetallesActividad[0]+"</li><li>Fecha: "+pDetallesActividad[1]+"</li><li>Hora: "+pDetallesActividad[2]+"</li><li>Encargado: "+pDetallesActividad[3]+"</li></ul><p>Por favor confirmar su participacion a la actividad a continuación.</p><button>Confirmar</button><p><b>Actividades TOB<br></b>Tecnologico de Costa Rica</p>";
		
		generarCuerpoCorreo(pCorreoRecipiente,pTituloCorreo,pTextoCorreo);
	}
	
	public void crearCorreoComprobante(String pCorreoRecipiente,String[] pDetallesActividad) throws AddressException, MessagingException{
		String pTituloCorreo = "Correo Comprobante Actividad TOB";
		String pTextoCorreo = "<h1>Bienvenido al TOB!</h1><h2><p>Detalles de la actividad: </p></h2><ul><li>Nombre de la Actividad: "+pDetallesActividad[0]+"</li><li>Fecha: "+pDetallesActividad[1]+"</li><li>Hora: "+pDetallesActividad[2]+"</li><li>Encargado: "+pDetallesActividad[3]+"</li></ul><p>Te esperamos!</p><b>Actividades TOB<br></b>Tecnologico de Costa Rica</p>";
		
		generarCuerpoCorreo(pCorreoRecipiente,pTituloCorreo,pTextoCorreo);
	}
	
	public void generarCuerpoCorreo(String pCorreoRecipiente, String pTituloCorreo, String pTextoCorreo) throws AddressException, MessagingException {
		System.out.println(pCorreoRecipiente);
		mailSession = Session.getDefaultInstance(emailProperties, null);
		emailMessage = new MimeMessage(mailSession);
		emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(pCorreoRecipiente));
		emailMessage.setSubject(pTituloCorreo);
		emailMessage.setContent(pTextoCorreo, "text/html");
	}
	
	public void generarInvitacion(String pCorreoRecipiente, String[] pDetallesActividad) throws AddressException, MessagingException, IOException {
		mailSession = Session.getDefaultInstance(emailProperties, null);
		emailMessage = new MimeMessage(mailSession);
		emailMessage.addHeaderLine("method=REQUEST");
		emailMessage.addHeaderLine("charset=UTF-8");
		emailMessage.addHeaderLine("component=VEVENT");
		emailMessage.setSubject("Actividad Cloud Computing TOB");
		emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(pCorreoRecipiente));
		//emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(pCorreoRecipiente));
		//emailMessage.setSubject(pTituloCorreo);
		//emailMessage.setContent(pTextoCorreo, "text/html");
		
		String pTextoCorreo = "Bienvenido al TOB! Enviamos una invitacion formal para su participación a la actividad llamada "+pDetallesActividad[0]+" la cual se realizará el "+pDetallesActividad[1]+" en horario de "+pDetallesActividad[2]+". El encargado de la actividad será "+pDetallesActividad[3]+". Te esperamos!";

		UUID id = UUID.randomUUID();
		System.out.print(id);;
		StringBuffer sb = new StringBuffer();
		StringBuffer buffer = sb.append("BEGIN:VCALENDAR\n"+
	            "PRODID:-//Microsoft Corporation//Outlook 9.0 MIMEDIR//EN\n"+
	            "VERSION:2.0\n" +
	            "METHOD:REQUEST\n" +
	            "BEGIN:VEVENT\n" +
	            "ORGANIZER:MAILTO:actividadestob@gmail.com\n" +
	            "DTSTART;TZID=America/Costa_Rica:20190416T152800\n" +
	            "DTEND;TZID=America/Costa_Rica:20190416T191500\n" +
	            "LOCATION:Tecnologico de Costa Rica\n" +
	            "TRANSP:OPAQUE\n" +
	            "SEQUENCE:0\n" +
	            "UID:"+id+"\n" +
	            " 000004377FE5C37984842BF9440448399EB02\n" +
	            "DTSTAMP:20190416T150000Z\n" +
	            "CATEGORIES:Meeting\n" +
	            "DESCRIPTION:"+pTextoCorreo+"\n" +
	            "SUMMARY:Invitacion a la actividad del TOB.\n" +
	            "PRIORITY:5\n" +
	            "CLASS:PUBLIC\n" +
	            "BEGIN:VALARM\n" +
	            "TRIGGER:PT1440M\n" +
	            "ACTION:DISPLAY\n" +
	            "DESCRIPTION:Reminder\n" +
	            "END:VALARM\n" +
	            "END:VEVENT\n" +
	            "END:VCALENDAR");
		
		// Create the message part
        BodyPart messageBodyPart = new MimeBodyPart();

        // Fill the message
        messageBodyPart.setHeader("Content-Class", "urn:content-classes:calendarmessage");
        messageBodyPart.setHeader("Content-ID","calendar_message");
        //messageBodyPart.setContent(pTextoCorreo, "text/html; charset=utf-8");
        messageBodyPart.setContent(pTextoCorreo, "text/html");
        messageBodyPart.setDataHandler(new DataHandler(
        new ByteArrayDataSource(buffer.toString(), "text/calendar")));//very important


        // Create a Multipart
        Multipart multipart = new MimeMultipart();

        // Add part one
        multipart.addBodyPart(messageBodyPart);



        // Put parts in message
        emailMessage.setContent(multipart);
        //emailMessage.setContent(multipart, "text/html; charset=utf-8");
	}
	
	//En caso de ser una lista de correos.
	/*String[] toEmails = { pCorreoRecipiente };
	for (int i = 0; i < toEmails.length; i++) {
		emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
	}*/
	
	
	public void enviarCorreo() throws AddressException, MessagingException {
		Transport transport = mailSession.getTransport("smtp");
		transport.connect(emailHost, fromUser, fromUserEmailPassword);
		transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
		transport.close();
		System.out.println("Email sent successfully.");
	}

}   