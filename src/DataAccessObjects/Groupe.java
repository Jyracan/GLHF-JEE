package DataAccessObjects;

public class Groupe {
	private String idGroupe;
	private String nomGroupe;
	private String redacteur;
	
	public Groupe (String idGroupe, String nomGroupe, String redacteur) {
		this.idGroupe = idGroupe;
		this.nomGroupe=nomGroupe;
		this.redacteur=redacteur;
	}

	public String getIdGroupe() {
		return idGroupe;
	}

	public void setIdGroupe(String idGroupe) {
		this.idGroupe = idGroupe;
	}

	public String getNomGroupe() {
		return nomGroupe;
	}

	public void setNomGroupe(String nomGroupe) {
		this.nomGroupe = nomGroupe;
	}

	public String getRedacteur() {
		return redacteur;
	}

	public void setRedacteur(String redacteur) {
		this.redacteur = redacteur;
	}
	

}
