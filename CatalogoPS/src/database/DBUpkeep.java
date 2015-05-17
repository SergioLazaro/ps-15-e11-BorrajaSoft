package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class DBUpkeep {
   public static void main(String[] args) {
      DataAccess mda = new DataAccess();
      modifyingStyle(mda);
      // System.out.println("Conectado");
   }

   /**
    * Update the prices of the orders of the database.
    *  
    * @param mda The database.
    */
   public static void setTotalPrice(DataAccess mda) {
      ResultSet result = mda.getQuery("SELECT MAX(orderID) as max FROM OrderRecords");
      double[] totalprices = null;
      ResultSet result2 = mda.getQuery("SELECT t1.orderID orderID , "
               + "t1.numItems numItems, t2.productID productID , t2.price price "
               + "FROM OrderRecords t1 , Products t2 WHERE t1.productID = t2.productID");
      try {
         while (result.next()) { // Just one iteration, one element
            totalprices = new double[result.getInt("max")];
         }
         while (result2.next()) { // adding all prices per order
            totalprices[result2.getInt("orderID") - 1] += result2.getDouble("price");
         }
         for (int i = 0; i < totalprices.length; i++) {
            mda.setQuery("UPDATE Orders SET totalprice = " + totalprices[i] + " WHERE orderID = "
                     + i);
         }
      } catch (SQLException e1) {
         // TODO Auto-generated catch block
         e1.printStackTrace();
      }

   }

   /**
    * Set the relative path to the image in the database. 
    * 
    * @param mda The dabase.
    */
   private static void insertPath(DataAccess mda) {
      ResultSet result = mda.getQuery("SELECT * FROM ProductTypes");
      String clothes = "";
      try {
         while (result.next()) {
            clothes = result.getString("clothes");
            mda.setQuery("UPDATE ProductTypes SET image = '/photos/" + clothes
                     + ".jpg' WHERE productTypeID = " + result.getInt("productTypeID"));
         }
         System.out.println("Paths modificados");
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   /**
    * Update the name of the product.
    * 
    * @param mda The database.
    */
   private static void updateProductName(DataAccess mda) {
      ResultSet result1;
      ResultSet result2 = mda.getQuery("SELECT * FROM Products");
      String name = "";
      int productTypeID = -1;
      try {
         while (result2.next()) {
            result1 = mda.getQuery("SELECT * FROM ProductTypes WHERE productTypeID = "
                     + result2.getInt("productTypeID"));
            while (result1.next()) {
               productTypeID = result1.getInt("productTypeID");
               name = result1.getString("colour") + " " + result1.getString("style") + " "
                        + result1.getString("clothes");
            }
            System.out.println(name);
            mda.setQuery("UPDATE Products SET name = '" + name + "' WHERE productID = "
                     + result2.getInt("productID") + " AND productTypeID = " + productTypeID);
            System.out.println("UPDATE DONE");
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }

   /**
    * Update the style column of the ProductType table randomly.
    * 
    * @param mda The database.
    */
   private static void modifyingStyle(DataAccess mda) {
      Random rm = new Random();

      try {
         ResultSet result = mda.getQuery("SELECT * FROM ProductTypes ");
         while (result.next()) {
            int num = -1;
            int id = result.getInt("productTypeID");
            String cloth = result.getString("clothes");

            if (cloth.equals("shirt")) {
               num = rm.nextInt(2);
               if (num == 0) {
                  mda.setQuery("UPDATE ProductTypes SET style = 'simple' WHERE productTypeID = "
                           + id);
                  System.out.println("Shirt modified");
               } else {
                  mda.setQuery("UPDATE ProductTypes SET style = 'striped' WHERE productTypeID = "
                           + id);
                  System.out.println("Shirt modified");
               }

            } else if (cloth.equals("sweater")) {
               num = rm.nextInt(2);
               if (num == 0) {
                  mda.setQuery("UPDATE ProductTypes SET style = 'simple' WHERE productTypeID = "
                           + id);
                  System.out.println("Sweater modifed");
               } else {
                  mda.setQuery("UPDATE ProductTypes SET style = 'striped' WHERE productTypeID = "
                           + id);
                  System.out.println("Sweater modified");
               }

            } else if (cloth.equals("t-shirt")) {
               num = rm.nextInt(2);
               if (num == 0) {
                  mda.setQuery("UPDATE ProductTypes SET style = 'simple' WHERE productTypeID = "
                           + id);
                  System.out.println("T-shirt modified");
               } else {
                  mda.setQuery("UPDATE ProductTypes SET style = 'striped' WHERE productTypeID = "
                           + id);
                  System.out.println("T-shirt modified");
               }

            } else if (cloth.equals("shocks")) {
               num = rm.nextInt(2);
               if (num == 0) {
                  mda.setQuery("UPDATE ProductTypes SET style = 'shorts' WHERE productTypeID = "
                           + id);
                  System.out.println("Shocks modified");
               } else {
                  mda.setQuery("UPDATE ProductTypes SET style = 'large' WHERE productTypeID = "
                           + id);
                  System.out.println("Shocks modified");
               }

            } else if (cloth.equals("trousers")) {
               num = rm.nextInt(2);
               if (num == 0) {
                  mda.setQuery("UPDATE ProductTypes SET style = 'larges' WHERE productTypeID = "
                           + id);
                  System.out.println("Trousers modified");
               } else {
                  mda.setQuery("UPDATE ProductTypes SET style = 'shorts' WHERE productTypeID = "
                           + id);
                  System.out.println("Trousers modified");
               }

            } else if (cloth.equals("underpants")) {
               num = rm.nextInt(2);
               if (num == 0) {
                  mda.setQuery("UPDATE ProductTypes SET style = 'boxer' WHERE productTypeID = "
                           + id);
                  System.out.println("Underpants modified");
               } else {
                  mda.setQuery("UPDATE ProductTypes SET style = 'slip' WHERE productTypeID = " + id);
                  System.out.println("Underpants modified");
               }

            }
         }
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
