package Be.Debo.Menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class DAO_USERS implements IDAO_USERS {
	
	private static DAO_USERS instance = null;
	private Connection db;
	private Statement stmt;
	
	
	public  DAO_USERS() {
		// Init of the database
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			String url ="jdbc:ucanaccess://./Inscription.accdb";
			this.db = DriverManager.getConnection(url);
			this.stmt = db.createStatement();
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Error "+ ex.getMessage());
			System.exit(0);
		}
	}
	
	public List<User> getUsers() throws SQLException {
		// Getting the list of the users
		System.out.println("GETTING USERS");
		List<User> Users = new ArrayList<User>();
		try {
			String query  = "SELECT Nom,Prenom,Sexe from Utilisateur";
			ResultSet res = this.stmt.executeQuery(query);
			while(res.next()) {
				User user = new User(res.getString(1) , res.getString(2) , res.getString(3));
				Users.add(user);
			}	
			return Users;
		}catch(SQLException err) {
			System.out.println(err.getMessage());
			return null;
		}
		
	}
	
	
}
