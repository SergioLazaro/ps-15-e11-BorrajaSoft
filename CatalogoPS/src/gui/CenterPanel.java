package gui;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import façade.Clothes;

/**
 * Class that manages the Bottom-Center Panel in the GUI
 * 
 * @author Hijus
 *
 */
public class CenterPanel {
   private JLayeredPane layeredPane;
   private JList<Clothes> list;
   private DefaultListModel<Clothes> model;

   /**
    * -- Constructor -- Creates the Bottom-Center Panel
    * 
    * @param parent
    * @param scroll
    * @param array
    */
   public CenterPanel(JLayeredPane parent, ArrayList<Clothes> array) {
      this.layeredPane = parent;
      model = new DefaultListModel<Clothes>();
      if (array != null) {
         for (Clothes o : array) {
            model.addElement(o);
         }
      }
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(173, 225, 291, 221);
      layeredPane.add(scrollPane);

      list = new JList<Clothes>(model);
      list.setBackground(new Color(255, 215, 0)); // yellow
      // list.setBackground(Color.BLUE);//new Color(255, 215, 0));
      list.setForeground(Color.BLACK);
      scrollPane.setViewportView(list);
      list.setVisible(true);
   }

   /**
    * 
    * @param array
    */
   public void replace(ArrayList<Clothes> array) {
      list.setVisible(false);
      model.removeAllElements();
      if (array != null) {
         for (Clothes o : array) {
            model.addElement(o);
         }
      }
      list.setVisible(true);
   }

   /**
    * 
    * @param array
    */
   public void update(ArrayList<Clothes> array) {
      list.setVisible(false);
      if (array != null) {
         for (Clothes o : array) {
            model.addElement(o);
         }
      }
      list.setVisible(true);
   }
}
