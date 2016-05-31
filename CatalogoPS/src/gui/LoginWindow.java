package gui;

import facade.DataExtraction;
import facade.DataInsertion;

import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import database.DataAccess;

public class LoginWindow {   
   /**
    * Creates the login window.
    */
   public LoginWindow() {
   }

   /**
    * Implements the login window.
    *
    * @return the id of the user logged
    *         -1 if login fails
    */
   public int login() {
      int idUser = -1;
      try {
         SpringLayout layout = new SpringLayout();
         UIManager.put("OptionPane.background", new ColorUIResource(Colors.PANEL_BACKGROUND));
         UIManager.put("Panel.background", new ColorUIResource(Colors.PANEL_BACKGROUND));
         JPanel panel = new JPanel();

         // Create window.
         // panel.setBackground(Colors.background2);
         panel.setLayout(layout);
         JLabel label1 = new JLabel("User:");
         JTextField usr = new JTextField(12);
         panel.add(label1);
         label1.setLabelFor(usr);
         panel.add(usr);
         
         JLabel label2 = new JLabel("Password:");
         JPasswordField pass = new JPasswordField(12);
         panel.add(label2);
         label2.setLabelFor(pass);
         panel.add(pass);
         
         JLabel label3 = new JLabel("DB Password:");
         JPasswordField dbPass = new JPasswordField(12);
         panel.add(label3);
         label3.setLabelFor(dbPass);
         panel.add(dbPass);
         

         // Align columns
         layout.putConstraint(SpringLayout.NORTH, pass, 5, SpringLayout.SOUTH, usr);
         layout.putConstraint(SpringLayout.NORTH, label1, 5, SpringLayout.NORTH, usr);
         layout.putConstraint(SpringLayout.NORTH, label2, 5, SpringLayout.NORTH, pass);
         layout.putConstraint(SpringLayout.NORTH, label3, 5, SpringLayout.NORTH, dbPass);
         layout.putConstraint(SpringLayout.NORTH, dbPass, 5, SpringLayout.SOUTH, pass);
         layout.putConstraint(SpringLayout.SOUTH, panel, 5, SpringLayout.SOUTH, dbPass);


         // Align rows
         layout.putConstraint(SpringLayout.WEST, usr, 5, SpringLayout.EAST, label3);
         layout.putConstraint(SpringLayout.WEST, pass, 5, SpringLayout.EAST, label3);
         layout.putConstraint(SpringLayout.WEST, dbPass, 5, SpringLayout.EAST, label3);
         layout.putConstraint(SpringLayout.EAST, panel, 5, SpringLayout.EAST, pass);
         String[] options = new String[] { "OK", "Cancel" };

         int option = JOptionPane.showOptionDialog(null, panel, "Log in", JOptionPane.NO_OPTION,
                  JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

         if (option == 0) // pressing OK button
         {
            String username = usr.getText();
            String password = new String(pass.getPassword());
            try{
            	DataAccess mda = new DataAccess(new String(dbPass.getPassword()));
            	HomeWindow.setDataAccess(mda);
            	HomeWindow.setDataEx(new DataExtraction(mda));
            	HomeWindow.setDataIn(new DataInsertion(mda));
            } catch (SQLException e){
            	
            }
            if (!(username.equals("") || password.equals(""))){
            	idUser = HomeWindow.getDataEx().login(username, password);
            }
         } else {
            idUser = -2;
         }
      } catch (SQLException e1) {
         e1.printStackTrace();
      }
      return idUser;
   }
}
