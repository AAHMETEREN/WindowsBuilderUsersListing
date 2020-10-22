package Be.Debo.Menu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Be.Debo.Menu.FrameJv;
import Be.Debo.Menu.DisplayFrame;

public class FrameJv extends JFrame 
{

	private JPanel contentPane;
	private JTextField textNom;
	private JTextField textPrenom;
	private final ButtonGroup buttonGroupSexe = new ButtonGroup();
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
					FrameJv frame = new FrameJv();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public boolean verif() 
	{
		if(textNom.getText().equals(null) || textPrenom.getText().equals("") )
		{
			return false;
		}
		else {
			return true;
		}
	}
	
	private void clearFrame() 
	{
		textNom.setText(null);
		textPrenom.setText(null);
		buttonGroupSexe.clearSelection();
		Component[] comp = (Component[])
				getContentPane().getComponents();
		for(Component var :comp) {
			if(var instanceof JCheckBox ) {
				JCheckBox check =(JCheckBox) var;
				check.setSelected(false);
				
			}
		}
		
	}

	/**
	 * Create the frame.
	 */
	public FrameJv() 
	{
		//*ajout dd
		setTitle("MENU");
		FrameJv me = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFormaulaire = new JLabel("Formulaire");
		lblFormaulaire.setBounds(157, 10, 65, 13);
		contentPane.add(lblFormaulaire);
		
		JLabel lblNom = new JLabel("Nom :");
		lblNom.setBounds(10, 35, 46, 13);
		contentPane.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prenom :");
		lblPrenom.setBounds(225, 35, 65, 13);
		contentPane.add(lblPrenom);
		
		textNom = new JTextField();
		textNom.setBounds(66, 33, 96, 19);
		contentPane.add(textNom);
		textNom.setColumns(10);
		
		textPrenom = new JTextField();
		textPrenom.setBounds(292, 32, 96, 19);
		contentPane.add(textPrenom);
		textPrenom.setColumns(10);
		
		JLabel lblSexe = new JLabel("Sexe :");
		lblSexe.setBounds(10, 71, 46, 13);
		contentPane.add(lblSexe);
		//** ajout dd
		contentPane.setBackground(Color.CYAN);
		//***
		JRadioButton rdbtnM = new JRadioButton("M");
		buttonGroupSexe.add(rdbtnM);
		rdbtnM.setSelected(true);
		rdbtnM.setBounds(62, 67, 35, 21);
		contentPane.add(rdbtnM);
		
		JRadioButton rdbtnF = new JRadioButton("F");
		buttonGroupSexe.add(rdbtnF);
		rdbtnF.setBounds(99, 67, 33, 21);
		contentPane.add(rdbtnF);
		
		JLabel lblChoix = new JLabel("Choix :");
		lblChoix.setBounds(10, 105, 46, 13);
		contentPane.add(lblChoix);
		
		JCheckBox chckbxChoix1 = new JCheckBox("Choix1");
		chckbxChoix1.setBounds(62, 101, 95, 21);
		contentPane.add(chckbxChoix1);
		
		JCheckBox chckbxChoix2 = new JCheckBox("Choix2");
		chckbxChoix2.setBounds(62, 124, 95, 21);
		contentPane.add(chckbxChoix2);
		
		JCheckBox chckbxChoix3 = new JCheckBox("Choix3");
		chckbxChoix3.setBounds(62, 147, 95, 21);
		contentPane.add(chckbxChoix3);
		
		JCheckBox chckbxChoix4 = new JCheckBox("Choix4");
		chckbxChoix4.setBounds(62, 170, 95, 21);
		contentPane.add(chckbxChoix4);
		
		JLabel lblInfo = new JLabel("Info :");
		lblInfo.setBounds(244, 105, 46, 13);
		contentPane.add(lblInfo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(244, 124, 182, 67);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		//'' ajout dd
		textArea.setBackground(Color.lightGray);
		
		JButton btReset = new JButton("Reset");
		btReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearFrame();
				textArea.setText(null);
			}
		});
		btReset.setBounds(10, 232, 85, 21);
		contentPane.add(btReset);
		
		JButton btValider = new JButton("Valider");
		btValider.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean x= verif();
				//List check = new List();
				if(x == true)
				{
						String nom =textNom.getText();
						String prenom =textPrenom.getText();
						String sexe;
						ArrayList check = new ArrayList();
						check.add(nom);
						check.add(prenom);
						if(rdbtnM.isSelected())
						{
							check.add(rdbtnM.getText());
						}
						else
						{
							check.add(rdbtnF.getText());
						}
						
						Update Update = new Update(check);
						//Update.setVisible(true);
						JFrameUsers jFrameUsers = new JFrameUsers();
						jFrameUsers.setVisible(true);
						
						
						me.dispose();
						
				}
				else {
					JOptionPane.showMessageDialog(null,"Veuillez remplire name et firstname");
				}
			}
		});
		btValider.setBounds(341, 232, 85, 21);
		contentPane.add(btValider);
		
		JButton btQuitter = new JButton("Quitter");
		btQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btQuitter.setBounds(351, 6, 85, 21);
		contentPane.add(btQuitter);
	}

}
