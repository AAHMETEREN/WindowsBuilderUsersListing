package Be.Debo.Menu;

//pr taille fenetre
import java.awt.Toolkit;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class DisplayFrame extends JFrame
{
	
	public DisplayFrame() 
	{
		
	}
	public DisplayFrame(ArrayList liste) 
	{
		this.setTitle("Affichage de vos information");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane= new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.pink);
		
		JList zone = new JList(liste.toArray());
		zone.setBounds(10, 22, 150, 182);
		contentPane.add(zone);
		
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		btnQuitter.setBounds(175, 232, 85, 21);
		contentPane.add(btnQuitter);
		
		
		
	}

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		
        
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				
				try 
				{
					
					//---
					
					DisplayFrame frame = new DisplayFrame();
					
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	
}
