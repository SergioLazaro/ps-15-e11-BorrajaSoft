package tests;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.Test;
import facade.Customer;
import facade.DataExtraction;
import facade.Order;
import facade.Product;
import facade.ProductOrder;

public class DataExtractionTest {
   @Test
   public void testBasicSearchProducts() {
      System.out.println("Ejecución de pruebas del método basicSearchProducts.");
      DataExtraction de = new DataExtraction();

      try {
         ArrayList<Product> ans = null;
         System.out.println("Busqueda nula. OK.");
         ans = de.basicSearchProducts("", "", true);
         assertNotEquals(ans, new ArrayList<Product>());

         System.out.println("Busqueda compleja. OK.");
         ans = de.basicSearchProducts("SELECT * FROM Customers", "", true);
         assertEquals(ans, new ArrayList<Product>());
         // No devuelve nada. OK
      } catch (Exception e) {
         System.out.println("Ha salido error.");
      }
   }

   @Test
   public void testGetCustomerInfo() {
      System.out.println("Ejecución de pruebas del método getCustomerInfo.");
      DataExtraction de = new DataExtraction();

      try {
         Customer ans = null;
         System.out.println("Existente. OK.");
         ans = de.getCustomerInfo(1);

         System.out.println("Inexistente. OK.");
         ans = de.getCustomerInfo(-111);
         assertNull(ans);

         System.out.println("Fuera de rango. ERROR.");
         ans = de.getCustomerInfo(1111111111);
         assertNull(ans);
      } catch (Exception e) {
         System.out.println("Ha salido error.");
      }
   }

   @Test
   public void testGetOrderRecord() {
      System.out.println("Ejecución de pruebas del método getOrderRecord.");
      DataExtraction de = new DataExtraction();

      try {
         ArrayList<Product> ans = null;
         System.out.println("Existente. OK.");
         ans = de.getOrderRecord(1);
         assertNotEquals(ans, new ArrayList<Product>());

         System.out.println("Inexistente. OK.");
         ans = de.getOrderRecord(-111);
         assertEquals(ans, new ArrayList<Product>());

         System.out.println("Fuera de rango. ERROR.");
         ans = de.getOrderRecord(1111111111);
         assertEquals(ans, new ArrayList<Product>());
      } catch (Exception e) {
         System.out.println("Ha salido error.");
      }
   }

   @Test
   public void testGetOrders() {
      System.out.println("Ejecución de pruebas del método getOrders.");
      DataExtraction de = new DataExtraction();

      try {
         ArrayList<Order> ans = null;
         System.out.println("Existente. OK.");
         ans = de.getOrders(1);
         assertNotEquals(ans, new ArrayList<Order>());

         System.out.println("Inexistente. OK.");
         ans = de.getOrders(-111);
         assertEquals(ans, new ArrayList<Order>());

         System.out.println("Fuera de rango. ERROR.");
         ans = de.getOrders(1111111111);
         assertEquals(ans, new ArrayList<Order>());
      } catch (Exception e) {
         System.out.println("Ha salido error.");
      }
   }

   @Test
   public void testGetProductPath() {
      System.out.println("Ejecución de pruebas del método getProductPath.");
      DataExtraction de = new DataExtraction();

      try {
         String ans = null;
         System.out.println("Existente. OK.");
         ans = de.getProductPath(1);
         assertNotEquals(ans, "/photos/no_image.jpg");

         System.out.println("Inexistente. OK.");
         ans = de.getProductPath(-111);
         assertEquals(ans, "/photos/no_image.jpg");

         System.out.println("Fuera de rango. ERROR.");
         ans = de.getProductPath(1111111111);
         assertEquals(ans, "/photos/no_image.jpg");
      } catch (Exception e) {
         System.out.println("Ha salido error.");
      }
   }

   @Test
   public void testGetShoppingCart() {
      System.out.println("Ejecución de pruebas del método getShoppingCart.");
      DataExtraction de = new DataExtraction();

      try {
         ArrayList<Product> ans = null;
         System.out.println("Existente. OK.");
         ans = de.getShoppingCart(2);
         assertNotEquals(ans, new ArrayList<Product>());

         System.out.println("Inexistente. OK.");
         ans = de.getShoppingCart(-111);
         assertEquals(ans, new ArrayList<Product>());

         System.out.println("Fuera de rango. ERROR.");
         ans = de.getShoppingCart(1111111111);
         assertEquals(ans, new ArrayList<Product>());
      } catch (Exception e) {
         System.out.println("Ha salido error.");
      }
   }

