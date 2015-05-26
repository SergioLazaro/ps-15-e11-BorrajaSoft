package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.event.ListSelectionEvent;
import facade.DataExtraction;
import facade.DataInsertion;
import facade.Order;
import facade.OrderRecord;
import facade.Product;

public class RightPanel {
   private static DataExtraction data;
   private static DataInsertion dataIns;
   private static ArrayList<Order> history;
   private static JList<Order> historyList;
   private static int idUser;
   private static JPanel layeredPane;
   private static DefaultListModel<Product> mCart; // To be used, to update
   private static DefaultListModel<Order> mHistory;
   private static ArrayList<Product> order;
   private static JList<Product> shoppingCartList;

   /**
    * Creates the right panel of the application.
    * 
    * @param usr
    *           user identifier, obtained on login
    */
   public RightPanel(int usr) {
      layeredPane = HomeWindow.getLayeredPane();
      idUser = usr;
      data = new DataExtraction();
      mCart = new DefaultListModel<Product>();
      mHistory = new DefaultListModel<Order>();
      dataIns = new DataInsertion();
      initialize();
   }

   /**
    * Add an element to the user order.
    * 
    * @throws SQLException
    */
   public static void addToHistory() throws SQLException {
      Date d = new Date();
      String date = (d.getYear() + 1900) + "-" + (d.getMonth() + 1) + "-" + d.getDate();
      double price = 0.0;
      for (Product p : order) {
         price += p.getPrice();
      }
      Order o = new Order(1, idUser, date, price);
      int orderId = dataIns.insertOrder(o);
      for (Product p : order) {
         OrderRecord or = new OrderRecord(orderId, 0, p.getProductID(), p.getStock(), -1);
         dataIns.insertOrderRecord(or);
      }
      dataIns.deleteShoppingCart(idUser);
      updateShoppingCart();
   }

   /**
    * Update the recent order list of the active user.
    */
   public static void updateHistoryList() {
      mHistory.clear();
      try {
         history = data.getOrders(idUser);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      if (history != null) {
         for (Order o : history) {
            mHistory.addElement(o);
         }
      }
      historyList = new JList<Order>(mHistory);
      layeredPane.add(historyList);
   }

   /**
    * Update the shopping cart of the active user.
    */
   public static void updateShoppingCart() {
      mCart.clear();
      try {
         order = data.getShoppingCart(idUser);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      if (order != null) {
         for (Product o : order) {
            mCart.addElement(o);
         }
      }
      shoppingCartList = new JList<Product>(mCart);
      layeredPane.add(shoppingCartList);
   }

   public JList getHistoryList() {
      return historyList;
   }

   public JList getShoppingCartList() {
      return shoppingCartList;
   }

   /**
    * 
    * Method that implements the actionListener over the CenterPanelList (Center)
    * 
    * @param evt
    *           Event to search.
    * @param top
    *           The principal panel.
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
    * Custom mouse handler for the elements clicked on the center JList
    * 
    * @param evt
    */
   private void customMouseHandler(MouseEvent evt) {
      System.out.println("ENTRO AL HANDLER");
      @SuppressWarnings("unchecked")
      JList<Product> list = (JList<Product>) evt.getSource();
      if (evt.getClickCount() != 0) {
         Product selected = list.getSelectedValue();
         if (selected != null)
            HomeWindow.getTop().updateFromCart(selected);
      }
   }

   /**
    * Method that generates both the Shopping Cart and the History Panels in the GUI
    */
   private void initialize() {
      JScrollPane shoppingCartScroll = new JScrollPane();
      shoppingCartScroll.setBounds(558, 124, 238, 250);
      layeredPane.add(shoppingCartScroll);
      order = null;
      try {
         order = data.getShoppingCart(idUser);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      if (order != null) {
         for (Product o : order) {
            mCart.addElement(o);
         }
      }
      shoppingCartList = new JList<>(mCart);
      shoppingCartList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
      shoppingCartScroll.setViewportView(shoppingCartList);
      shoppingCartList.setBackground(Colors.ORDER_BACKGROUND);
      shoppingCartList.setSelectionBackground(Colors.CART_SELECTION);
      // Add listener to list
      shoppingCartList.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            customMouseHandler(evt);
         }
      });
      /*********************************************************************************************/
      JButton btBuy = new JButton("Confirm order");
      btBuy.setBounds(558, 373, 238, 41);
      btBuy.setBackground(Colors.CONFIRM_ORDER);
      layeredPane.add(btBuy);
      btBuy.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent evt) {
            try {
               if (order != null && order.size() != 0) {
                  addToHistory();
                  updateHistoryList();
                  HomeWindow.getCenter().update();
               }
            } catch (SQLException e) {
               e.printStackTrace();
            }
         }
      });
      /*********************************************************************************************/
      JScrollPane scrollHistory = new JScrollPane();
      scrollHistory.setBounds(558, 415, 237, 290);
      layeredPane.add(scrollHistory);
      // Taking the worker historical registry
      history = null;
      try {
         history = data.getOrders(idUser);
      } catch (SQLException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      if (history != null) {
         for (Order o : history) {
            mHistory.addElement(o);
         }
      }
      historyList = new JList<Order>(mHistory);
      historyList.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
      scrollHistory.setViewportView(historyList);
      historyList.setBackground(Colors.ORDER_BACKGROUND);
      historyList.setSelectionBackground(Colors.CART_SELECTION);
      historyList.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent evt) {
            JList list = (JList) evt.getSource();
            if (evt.getClickCount() == 2) {
               // Double-click detected
               int index = list.locationToIndex(evt.getPoint());
               try {
                  OrderWindow ow = new OrderWindow(history.get(index));
                  updateHistoryList();
               } catch (IOException e) {
                  e.printStackTrace();
               }
            }
         }
      });
   }
}
