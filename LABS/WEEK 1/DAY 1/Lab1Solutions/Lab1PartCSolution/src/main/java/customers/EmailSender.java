package customers;

public interface EmailSender {
	void sendEmail(String email, String message);
	String getOutgoingMailServer();
	void setLogger(Logger logger);
}