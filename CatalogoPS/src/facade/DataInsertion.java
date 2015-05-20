package facade;

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
	   System.out.println("First try.");
	   mda.setQuery("UPDATE Products SET stock = " + (maxNum - num) + " WHERE productID = " + 
			   product.getProductID());
	   System.out.println("Product updated");
	   DataExtraction d = new DataExtraction ();
	   int cartStack = d.getStackFromCart(product.getProductID());
	   if(cartStack == 0){
		   System.out.println(idUser + " - " + product.getProductID() + " - " + num);
		   mda.setQuery("INSERT INTO ShoppingCart VALUES(" + idUser + " , " + product.getProductID() +
				   " , " + num + ")");
		   System.out.println("New product added to Shopping Cart");
	   } else if(cartStack == -num){
		   mda.setQuery("DELETE FROM ShoppingCart WHERE productID = " + product.getProductID());
	   } else{
		   mda.setQuery("UPDATE ShoppingCart SET numItems = " + (maxNum + num) + " WHERE productID = "
				   + product.getProductID()); 
	   }
   }
}
