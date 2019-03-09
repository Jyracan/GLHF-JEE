package DataAccessObjects;
import java.util.Date;

public class Etudiant 
{
	private String id;
	private String sexe;
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private String serieBac;
	private int anneeBac;
	private String mentionBac;
	private String  diplome;
	private int anneeDiplome;
	private String villeDiplome;
	private int inscription;
	private String courrielPro;
	private String courrielPerso;
	
	public Etudiant(String id, String sexe, String nom, String prenom, Date dateNaissance, String serieBac,
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
	
	

}
