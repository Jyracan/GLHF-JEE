package sessionManagement;

public final class User {
	private String login;
	private String password;
	private String rights;	//admin, editor, standard
	private String question;
	private String answer;
	
	public User (String login, String password, String rights, String question, String answer) {
		this.setLogin(login);
		this.setPassword(password);
		this.rights = rights;
		this.setQuestion(question);
		this.setAnswer(answer);
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


	public String getAnswer() {
		return answer;
	}


	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
	}
}
