package sms;

public class SmsContent {

	private long messageid;
	private String message;
	private int status;
	private String statustext;
	private String sender;
	private String receptor;
	public long getMessageid() {
		return messageid;
	}
	public void setMessageid(long messageid) {
		this.messageid = messageid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getStatustext() {
		return statustext;
	}
	public void setStatustext(String statustext) {
		this.statustext = statustext;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceptor() {
		return receptor;
	}
	public void setReceptor(String receptor) {
		this.receptor = receptor;
	}
	
	
	
}
