package facade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DataAccess;

public class DataInsertion {
   private static DataAccess mda;

   /**
    * Constructor
    */
   public DataInsertion() {
      mda = new DataAccess();
   }


   /**
    * Insert data into the ProductType table.
    * 
    * @param productType The data to insert.
    */
   public void insertProductType(ProductType productType) {
      mda.setQuery("INSERT INTO ProductTypes VALUES (" + productType.toString() + ")");
   }

   /**
    * Insert data into the Products table.
    * 
    * @param product The data to insert.
    */
   public void insertProduct(Product product) {
      mda.setQuery("INSERT INTO Products VALUES (" + product.toString() + ")");
   }

   /**
    * Insert data into the Customers table.
    * 
    * @param customer The data to insert.
    */
   public void insertCustomer(Customer customer) {
      mda.setQuery("INSERT INTO Customers VALUES (" + customer.toString() + ")");
   }

   /**
    * Insert data into the ShoppingCarts table.
    * 
    * @param shoppingCart The data to insert.
    */
   public void insertShoppingCart(ShoppingCart shoppingCart) {
      mda.setQuery("INSERT INTO ShoppingCarts VALUES (" + shoppingCart.toString() + ")");
   }

   /**
    * Insert data into the Orders table.
    * 
    * @param order The data to insert.
    * @throws SQLException 
    */
   public int insertOrder(Order order) throws SQLException {
	  String query = "INSERT INTO Orders (customerId, date, totalPrice) VALUES (" + order.toStringDB() + ")";
      mda.setQuery(query);
      System.err.println(query);
      
      query = "SELECT O.orderId FROM orders O " 
              + "WHERE O.customerId = " + order.getCustomerID()+ " AND O.date = '" + order.getDate() + "'" /* + " AND O.totalPrice = " + order.getTotalPrice() + ""*/;
      
      System.err.println(query);
      ResultSet result = mda.getQuery(query);
      
      int orderId = -1;
      while (result.next()) {
    	  orderId = result.getInt(1);
       }
      
      return orderId;
   }

   /**
    * Insert data into the OrderRecords table.
    * 
    * @param orderRecord The data to insert.
    */
   public void insertOrderRecord(OrderRecord orderRecord) {
      mda.setQuery("INSERT INTO OrderRecords (orderId, productId, numItems) VALUES (" + orderRecord.toString() + ")");
   }
   
   public void updateProductStock(int num, int maxNum,Product product, int idUser){
	   DataExtraction d = new DataExtraction ();
	   try {
		   int stock = d.searchStockByID(product.getProductID());
		   mda.setQuery("UPDATE Products SET stock = " + (stock - num) + " WHERE productID = " + 
				   product.getProductID());
		   int cartStack = d.getStackFromCart(product.getProductID());
		   if(cartStack == 0){
			   //Insert new product to shoppingcart if is not there
			   mda.setQuery("INSERT INTO ShoppingCart VALUES(" + idUser + " , " + product.getProductID() +
					   " , " + num + ")");
			   System.out.println("New product added to Shopping Cart");
		   } else if(cartStack == -num){
			   mda.setQuery("DELETE FROM ShoppingCart WHERE productID = " + product.getProductID() +
					   " AND customerID = " + idUser);
		   } else{
			   //Update a product which exists
			   mda.setQuery("UPDATE ShoppingCart SET numItems = " + (maxNum + num) + " WHERE productID = "
					   + product.getProductID() + " AND customerID = " + idUser); 
		   }
	   } catch (SQLException e) {
			e.printStackTrace();
		}
   }
   
   /**
    * Delete all orders from idUser
    */
   public void deleteShoppingCart(int idUser) {
	   mda.setQuery("DELETE FROM shoppingcart WHERE customerId = " + idUser);
   }
   
   
   /**
    * Delete the parameterized order with all of their product and
    * update the stock for these products
    * @param o
    * @param list
    */
   public void deleteOrder(Order o, ArrayList<ProductOrder> list) {
	   mda.setQuery("DELETE FROM orderRecords WHERE orderId= " + o.getOrderID());
	   mda.setQuery("DELETE FROM orders WHERE orderId= " + o.getOrderID());
	   
	   for (ProductOrder po : list) {		// Updates the stock for each product
		   mda.setQuery("UPDATE products SET stock = stock + " + po.getNumItems() + " WHERE productId = " + po.getProductId());
	   }
   }
}
