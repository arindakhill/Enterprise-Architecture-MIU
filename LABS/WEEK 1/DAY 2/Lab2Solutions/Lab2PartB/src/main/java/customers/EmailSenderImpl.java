package customers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderImpl implements EmailSender {

	@Value(" ${smtpserver}")
	String outgoingMailServer;

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
