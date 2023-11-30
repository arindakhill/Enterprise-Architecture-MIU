package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderImpl implements EmailSender {

	String outgoingMailServer = "smtp.acme.com";

	@Autowired
	private Logger logger ;

	public String getOutgoingMailServer() {
		return outgoingMailServer;
	}

	public void sendEmail (String email, String message){
		System.out.println("EmailSender: sending '"+message+"' to "+email );
		logger.log("Email is sent: message= "+message +" , emailaddress ="+ email  );
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}
	
}
