package facade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.DataAccess;

public class DataExtraction {
   private DataAccess mda;

   public DataExtraction() {
      mda = new DataAccess();
   }

   /**
    * Search products in the database based on the name and the given options. If alpha is not one
    * of the correct options, it orders by name by default.
    * 
    * @param query
    *           The query executed in the database.
    * @param orderBY
    *           Must be 'price' or 'alpha'
    * @param asc
    *           If true, orders ASCENDANT else orders DESCENDENT
    * @return A list of products.
    * @throws SQLException
    */
   public ArrayList<Product> basicSearchProducts(String query, String orderBy, boolean asc)
            throws SQLException {
      ArrayList<Product> productArray = new ArrayList<Product>();
      // Avoid SQL injection
      if (!(orderBy.equalsIgnoreCase("price") || orderBy.equalsIgnoreCase("name"))) {
         orderBy = "name";
      }
      String type = "desc";
      if (asc) {
         type = "asc";
      }
      ResultSet result = mda.getQuery("SELECT * FROM Products WHERE name " + "LIKE '%" + query
               + "%' ORDER BY " + orderBy + " " + type);

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
      return productArray;
   }

   /**
    * Return the order record of a customer.
    * 
    * @param customerID
    *           The id of the customer searched
    * @return A list with the complete order record of the customer.
    * @throws SQLException
    */
   public ArrayList<Product> getOrderRecord(int customerID) throws SQLException {
      ArrayList<Product> array = new ArrayList<Product>();
      ResultSet result = mda.getQuery("SELECT p.productID , p.productTypeID , p.name , p.brand , "
               + "p.price , p.stock FROM Products p , Orders o1, OrderRecords o2 "
               + "WHERE p.productID = o2.productID AND o2.orderID = o1.orderID AND "
               + "o1.customerID = " + customerID + " limit 20");

      while (result.next()) {
         int productID = result.getInt("productID");
         int productTypeID = result.getInt("productTypeID");
         String brand = result.getString("brand");
         String name = result.getString("name");
         double price = result.getDouble("price");
         int stock = result.getInt("stock");
         array.add(new Product(productID, productTypeID, brand, name, price, stock));
      }

      System.out.println("getOrderRecord ends.");
      return array;
   }

   /**
    * Search the image path of a product in the database.
    * 
    * @param productTypeID
    *           The product id searched.
    * @return Path of the image of productType which has productTypeID or default no image path if
    *         an error occurs
    */
   public String getProductPath(int productTypeID) {
      try {
         ResultSet result = mda.getQuery("SELECT image FROM ProductTypes WHERE productTypeID = "
                  + productTypeID);
         String path = "/photos/no_image.jpg";
         while (result.next()) {
            path = result.getString("image");
         }
         return path;
      } catch (SQLException e) {
         return "/photos/no_image.jpg";
      }
   }

   /**
    * Return all the types of the products.
    * 
    * @return A list with the styles.
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
    * Return the shopping cart of a customer.
    * 
    * @param customerID
    *           The customer id searched.
    * @return A list with products.
    * @throws SQLException
    */
   public ArrayList<Product> getShoppingCart(int customerID) throws SQLException {
      ArrayList<Product> array = new ArrayList<Product>();
      ResultSet result = mda.getQuery("SELECT p.productID , p.productTypeID , p.name , p.brand , "
               + "p.price , sc.numItems FROM Products p , ShoppingCart sc "
               + "WHERE p.productID = sc.productID AND sc.customerID = " + customerID);

      while (result.next()) {
         int productID = result.getInt("productID");
         int productTypeID = result.getInt("productTypeID");
         String brand = result.getString("brand");
         String name = result.getString("name");
         double price = result.getDouble("price");
         int stock = result.getInt("numItems");
         array.add(new Product(productID, productTypeID, brand, name, price, stock));
      }

      System.out.println("getShoppingCart ends.");
      return array;
   }

   /**
    * Search the number of items of a product in the shopping cart of a costumer.
    * 
    * @param productID
    *           The product id searched.
    * @return The number of items.
    */
   public int getStackFromCart(int productID) {
      int stack = 0;

      try {
         ResultSet result = mda.getQuery("SELECT numItems FROM ShoppingCart WHERE productID = "
                  + productID);
         while (result.next()) {
            stack = result.getInt("numItems");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return stack;
   }

   /**
    * Return the style of a product.
    * 
    * @param clothes
    *           The product.
    * @return The style
    * @throws SQLException
    */
   public ArrayList<String> getStyleProduct(String clothes) throws SQLException {
      ArrayList<String> array = new ArrayList<String>();
      ResultSet result = mda.getQuery("SELECT DISTINCT style FROM ProductTypes "
               + "WHERE clothes = '" + clothes + "'");

      while (result.next()) {
         String style = result.getString("style");
         array.add(style);
      }

      System.out.println("getStyleProduct ends.");
      return array;
   }

   /**
    * Check the username and password into the Customers table.
    * 
    * @param username
    *           Customer username.
    * @param password
    *           Customer password.
    * 
    * @return customerID If exists a customer with that username and password. -1 Otherwise.
    * @throws SQLException
    */
   public int login(String mailAddress, String password) throws SQLException {
      int idUser = -1;
      ResultSet result = mda.getQuery("SELECT customerID, mailAddress, password FROM Customers"
               + " WHERE mailAddress = '" + mailAddress + "' AND password = '" + password + "'");

      while (result.next()) {
         String mailAddressAux = result.getString("mailAddress");
         String passwordAux = result.getString("password");
         if (mailAddressAux.equalsIgnoreCase(mailAddress) && passwordAux.equalsIgnoreCase(password)) {
            idUser = result.getInt("customerID");
         }
      }

      System.out.println("login ends.");
      return idUser;
   }

   /**
    * Search customers in the database.
    * 
    * @param query
    *           The query to search in the database.
    * @return A list with customers.
    * @throws SQLException
    */
   public ArrayList<Customer> searchCustomers(String query) throws SQLException {
      ArrayList<Customer> CustomerArray = new ArrayList<Customer>();
      ResultSet result = mda.getQuery("SELECT * FROM Customers WHERE name LIKE '%" + query + "%'");
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
         Customer customer = new Customer(customerID, password, name, surname, deliveringAddress,
                  mailAddress, telephone);
         CustomerArray.add(customer);
      }

      System.out.println("Fin lookingForTrabajadors");
      return CustomerArray;
   }

   /**
    * Search products in the database.
    * 
    * @param query
    *           The query searched.
    * @return A list of products.
    * @throws SQLException
    */
   public ArrayList<Product> searchProduct(String query) throws SQLException {
      ArrayList<Product> productArray = new ArrayList<Product>();
      ResultSet result = mda.getQuery("SELECT * FROM Products WHERE name " + "LIKE '% " + query
               + "%'");

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
      return productArray;
   }

   /**
    * Returns the stock of a given product in the database.
    * 
    * @param productID
    *           The product id searched
    * @return Stock of the given productID
    * @throws SQLException
    *            If no product with that productID is found
    */
   public int searchStockByID(int productID) throws SQLException {
      ResultSet result = mda.getQuery("SELECT stock FROM Products WHERE productID = " + productID);
      int stock = 0;
      while (result.next()) {
         stock = result.getInt("stock");
      }
      return stock;
   }
}
