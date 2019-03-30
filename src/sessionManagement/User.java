package sessionManagement;

public final class User {
	private String login;
	private String password;
	private String id;
	private String rights;	//admin, editor, standard
	
	public User (String login, String password, String id, String rights) {
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


	public String getRights() {
		return rights;
	}


	public void setRights(String rights) {
		this.rights = rights;
	}
}
