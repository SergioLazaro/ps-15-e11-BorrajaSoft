package facade;

import java.sql.SQLException;

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
    */
   public void insertOrder(Order order) {
      mda.setQuery("INSERT INTO Orders VALUES (" + order.toString() + ")");
   }

   /**
    * Insert data into the OrderRecords table.
    * 
    * @param orderRecord The data to insert.
    */
   public void insertOrderRecord(OrderRecord orderRecord) {
      mda.setQuery("INSERT INTO OrderRecords VALUES (" + orderRecord.toString() + ")");
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
}
