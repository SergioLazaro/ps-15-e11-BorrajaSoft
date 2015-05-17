package gui;

/*
 * DEPRECATED -- FOR TEST ONLY
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class Interface {
   private JFrame frmCatlogoTextil;

   /**
    * Create the application.
    */
   public Interface() {
      initialize();
   }

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Interface window = new Interface();
               window.frmCatlogoTextil.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Initialise the contents of the frame.
    */
   private void initialize() {
      frmCatlogoTextil = new JFrame();
      frmCatlogoTextil.setTitle("Cat\u00E1logo textil");
      frmCatlogoTextil.setBounds(100, 100, 723, 490);
      frmCatlogoTextil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frmCatlogoTextil.getContentPane().setLayout(null);

      JSplitPane splitPane = new JSplitPane();
      splitPane.setBounds(40, 83, -155, -36);
      frmCatlogoTextil.getContentPane().add(splitPane);
   }
}
