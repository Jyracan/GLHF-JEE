package sessionManagement;

public final class User {
	private String login;
	private String password;
	private String id;
	
	public User (String login, String password, String id) {
		this.setLogin(login);
		this.setPassword(password);
		this.id = id;
	}
	
	
	public String getId() {
		return id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
}
