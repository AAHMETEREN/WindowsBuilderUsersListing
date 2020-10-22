package Be.Debo.Menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Update{

	public Update(ArrayList liste){
		
		try
		{
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			//Class.forName("oracle.jdbc.driver.OracleDriver");
		}
		catch(ClassNotFoundException ex)
		{
			JOptionPane.showMessageDialog(null, "Classe de driver introuvable "+ ex.getMessage());
			System.exit(0);
		
		}
		Connection connec = null;
		Statement stmt=null;
		ResultSet res =null;
		
		try
		{
			String url ="jdbc:ucanaccess://./Inscription.accdb";
			connec = DriverManager.getConnection(url);
			//oracle 
			//DriverManager.getConnection("jdbc:oracle:thin@//char-oracle.condorcet.be:1521/xe","
			try{
				
				String insertion = "INSERT INTO Utilisateur(Nom,Prenom,Sexe) values ('" + liste.get(0)+ "','"+liste.get(1)+"','"+liste.get(2)+"');"; 
				System.out.println(insertion);
				connec.createStatement(
						ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY).executeUpdate(insertion);	
				
			}
			catch(SQLException e){
				e.printStackTrace();
			}
		}
		catch(SQLException ex)
		{
			JOptionPane.showMessageDialog(null,"Erreur JDBC : " +ex.getMessage());
		}
		finally
		{
			try {
				if(res !=null)
					res.close();
				if(stmt !=null)
					stmt.close();
				if(connec !=null)
					connec.close();
			}
			catch(SQLException ex)
			{
				ex.printStackTrace();
			}
		}
		
	}
}