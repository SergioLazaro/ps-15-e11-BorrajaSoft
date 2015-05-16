package facade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.DataAccess;

public class DataExtraction {
   private DataAccess mda;

   /**
    * 
    */
   public DataExtraction() {
      mda = new DataAccess();
   }

   /**
    * Check the username and password into the Customers table.
    * 
    * @param username Customer username.
    * @param password Customer password.
    * 
    * @return customerID   If exists a customer with that username and password.
    *         -1           Otherwise.
    * @throws SQLException
    */
   public int login(String mailAddress, String password) throws SQLException {
      int idUser = -1;
      ResultSet result = mda.getQuery("SELECT customerID, mailAddress, password FROM Customers"
               + " WHERE mailAddress = '" + mailAddress + "' AND password = '" + password + "'");
      String mailAddressAux = "";
      String passwordAux = "";
      while (result.next()) {
         mailAddressAux = result.getString("mailAddress");
         passwordAux = result.getString("password");
         if (mailAddressAux.equalsIgnoreCase(mailAddress) && passwordAux.equalsIgnoreCase(password)) {
            idUser = result.getInt("customerID");
         }
      }
      System.out.println("login ends.");
      return idUser;
   }

   /**
    * 
    * @param idTrabajador
    * @return
    * @throws SQLException
    */
   public ArrayList<String> getOrderRecord(int customerID) throws SQLException {
      ArrayList<String> array = new ArrayList<String>();
      ResultSet result = 
               mda.getQuery("SELECT p.name , p.brand , p.price "
               + "FROM Products p , Orders o1, OrderRecords o2 "
               + "WHERE p.productID = o2.productID AND "
               + "o2.orderID = o1.orderID AND "
               + "o1.customerID = " + customerID + " limit 10");

      while (result.next()) {
         String name = result.getString("name");
         String brand = result.getString("brand");
         double price = result.getDouble("price");
         array.add("- " + name + "   " + brand + "   " + price + "â‚¬");
      }

      System.out.println("getOrderRecord ends.");
      return array;
   }
   
   
   
   public ArrayList<Product> getOrderRecordP(int customerID) throws SQLException {
	      ArrayList<Product> array = new ArrayList<Product>();
	      ResultSet result = 
	               mda.getQuery("SELECT p.productId, p.productTypeID, p.name , p.brand , p.price, p.stock "
	               + "FROM Products p , Orders o1, OrderRecords o2 "
	               + "WHERE p.productID = o2.productID AND "
	               + "o2.orderID = o1.orderID AND "
	               + "o1.customerID = " + customerID + " limit 10");

	      while (result.next()) {
	    	 Product p = new Product(result.getInt("productId"), result.getInt("productTypeId"), result.getString("brand"),
	    			 result.getString("name"),result.getDouble("price"), result.getInt("stock"));
	         
	         array.add(p);
	      }

	      System.out.println("getOrderRecord ends.");
	      return array;
   }
   

   /**
    * 
    * @param idTrabajador
    * @return
    * @throws SQLException
    */
   public ArrayList<Product> getShoppingCartP(int customerID) throws SQLException {
      ArrayList<Product> array = new ArrayList<Product>();
      //array.add("Shopping Cart List: ");
      ResultSet result = 
               mda.getQuery("SELECT p.productId, p.productTypeID, p.name , p.brand , p.price, p.stock "
               + "FROM Products p , ShoppingCart sc "
               + "WHERE p.productID = sc.productID AND sc.customerID = " + customerID);

      while (result.next()) {
    	  Product p = new Product(result.getInt("productId"), result.getInt("productTypeId"), result.getString("brand"),
	    			 result.getString("name"),result.getDouble("price"), result.getInt("stock"));
         array.add(p);
      }

      System.out.println("getShoppingCart ends.");
      return array;
   }
   
   public ArrayList<String> getShoppingCart(int customerID) throws SQLException {
	      ArrayList<String> array = new ArrayList<String>();
	      //array.add("Shopping Cart List: ");
	      ResultSet result = 
	               mda.getQuery("SELECT p.name as name, p.brand as brand, p.price as price "
	               + "FROM Products p , ShoppingCart sc "
	               + "WHERE p.productID = sc.productID AND sc.customerID = " + customerID);

	      while (result.next()) {
	         String name = result.getString("name");
	         String brand = result.getString("brand");
	         double price = result.getDouble("price");
	         array.add("- " + name + ", " + brand + ", " + price + " €");
	      }

	      System.out.println("getShoppingCart ends.");
	      return array;
	   }

   /**
    * 
    * @param clothes
    * @return
    * @throws SQLException
    */
   public ArrayList<String> getStyleProduct(String clothes) throws SQLException {
      ArrayList<String> array = new ArrayList<String>();
      ResultSet result = 
               mda.getQuery("SELECT DISTINCT style FROM ProductTypes " 
               + "WHERE clothes = '" + clothes + "'");

      while (result.next()) {
         String style = result.getString("style");
         array.add(style);
      }

      System.out.println("getStyleProduct ends.");
      return array;
   }

   /**
    * 
    * @return
    * @throws SQLException
    */
   public ArrayList<String> getProductType() throws SQLException {
      ArrayList<String> array = new ArrayList<String>();
      ResultSet result = mda.getQuery("SELECT DISTINCT clothes FROM ProductTypes");

      while (result.next()) {
         String cloth = result.getString("clothes");
         array.add(cloth);
      }

      System.out.println("getProductType ends.");
      return array;
   }

   /**
    * 
    * @param query
    * @return
    * @throws SQLException
    */
   public ArrayList<Product> basicSearchProducts(String query) throws SQLException {
      ArrayList<Product> productArray = new ArrayList<Product>();
      
      if (query != null && !query.equals("")){
	      ResultSet result = 
	               mda.getQuery("SELECT * FROM Products WHERE name " + "LIKE '%" + query + "%'");
	
	      // Buscamos en la tabla Prenda a ver si esta la busqueda del cliente.
	      while (result.next()) { 
	         int productID = result.getInt("productID");
	         int productTypeID = result.getInt("productTypeID");
	         String brand = result.getString("brand");
	         String name = result.getString("name");
	         double price = result.getDouble("price");
	         int stock = result.getInt("stock");
	         Product clothes = new Product(productID, productTypeID, brand, name, price, stock);
	         productArray.add(clothes);
	      }
	
	      System.out.println("basicSearchProducts ends.");
      }
      
      return productArray;
   }

   // TODO: Verificar si se busca por nombre o nombre de usuario.
   /**
    * 
    */
   public ArrayList<Customer> searchCustomers(String query) throws SQLException {
      ArrayList<Customer> CustomerArray = new ArrayList<Customer>();
      ResultSet result = 
               mda.getQuery("SELECT * FROM Customers WHERE name LIKE '%" + query + "%'");
               mda.getQuery("SELECT * FROM Customers WHERE mailAddress LIKE '%" + query + "%'");

      // Buscamos en la tabla Trabajador a ver si esta la busqueda del cliente.
      while (result.next()) { 
         int customerID = result.getInt("customerID");
         String password = result.getString("password");
         String name = result.getString("password");
         String surname = result.getString("password");
         String deliveringAddress = result.getString("password");
         String mailAddress = result.getString("password");
         int telephone = result.getInt("telephone");
         Customer customer = new Customer(customerID, password, 
                                 name, surname, deliveringAddress, mailAddress, telephone);
         CustomerArray.add(customer);
      }

      System.out.println("Fin lookingForTrabajadors");
      return CustomerArray;
   }
}