   @Test
   public void testGetStyleProduct() {
      System.out.println("Ejecución de pruebas del método getStyleProduct.");
      DataExtraction de = new DataExtraction();

      try {
         ArrayList<String> ans = null;
         System.out.println("Existente. OK.");
         ans = de.getStyleProduct("underpants");
         assertNotEquals(ans, new ArrayList<String>());

         System.out.println("Inexistente. OK.");
         ans = de.getStyleProduct("camisa");
         assertEquals(ans, new ArrayList<Product>());

         System.out.println("Fuera de rango. ERROR.");
         ans = de.getStyleProduct("1111111111111111111111111111111111111111111111111111111111111");
         assertEquals(ans, new ArrayList<Product>());
      } catch (Exception e) {
         System.out.println("Ha salido error.");
      }
   }

   @Test
   public void testGetWarnings() {
      System.out.println("Ejecución de pruebas del método getWarnings.");
      DataExtraction de = new DataExtraction();

      try {
         ArrayList<String> ans = null;
         System.out.println("Existente. OK.");
         ans = de.getWarnings(1);
         assertNotEquals(ans, new ArrayList<String>());

         System.out.println("Inexistente. OK.");
         ans = de.getWarnings(-111);
         assertEquals(ans, new ArrayList<String>());

         System.out.println("Fuera de rango. ERROR.");
         ans = de.getWarnings(999999999);
         assertEquals(ans, new ArrayList<String>());
      } catch (Exception e) {
         System.out.println("Ha salido error.");
      }
   }

   @Test
   public void testSearchCustomers() {
      System.out.println("Ejecución de pruebas del método searchCustomers.");
      DataExtraction de = new DataExtraction();

      try {
         ArrayList<Customer> ans = null;
         System.out.println("Existente. OK.");
         ans = de.searchCustomers("Nicholas");
         assertNotEquals(ans, new ArrayList<Customer>());

         System.out.println("Inexistente. OK.");
         ans = de.searchCustomers("Otro");
         assertEquals(ans, new ArrayList<Customer>());

         System.out.println("Fuera de rango. ERROR.");
         ans = de.searchCustomers("1111111111111111111111111111111111111111111111111111111111111");
         assertEquals(ans, new ArrayList<Customer>());
      } catch (Exception e) {
         System.out.println("Ha salido error.");
      }
   }

   @Test
   public void testSearchProduct() {
      System.out.println("Ejecución de pruebas del método searchProduct.");
      DataExtraction de = new DataExtraction();

      try {
         ArrayList<Product> ans = null;
         System.out.println("Existente. OK.");
         ans = de.searchProduct("grey slip underpants");
         assertNotEquals(ans, new ArrayList<Product>());

         System.out.println("Inexistente. OK.");
         ans = de.searchProduct("Otro");
         assertEquals(ans, new ArrayList<Product>());

         System.out.println("Fuera de rango. ERROR.");
         ans = de.searchProduct("1111111111111111111111111111111111111111111111111111111111111");
         assertEquals(ans, new ArrayList<Product>());
      } catch (Exception e) {
         System.out.println("Ha salido error.");
      }
   }

   @Test
   public void testSearchStockByID() {
      System.out.println("Ejecución de pruebas del método searchStockByID.");
      DataExtraction de = new DataExtraction();

      try {
         int ans = 0;
         System.out.println("Existente. OK.");
         ans = de.searchStockByID(2);
         assertEquals(ans, 13);

         System.out.println("Inexistente. OK.");
         ans = de.searchStockByID(-111);
         assertEquals(ans, 0);

         System.out.println("Fuera de rango. ERROR.");
         ans = de.searchStockByID(1111111111);
         assertEquals(ans, 0);
      } catch (Exception e) {
         System.out.println("Ha salido error.");
      }
   }

   @Test
   public void testUserType() {
      System.out.println("Ejecución de pruebas del método userType.");
      DataExtraction de = new DataExtraction();

      try {
         String ans = null;
         System.out.println("Existente. OK.");
         ans = de.userType(1);
         assertEquals(ans, "admin");

         System.out.println("Inexistente. OK.");
         ans = de.userType(-111);
         assertEquals(ans, "user");

         System.out.println("Fuera de rango. ERROR.");
         ans = de.userType(1111111111);
         assertEquals(ans, "user");
      } catch (Exception e) {
         System.out.println("Ha salido error.");
      }
   }
}
