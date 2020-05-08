package eg.edu.alexu.csd.datastructure.mailServer;

public class Contact implements IContact {
	private String email;
	private String nickname;
	private String phone;
	private String password;
    public Contact(String mail,String nick,String phonne,String pass) {
    	email=mail;
    	nickname=nick;
    	phone=phonne;
    	password=pass;
    }

	public void setEmail(String name) {
		email = name;
	}
	public void setNickName(String name) {
		nickname = name;
	}
	public void setPhone(String name) {
		phone = name;
	}
	public void setPassword(String pass) {
		password = pass;
	}


	public String getEmail() {
		return email;
	}
	public String getNickName() {
		return nickname;
	}
	public String getPhone() {
		return phone;
	}
	public String getPassword() {
		return password;
	}

}
