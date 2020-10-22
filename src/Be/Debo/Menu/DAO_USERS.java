package Be.Debo.Menu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class DAO_USERS implements IDAO_USERS {
	
	private static DAO_USERS singleton = null;
	private Connection db;
	private Statement stmt;
	
	
	public  DAO_USERS() {
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
	
	public static DAO_USERS getInstance() {
		if(singleton == null) {
			singleton = new DAO_USERS();
		}
		return singleton;
	}
	
	public List<User> getUsers() throws SQLException {
		List<User> Users = new ArrayList<User>();
		ResultSet res;
		try {
			String query  = "SELECT Nom,Prenom,Sexe from Utilisateur";
			System.out.println("GETTING USERS");
			res = this.stmt.executeQuery(query);
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
