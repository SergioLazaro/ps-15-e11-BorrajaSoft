package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;
import javax.swing.border.BevelBorder;

import facade.DataExtraction;
import facade.Product;

/**
 * Class that manages the Right panels in the GUI
 * 
 * @author Hijus
 *
 */
public class RightPanel {
   private DataExtraction data;
   private JList historyList;
   private int idUser;
   private JLayeredPane layeredPane;
   private DefaultListModel mCart; // To be used, to update
   private DefaultListModel mHistory;
   private JList shoppingCartList;
   
   private ArrayList<Product> products;		// Products in the shoppeng cart
   

   /**
    * -- Constructor --
    * 
    * @param panel
    *           - main panel of the application
    * @param usr
    *           - user identifier, obtained on login
    */
   public RightPanel(JLayeredPane panel, int usr) {
      layeredPane = panel;
      idUser = usr;
      data = new DataExtraction();
      mCart = new DefaultListModel();
      mHistory = new DefaultListModel();
      products = new ArrayList<Product>();
      
      initialize();
   }

   /**
    * Method that generates both the Shopping Cart and the History Panels in the GUI
    */
   private void initialize() {
	   
      JScrollPane shoppingCartScroll = new JScrollPane();
      shoppingCartScroll.setBounds(463, 124, 238, 167);
      layeredPane.add(shoppingCartScroll);

      // Taking the pyme's shopping cart
      /*ArrayList<String> array = null;
      try {
         array = data.getShoppingCart(idUser);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      if (array != null) {
         for (Object o : array) {
            mCart.addElement(o);
         }

      }*/
      
      ArrayList<Product> array = null;
      try {
         array = data.getShoppingCartP(idUser);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      if (array != null) {
         for (Product p : array) {
        	 addToShoppingCart(p);
         }

      }
      
      
      shoppingCartList = new JList<>(mCart);

      shoppingCartList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
      shoppingCartScroll.setViewportView(shoppingCartList);
      shoppingCartList.setBackground(new Color(255, 255, 255));
      
      shoppingCartList.addMouseListener(new MouseAdapter() {		// Sets a double click listener
    	    public void mouseClicked(MouseEvent evt) {
    	        JList list = (JList)evt.getSource();
    	        if (evt.getClickCount() == 2) {

    	            // Double-click detected
    	            int index = list.locationToIndex(evt.getPoint());
    	            removeProduct(index);
    	        } 
    	    }
    	});
      
      
      
      
      JScrollPane scrollHistory = new JScrollPane();
      scrollHistory.setBounds(464, 290, 237, 155);
      layeredPane.add(scrollHistory);

      // Taking the worker historical registry
      try {
          //array = data.getOrderRecord(idUser);
          array = data.getOrderRecordP(idUser);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      if (array != null) {
         for (Object o : array) {
            mHistory.addElement(o);
         }
      }
      historyList = new JList(mHistory);
      historyList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
      scrollHistory.setViewportView(historyList);
      historyList.setBackground(new Color(204, 255, 204));
      
   }
   
   
   
   /**
    * Adds the product p to the shopping cart
    */
   public void addToShoppingCart(Product p) {
	   mCart.addElement("- " + p.getName() + ", " + p.getBrand() + ", " + p.getPrice() + " €");
	   products.add(p);
   }
   
   
   /**
    * Remove the product p from the shopping cart
    */
   public void removeProduct(int index) {
	   mCart.remove(index);
	   Product p = products.remove(index);
   }
   
   
   
}
