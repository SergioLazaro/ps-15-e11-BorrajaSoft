package gui;

import java.awt.Color;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * Class that manages the Top panel in the GUI
 */
public class BannerPanel {
   private JLayeredPane layeredPane;

   /**
    * Constructor
    * 
    * @param panel The object where the banner is inserted.
    */
   public BannerPanel(JLayeredPane panel) {
      layeredPane = panel;
      initialize();
   }

   /**
    * Method that initialises the top panel
    */
   private void initialize() {
      JScrollPane scrollPane1 = new JScrollPane();
      scrollPane1.setBounds(173, 124, 291, 102);
      layeredPane.add(scrollPane1);
      JList focus = new JList();
      focus.setBackground(new Color(0, 195, 240));
      focus.setForeground(Color.BLACK);
      scrollPane1.setViewportView(focus);
      focus.setVisible(true);
   }
}
