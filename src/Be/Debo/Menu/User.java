package Be.Debo.Menu;

import java.util.List;

public class User {
	
	private String Nom;
	private String Prenom;
	private String Sexe;
	private DAO_USERS db;
	
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
		this.db = DAO_USERS.getInstance();
	}
	
	public User (){
		this.db = DAO_USERS.getInstance();
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
