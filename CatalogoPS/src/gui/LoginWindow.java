package gui;

import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import façade.DataExtraction;

/**
 * Class that manages the Login in the GUI
 * @author Hijus
 *
 */
public class LoginWindow {
	DataExtraction data;
	
	/**
	 * -- Constructor --
	 */
	public LoginWindow(){
		data = new DataExtraction();
	}
	
	/**
	 * Method that implements the login window
	 * @return id of the user or -1 if login fails
	 */
	public int login(){
		int idUser=-1;
		try {
			String usermail = "";
			String password = "";
			SpringLayout layout = new SpringLayout();

		    JPanel panel = new JPanel();
		    panel.setLayout(layout);
		    
			JLabel label1 = new JLabel("User:");
			JTextField usr = new JTextField(12);
			panel.add(label1);
			label1.setLabelFor(usr);
			panel.add(usr);
			
			JLabel label2 = new JLabel("Enter a password:");
			JPasswordField pass = new JPasswordField(12);
			panel.add(label2);
			label2.setLabelFor(pass);
			panel.add(pass);
			
			//Align columns
			layout.putConstraint(SpringLayout.NORTH, pass,5,
		    		  SpringLayout.SOUTH, usr);
			layout.putConstraint(SpringLayout.NORTH, label2,15,
		    		  SpringLayout.SOUTH, label1);
			layout.putConstraint(SpringLayout.SOUTH, panel,5,
		    		  SpringLayout.SOUTH, pass);
			
			//Align rows
			layout.putConstraint(SpringLayout.WEST, usr,5,
		    	      SpringLayout.EAST, label2);
			layout.putConstraint(SpringLayout.WEST, pass,5,
		    		  SpringLayout.EAST, label2);
			layout.putConstraint(SpringLayout.EAST, panel,5,
		    		  SpringLayout.EAST, pass);
			
			
			
			String[] options = new String[]{"OK", "Cancel"};
			int option = JOptionPane.showOptionDialog(null, panel, "Log in",
			                         JOptionPane.NO_OPTION, JOptionPane.PLAIN_MESSAGE,
			                         null, options, options[0]);
			if(option == 0) // pressing OK button
			{
			    usermail = usr.getText();
			    password = new String(pass.getPassword());
			}
			// TODO Maybe hash the password for higher security?
			idUser = data.enter(usermail, password);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return idUser;
	}
}
