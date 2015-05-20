package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SpinnerListModel;
import javax.swing.event.ListSelectionEvent;

import facade.Product;

import javax.swing.JSpinner;

/**
 * Class that manages the Bottom-center Panel in the GUI.
 */
public class CenterPanel {
   private JLayeredPane layeredPane;
   private DefaultListModel<Product> model;
   private JList<Product> list;

   /**
    * Constructor. Creates the bottom center panel.
    * 
    * @param parent The principal banner.
    * @param array The list of products to show in the panel.
    */
   public CenterPanel(JLayeredPane parent, ArrayList<Product> array) {
      this.layeredPane = parent;
      model = new DefaultListModel<Product>();
      if (array != null) {
         for (Product o : array) {
            model.addElement(o);
         }
      }
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(173, 225, 385, 480);
      layeredPane.add(scrollPane);

      list = new JList<Product>(model);
      list.setBackground(new Color(255, 215, 0)); // yellow
      // list.setBackground(Color.BLUE);//new Color(255, 215, 0));
      list.setForeground(Color.BLACK);
      scrollPane.setViewportView(list);
      list.setVisible(true);
      
      //Add the spinner
      TopSpinner spinner = new TopSpinner(layeredPane);
   }

   /**
    * Add a list of products to the panel.
    * 
    * @param array A list of products.
    */
   public void update(ArrayList<Product> array) {
      list.setVisible(false);
      if (array != null) {
         for (Product o : array) {
            model.addElement(o);
         }
      }
      list.setVisible(true);
   }

   /**
    * Updates the list of products of the panel.
    * 
    * @param array The new list of products.
    */
   public void replace(ArrayList<Product> array) {
      model.clear();
      if (array != null) {
         for (Product o : array) {
            model.addElement(o);
         }
      }
      list.updateUI();
   }

   /**
    * Return the list of products in the panel.
    * 
    * @return A list of products.
    */
   public JList<Product> getList() {
      return list;
   }

   /**
    * 
    * Method that implements the actionListener over the CenterPanelList (Center)
    * 
    * @param evt Event to search.
    * @param top The principal panel.
    */
   public void centerValueChanged(ListSelectionEvent evt, TopPanel top) {
      // TODO Auto-generated method stub
      if (!evt.getValueIsAdjusting()) {
         try {
            JList<?> prueba = (JList<?>) evt.getSource();
            if (prueba == null) {
               System.out.println("\nla lista es nula");
            }
            System.out.println("\nLa lista es " + prueba);
            Product select = (Product) prueba.getSelectedValue();
            if (select == null) {
               System.out.println("la prenda es nula");
            } else {
               System.out.println(select);
               top.update(select);
            }
            // Prenda select = (Prenda) ((JList<Prenda>) evt.getSource()).getSelectedValue();
            // String selectString = select.toString();
            // System.out.print("Elemento seleccionado: ");
            // System.out.println(selectString);
         } catch (NullPointerException e) {
            e.printStackTrace();
         }
      }
   }

}
