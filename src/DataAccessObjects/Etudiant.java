package DataAccessObjects;

public class Etudiant 
{
	private String id;
	private String sexe;
	private String nom;
	private String prenom;
	private String dateNaissance;
	private String serieBac;
	private int anneeBac;
	private String mentionBac;
	private String  diplome;
	private int anneeDiplome;
	private String villeDiplome;
	private int inscription;
	private String courrielPro;
	private String courrielPerso;
	
	public Etudiant(String id, String sexe, String nom, String prenom, String dateNaissance, String serieBac,
			int anneeBac, String mentionBac, String diplome, int anneeDiplome, String villeDiplome, int inscription,
			String courrielPro, String courrielPerso) {
		this.id = id;
		this.sexe = sexe;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.serieBac = serieBac;
		this.anneeBac = anneeBac;
		this.mentionBac = mentionBac;
		this.diplome = diplome;
		this.anneeDiplome = anneeDiplome;
		this.villeDiplome = villeDiplome;
		this.inscription = inscription;
		this.courrielPro = courrielPro;
		this.courrielPerso = courrielPerso;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getSerieBac() {
		return serieBac;
	}

	public void setSerieBac(String serieBac) {
		this.serieBac = serieBac;
	}

	public int getAnneeBac() {
		return anneeBac;
	}

	public void setAnneeBac(int anneeBac) {
		this.anneeBac = anneeBac;
	}

	public String getMentionBac() {
		return mentionBac;
	}

	public void setMentionBac(String mentionBac) {
		this.mentionBac = mentionBac;
	}

	public String getDiplome() {
		return diplome;
	}

	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}

	public int getAnneeDiplome() {
		return anneeDiplome;
	}

	public void setAnneeDiplome(int anneeDiplome) {
		this.anneeDiplome = anneeDiplome;
	}

	public String getVilleDiplome() {
		return villeDiplome;
	}

	public void setVilleDiplome(String villeDiplome) {
		this.villeDiplome = villeDiplome;
	}

	public int getInscription() {
		return inscription;
	}

	public void setInscription(int inscription) {
		this.inscription = inscription;
	}

	public String getCourrielPro() {
		return courrielPro;
	}

	public void setCourrielPro(String courrielPro) {
		this.courrielPro = courrielPro;
	}

	public String getCourrielPerso() {
		return courrielPerso;
	}

	public void setCourrielPerso(String courrielPerso) {
		this.courrielPerso = courrielPerso;
	}
	
	

}
