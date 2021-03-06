package Be.Debo.Menu;

import java.util.List;

public class User {
	
	private String Nom;
	private String Prenom;
	private String Sexe;
	private IDAO_USERS db;
	
	public String getNom() {
		return this.Nom;
	}
	public String getPrenom() {
		return this.Prenom;
	}
	public String getSexe() {
		return this.Sexe;
	}

	public User (String Nom ,String Prenom ,String Sexe){
		this.Nom = Nom;
		this.Prenom = Prenom;
		this.Sexe = Sexe;
	}
	
	public User (IDAO_USERS db){
		this.db = db;
	}
	
	public  List<User> getUsers(){
		try {
			return db.getUsers();
		}catch(Exception err) {
			return null;
		}
	}
	
	@Override
	public String toString() {
		return this.Nom+" | "+this.Prenom+" | "+this.Sexe;
	}
	
}
