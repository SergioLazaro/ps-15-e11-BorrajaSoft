package gui;

/*
 * File: Interface.java
 * Version: 1.0
 * Author: Víctor Sánchez
 */

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

@Deprecated
public class Interface {
   private JFrame frmCatlogoTextil;
   private JTabbedPane tabbedPane;

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
    * Initialize the contents of the frame.
    */
   private void initialize() {
      // frame.add(new TabbedPaneDemo(), BorderLayout.CENTER);
      frmCatlogoTextil = new JFrame();
      frmCatlogoTextil.setTitle("Cat\u00E1logo textil");
      frmCatlogoTextil.setBounds(100, 100, 723, 490);
      frmCatlogoTextil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // frmCatlogoTextil.getContentPane().setLayout(null);
      // frmCatlogoTextil.pack();
      tabbedPane = new JTabbedPane();
      ImageIcon icon = new ImageIcon(HomeWindow.class.getResource("/photos/LookingFor.jpg"));
      JComponent panel1 = makeTextPanel("Panel #1");
      panel1.add(new JLabel("Prueba", JLabel.CENTER));
      tabbedPane.addTab("Tab 1", icon, panel1, "Does nothing");
      frmCatlogoTextil.add(tabbedPane, BorderLayout.PAGE_START);
      frmCatlogoTextil.setVisible(true);
   }

   /**
    * Initializes the JComponent that represents the panel.
	*/
   protected JComponent makeTextPanel(String text) {
      JPanel panel = new JPanel(false);
      JLabel filler = new JLabel(text);
      filler.setHorizontalAlignment(JLabel.CENTER);
      panel.setLayout(new GridLayout(1, 1));
      panel.add(filler);
      return panel;
   }
}
