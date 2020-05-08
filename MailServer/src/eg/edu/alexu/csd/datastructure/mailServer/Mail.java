package eg.edu.alexu.csd.datastructure.mailServer;

public class Mail implements IMail {
	private String[] body;
	private String from;
	private String to;
	private String subject;
	private Singly_Linked_list attachments = new Singly_Linked_list();
	private String attachlinks[];
	private int priority;
    private String name;
	
	public void setFrom(String sender) {
		from = sender;
	}
	public void setTo(String reciever) {
		to = reciever;
	}
	public void setSubject(String sub) {
		subject = sub;
	}
	public void setBody(String[] email) {
		body = email;
	}
	public void setAttachments(Singly_Linked_list attachment) {
		attachments = attachment;
	}
	public void setAttaclinks(String attach[]) {
		attachlinks=attach;
	}
	public void setPriority(int pr) {
		priority = pr;
	}
	public void setName(String nname) {
		name = nname;
	}

	
	public String getFrom() {
		return from;
	}
	public String getTo() {
		return to;
	}
	public String getSubject() {
		return subject;
	}
	public String[] getBody() {
		return body;
	}
	public Singly_Linked_list getAttachments() {
		return attachments;
	}
	public String[] getAttaclinks() {
		return attachlinks;
	}
	public int getPriority() {
		return priority;
	}
	public String getName() {
		return name;
	}
}
