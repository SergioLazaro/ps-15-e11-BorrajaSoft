package gui;

/*
 * DEPRECATED -- FOR TEST ONLY
 */

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JSplitPane;

public class Interfaz {
   private JFrame frmCatlogoTextil;

   /**
    * Create the application.
    */
   public Interfaz() {
      initialize();
   }

   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
               Interfaz window = new Interfaz();
               window.frmCatlogoTextil.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

   /**
    * Initialize the contents of the frame.
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
