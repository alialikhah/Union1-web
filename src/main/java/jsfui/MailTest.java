package jsfui;

import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


@Named
@RequestScoped
public class MailTest {

	public MailTest() {
		// TODO Auto-generated constructor stub
	}

    @Resource(name = "java:jboss/mail/Default")
    private Session sessionSend;
    
    public void send() throws AddressException, MessagingException {
        Message message = new MimeMessage(sessionSend);
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("ali_alikhahasl@yahoo.com"));
        message.setSubject("ali subject");
        String msg="<h1>SALAM</h1><br/>";
        msg+="<input type='button' value='aliam'/><br/>";
        msg+="<h2>bye</h2>";
        message.setContent(msg,"text/html");
        Transport.send(message);
}
    
}
