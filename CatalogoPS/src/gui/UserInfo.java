package gui;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import facade.Customer;

public class UserInfo extends JPanel implements ActionListener {
   private static final long serialVersionUID = 1L;
   private JButton cancel;
   private JPanel control, fields;
   private Customer customer;
   private JLabel[] errorLabel;
   private JTextField name, lName, mail, address, phone;
   private JPasswordField password, cPassword;
   private JButton update;

   /**
    * Creates the user info panel.
    */
   public UserInfo() {
      initialize();
   }

   @Override
   public void actionPerformed(ActionEvent evt) {
      switch (evt.getActionCommand()) {
         case "cancel":
            initialize();
            break;
         case "update":
            if (!new String(password.getPassword()).equals(new String(cPassword.getPassword()))) {
               // System.out.println("pass = [" + new String(password.getPassword()) + "] cpass = ["
               // + new String(cPassword.getPassword()) + "]");
               errorLabel[5].setText(" Passwords doesn't");
               errorLabel[5].setForeground(Color.red);
               errorLabel[6].setText(" match");
               errorLabel[6].setForeground(Color.red);
               password.selectAll();
               password.requestFocusInWindow();
            } else {
               customer.setDeliveringAddress(address.getText());
               customer.setMailAddress(mail.getText());
               customer.setTelephone(phone.getText());
               customer.setPassword(new String(password.getPassword()));
               try {
                  HomeWindow.getDataIn().updateUserInfo(customer);
                  initialize();
               } catch (SQLException e) {
                  e.printStackTrace();
               }
            }
            this.updateUI();
            break;
      }
   }

   private void initialize() {
      this.removeAll();
      this.setOpaque(false);
      fields = new JPanel(new GridLayout(0, 6));
      fields.setOpaque(false);
      control = new JPanel(new GridLayout(15, 5));
      control.setOpaque(false);
      errorLabel = new JLabel[7];
      update = new JButton("Update");
      update.setActionCommand("update");
      update.addActionListener(this);
      cancel = new JButton("Cancel");
      cancel.setActionCommand("cancel");
      cancel.addActionListener(this);
      for (int j = 0; j < 80; j++) {
         if (j == 2) {
            control.add(update);
         } else if (j == 3) {
            control.add(cancel);
         } else {
            control.add(new JLabel(" "));
         }
      }
      setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
      add(fields);
      add(control);
      // this.setLayout(BorderLayout.);
      String[] labelsArray = { "First Name", "Last Name", "Mail Address", "Delivering Address",
               "Phone Number", "Password", "Confirm Password" };
      customer = new Customer(HomeWindow.getIdUser(), "", "", "", "", "", "");
      try {
         customer = HomeWindow.getData().getCustomerInfo(HomeWindow.getIdUser());
      } catch (SQLException e) {
         e.printStackTrace();
      }
      for (int j = 0; j < 12; j++) {
         fields.add(new JLabel(" "));
      }
      for (int i = 0; i < labelsArray.length; i++) {
         fields.add(new JLabel(" "));
         fields.add(new JLabel(" "));
         fields.add(new JLabel(labelsArray[i]));
         switch (labelsArray[i]) {
            case "First Name":
               name = new JTextField(customer.getName());
               name.setEditable(false);
               name.setAlignmentX(JTextField.RIGHT_ALIGNMENT);
               fields.add(name);
               break;
            case "Last Name":
               lName = new JTextField(customer.getSurname());
               lName.setEditable(false);
               fields.add(lName);
               break;
            case "Mail Address":
               mail = new JTextField(customer.getMailAddress());
               fields.add(mail);
               break;
            case "Delivering Address":
               address = new JTextField(customer.getDeliveringAddress());
               fields.add(address);
               break;
            case "Phone Number":
               phone = new JTextField(customer.getTelephone());
               fields.add(phone);
               break;
            case "Password":
               password = new JPasswordField();
               fields.add(password);
               break;
            case "Confirm Password":
               cPassword = new JPasswordField();
               fields.add(cPassword);
               break;
         }
         fields.add(errorLabel[i] = new JLabel(" "));
         fields.add(new JLabel(" "));
      }
   }
}
