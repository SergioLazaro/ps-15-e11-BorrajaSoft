package gui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;

import facade.DataExtraction;
import facade.Product;

/**
 * Class that manages the Right panels in the GUI
 */
public class RightPanel {
   private DataExtraction data;
   private int idUser;
   private JLayeredPane layeredPane;
   private DefaultListModel<Product> mCart; // To be used, to update
   private DefaultListModel<Product> mHistory;
   private JList<Product> shoppingCartList;
   private JList<Product> historyList;


   /**
    * Constructor
    * 
    * @param panel main panel of the application
    * @param usr   user identifier, obtained on login
    */
   public RightPanel(int usr) {
      layeredPane = HomeWindow.getLayeredPane();
      idUser = usr;
      data = new DataExtraction();
      mCart = new DefaultListModel<Product>();
      mHistory = new DefaultListModel<Product>();
      initialize();
   }

   /**
    * Method that generates both the Shopping Cart and the History Panels in the GUI
    */
   private void initialize() {
      JScrollPane shoppingCartScroll = new JScrollPane();
      shoppingCartScroll.setBounds(558, 124, 238, 290);
      layeredPane.add(shoppingCartScroll);

      ArrayList<Product> array = null;
      try {
         array = data.getShoppingCart(idUser);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      if (array != null) {
         for (Product o : array) {
            mCart.addElement(o);
         }

      }
      shoppingCartList = new JList<>(mCart);

      shoppingCartList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
      shoppingCartScroll.setViewportView(shoppingCartList);
      shoppingCartList.setBackground(new Color(255, 255, 255));
      
    //Add listener to list
      shoppingCartList.addMouseListener(new MouseAdapter() {
    	    public void mouseClicked(MouseEvent evt) {
    	        customMouseHandler(evt);
    	    }

			
    	});

      JScrollPane scrollHistory = new JScrollPane();
      scrollHistory.setBounds(558, 415, 237, 290);
      layeredPane.add(scrollHistory);

      // Taking the worker historical registry
      try {
         array = data.getOrderRecord(idUser);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      if (array != null) {
         for (Product o : array) {
            mHistory.addElement(o);
         }
      }
      historyList = new JList<Product>(mHistory);
      historyList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
      scrollHistory.setViewportView(historyList);
      historyList.setBackground(new Color(255, 255, 255));
   }
   
   /**
    * Custom mouse handler for the elements clicked on the center JList
    * @param evt
    */
	private void customMouseHandler(MouseEvent evt) {
		System.out.println("ENTRO AL HANDLER");
		@SuppressWarnings("unchecked")
		JList<Product> list = (JList<Product>)evt.getSource();
		if (evt.getClickCount() != 0) {
            Product selected = list.getSelectedValue();
            if(selected!=null) HomeWindow.getTop().updateFromCart(selected);
        }					
	}
   
   public void updateShoppingCart(){
	   mCart.clear();
	   ArrayList<Product> array = null;
	   try {
	         array = data.getShoppingCart(idUser);
	   } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	   }
	   if (array != null) {
		   for (Product o : array) {
	            mCart.addElement(o);
	       }
	   }
	   shoppingCartList = new JList<Product>(mCart);
	   layeredPane.add(shoppingCartList);  
   }
   
   /**
    * 
    * Method that implements the actionListener over the CenterPanelList (Center)
    * 
    * @param evt Event to search.
    * @param top The principal panel.
    */
   public void shoppingCartListChanged(ListSelectionEvent evt, TopPanel top) {
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
               top.updateFromCart(select);
            }
         } catch (NullPointerException e) {
            e.printStackTrace();
         }
      }
   }
   
   /**
    * 
    * Method that implements the actionListener over the CenterPanelList (Center)
    * 
    * @param evt Event to search.
    * @param top The principal panel.
    */
   public void historyListChanged(ListSelectionEvent evt, TopPanel top) {
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
         } catch (NullPointerException e) {
            e.printStackTrace();
         }
      }
   }
   
   public JList getShoppingCartList(){
	   return shoppingCartList;
   }
   
   public JList getHistoryList(){
	   return historyList;
   }
}
