package facade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import database.DataAccess;

public class DataInsertion {
   private DataAccess mda;
   private static final String[] customersFields = {"password","name","surname","deliveringAddress",
	   "mailAddress","telephone","customerType"};
   private static final String[] productFields = {"productTypeID","brand","name","price","stock"};
   private static final String[] productTypeFields = {"clothes","colour","style","image","size"};


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
		   int cartStack = d.getStackFromCart(product.getProductID(), idUser);
		   if(cartStack == 0){
			   System.err.println("INSERTO PRODUCTO CON ID: " + product.getProductID());
			   System.err.println("cartStack = " + cartStack);
			   //Insert new product to shoppingcart if is not there
			   mda.setQuery("INSERT INTO ShoppingCart VALUES(" + idUser + " , " + product.getProductID() +
					   " , " + num + ")");
		   } else if(cartStack == -num){
			   System.err.println("BORRO PRODUCTO CON ID: " + product.getProductID());
			   System.err.println("cartStack = " + cartStack + "num " + num);
			   mda.setQuery("DELETE FROM ShoppingCart WHERE productID = " + product.getProductID() +
					   " AND customerID = " + idUser);
		   } else{
			   System.err.println("ACTUALIZO PRODUCTO CON ID: " + product.getProductID());
			   System.err.println("cartStack = " + cartStack + "num " + num);
			   //Update a product which exists
			   mda.setQuery("UPDATE ShoppingCart SET numItems = " + (maxNum + num) + " WHERE productID = "
					   + product.getProductID() + " AND customerID = " + idUser); 
		   }
	   } catch (SQLException e) {
			e.printStackTrace();
	   }
   }
   
   public void updateUserInfo(Customer info) throws SQLException {
	   String cPassword = info.getPassword();
	   String query = "UPDATE Customers SET deliveringAddress = '" + info.getDeliveringAddress()
		   		+ "', mailAddress = '" + info.getMailAddress()
		   		+ "', telephone = '" +	info.getTelephone() + "'";
	   if(cPassword!=null && !cPassword.equals("")){
		   	   query = query + ", password = '" + cPassword + "'";

	   }
	   query = query + " WHERE customerID = " + info.getCustomerID();
	   mda.setQuery(query);
   }
 /**
    * 
    * @param line must contains all columns of table Customer separated by [,]
    * Insert into Customers a new customer with their columns read from line
    */
   public void insertIntoCustomersFromLine(String line){
	   Scanner s = new Scanner(line);
	   s.useDelimiter(",");
	   ArrayList<String> array = new ArrayList<String>();
	   
	   while(s.hasNext()){
		   array.add(s.next());
	   }
	   String query = "INSERT INTO Customers(password,name,surname,deliveringAddress,"
	   		+ "mailAddress,telephone,customerType) VALUES('";
	   for (int i = 0; i < array.size(); i++){
		   if (i == array.size() - 1){
			   query += array.get(i) + "')";
		   }
		   else{
			   query += array.get(i) + "','";
		   }
	   }
	   s.close();
	   System.out.println(query);
	   mda.setQuery(query);
   }
   
   /**
    * @param line must contains all columns of table Products separated by [,]
    * Insert into Prodcuts a new customer with their columns read from line
    */
	public void insertIntoProductsFromLine(String line){
	   String []array = line.split(",");
	   int productTypeID = Integer.parseInt(array[0]);
	   String brand = array[1];
	   String name = array[2];
	   double price = Double.parseDouble(array[3]);
	   int stock = Integer.parseInt(array[4]);
	   String query = "INSERT INTO Products(productTypeID,brand,name,price,stock) "
	   		+ "VALUES(" + productTypeID + ",'" + brand + "','" + name +
	   		"'," + price + "," + stock + ")";
	   mda.setQuery(query);
	}
	
	/**
	 * @param line must contains all columns of table ProductTypes separated by [,]
	 * Insert into ProductTypes a new customer with their columns read from line
	 */
	public void insertIntoProductTypesFromLine(String line){
		String []array = line.split(",");
		String clothes = array[0];
		String colour = array[1];
		String style = array[2];
		String image = array[3];
		String size = array[4];
		String query = "INSERT INTO ProductTypes(clothes,colour,style,image,size) "
		   		+ "VALUES('" + clothes + "','" + colour + "','" + style +
		   		"','" + image + "','" + size + "')";
		mda.setQuery(query);
	}
	
	/**
	 * 
	 * @param line must contains all columns of table Customers separated by [,]
	 * @param customerID must be a existing customerID of Customers table
	 * Update Customers table where customerID = [customerID] with elements contained in
	 * line
	 */
	public void updateCustomersFromLine(String line, int customerID){
		String query = "UPDATE Customers SET ";
		String []array = line.split(",");
		if(array.length == customersFields.length){
			for(int i = 0; i < array.length; i++){
				if(!array[i].equals("-")){
					query += customersFields[i] + "='" + array[i] + "' , "; 
				}
			}
			query = query.substring(0, query.length() - 2);
			query += " WHERE customerID = " + customerID;
			mda.setQuery(query);
		}
		
	}	
	
	/**
	 * @param line must contains all columns of table Products separated by [,]
	 * @param productID must be an existing productID of Products table
	 * Update Products table where productID = [productID] with elements contained in
	 * line
	 */
	public void updateProductsFromLine(String line,int productID){
		String query = "UPDATE Products SET ";
		String []array = line.split(",");
		if(array.length == productFields.length){
			for(int i = 0; i < array.length; i++){
				if(!array[i].equals("-")){
					if(i == 1 || i == 2){
						query += productFields[i] + "='" + array[i] + "' , "; 
					}
					else{
						query += productFields[i] + "=" + array[i] + " , "; 
					}				
				}
			}
			query = query.substring(0, query.length() - 2);
			query += " WHERE productID = " + productID;
			mda.setQuery(query);
		}
	}
	
	/**
	 * @param line must contains all columns of table ProductsTypes separated by [,]
	 * @param productTypeID must be an existing productTypeID of ProductTypes table
	 * Update ProductsTypes table where productTypeID = [productTypeID] with elements
	 *  contained in line
	 */
	public void updateProductTypesFromLine(String line,int productTypeID){
		String query = "UPDATE ProductTypes SET ";
		String []array = line.split(",");
		if(array.length == productTypeFields.length){
			for(int i = 0; i < array.length; i++){
				if(!array[i].equals("-")){
					query += productTypeFields[i] + "='" + array[i] + "' , "; 
				}
			}
			query = query.substring(0, query.length() - 2);
			query += " WHERE productTypeID = " + productTypeID;
			mda.setQuery(query);
		}
	}
	
	public void deleteFromTable(String table, int ID){
		if(table.equals("Customers")){
			mda.setQuery("DELETE FROM " + table + " WHERE customerID = " + ID);
		}
		else if(table.equals("Products")){
			mda.setQuery("DELETE FROM " + table + " WHERE productID = " + ID);
		}
		else if(table.equals("ProductTypes")){
			mda.setQuery("DELETE FROM " + table + " WHERE productTypeID" + ID);
		}
	}
	
	
	/**
	 * Delete all orders from idUser
	 */
	public void deleteShoppingCart(int idUser) {
		mda.setQuery("DELETE FROM shoppingcart WHERE customerId = " + idUser);
	}

	/**
	 * Delete the parameterized order with all of their product and update the
	 * stock for these products
	 * 
	 * @param o
	 * @param list
	 */
	public void deleteOrder(Order o, ArrayList<ProductOrder> list) {
		mda.setQuery("DELETE FROM orderRecords WHERE orderId= "
				+ o.getOrderID());
		mda.setQuery("DELETE FROM orders WHERE orderId= " + o.getOrderID());

		for (ProductOrder po : list) { // Updates the stock for each product
			mda.setQuery("UPDATE products SET stock = stock + "
					+ po.getNumItems() + " WHERE productId = "
					+ po.getProductId());
		}
	}

}
