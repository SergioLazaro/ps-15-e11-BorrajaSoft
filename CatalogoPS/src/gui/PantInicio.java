package gui;

/*
 * Class that implements the GUI management
 */

import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.TreePath;

import façade.Product;
import façade.DataExtraction;
import façade.Customer;

public class PantInicio {
   private static CenterPanel center;
   private static DataExtraction data;
   private static int idUser;
   private static Menu menu;
   private static ArrayList<Product> productArray;
   private static ArrayList<Customer> customerArray;
   private static RightPanel right;
   private static JButton searchButton;
   // TODO create a class for the search button
   private static JTextField textField;
   private static TopPanel top;
   // TODO Change all those static variables and methods to non-static
   private JFrame frameRopaUltracool;
   private final JLayeredPane layeredPane = new JLayeredPane();

   /**
    * Constructor
    */
   public PantInicio() {
      data = new DataExtraction();
      LoginWindow loginW = new LoginWindow();
      idUser = -1;
      // Show up log-in window
      while (idUser == -1) {
         idUser = loginW.login();
      }
      initialize();

      frameRopaUltracool.setVisible(true);
   }

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      // Event Queue configuration
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               PantInicio window = new PantInicio();
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });

   }

   /**
    * Method that implements the actionListener over the JTree (Menu)
    * 
    * @param tse event
    */
   public void menuValueChanged(TreeSelectionEvent tse) {
      try {
         System.out.println("El nodo es: " + tse.getNewLeadSelectionPath().toString());
         System.out.println(tse.getNewLeadSelectionPath().getPathCount());
         // for (Object i : tse.getNewLeadSelectionPath()){
         //
         // }

         String search = tse.getNewLeadSelectionPath().getLastPathComponent().toString();
         TreePath prueba = tse.getNewLeadSelectionPath().getParentPath();
         while (prueba.getParentPath() != null) {
            search = prueba.getLastPathComponent().toString() + " " + search;
            prueba = prueba.getParentPath();
         }
         productArray = data.basicSearchProducts(search);
         center.replace(productArray);
         System.out.println("El resultado es: " + search);
      } catch (NullPointerException e) {
         System.err.println("se ha clicado en clothes");
      } catch (SQLException e) {
         e.printStackTrace();
      }

   }

   /**
    * Initialise the contents of the frame that implements the main window.
    */
   private void initialize() {
      // Define the frame
      frameRopaUltracool = new JFrame();
      frameRopaUltracool.setIconImage(Toolkit.getDefaultToolkit().getImage(
               PantInicio.class.getResource("/photos/CompanyIcon.jpg")));
      frameRopaUltracool.setTitle("ROPA ULTRA-COOL"); //
      // frameRopaUltracool.setExtendedState(JFrame.MAXIMIZED_BOTH); //MAXIMUM AVAIVABLE SIZE
      frameRopaUltracool.setBounds(100, 100, 717, 484); // SMALL NON-FIXED WINDOW
      frameRopaUltracool.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frameRopaUltracool.getContentPane().setLayout(null);
      layeredPane.setBounds(0, 0, 701, 445);
      frameRopaUltracool.getContentPane().add(layeredPane);

      // Search bar
      textField = new JTextField();
      textField.setBounds(464, 101, 214, 20);
      layeredPane.add(textField);
      textField.setColumns(10);

      // SearchButton
      searchButton = new JButton("");
      searchButton.setIcon(new ImageIcon(PantInicio.class.getResource("/photos/LookingFor.jpg")));
      searchButton.setBounds(681, 101, 20, 20);
      layeredPane.add(searchButton);

      // Clothes tree
      menu = new Menu(layeredPane);

      // Shopping cart & History
      right = new RightPanel(layeredPane, idUser);

      // Logo
      // TODO Choose a functionality for this button
      JButton btnNewButton = new JButton("");
      btnNewButton.setIcon(new ImageIcon(PantInicio.class.getResource("/photos/logo.jpg")));
      btnNewButton.setBounds(105, 11, 227, 102);
      layeredPane.add(btnNewButton);

      // Superior panel
      top = new TopPanel(layeredPane);

      // center panel
      center = new CenterPanel(layeredPane, null);

      // Adds the actionListeners
      listeners();
   }

   /**
    * Method that adds the actionListeners
    */
   private void listeners() {
      // Search Button Listener
      searchButton.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent ae) {
            String text = textField.getText();

            try {
               productArray = data.basicSearchProducts(text);
               customerArray = data.searchCustomers(text);
               textField.setText("");
               center.replace(productArray);

            } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
               //
            }
         }
      });
      // Menu actionListener
      menu.getTree().addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
         public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
            menuValueChanged(evt);
         }
      });
      // Center actionListener
   		center.getList().addListSelectionListener(new javax.swing.event.ListSelectionListener() {
   			public void valueChanged(ListSelectionEvent evt) {
   				center.centerValueChanged(evt, top);
   			}
   		});
   }
}
