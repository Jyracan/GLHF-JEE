package sessionManagement;

public final class User {
	private String login;
	private String password;
	private String rights;	//admin, editor, standard
	
	public User (String login, String password, String rights) {
		this.setLogin(login);
		this.setPassword(password);
		this.rights = rights;
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
