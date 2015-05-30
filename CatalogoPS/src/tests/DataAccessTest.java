package tests;

import static org.junit.Assert.*;
import java.sql.ResultSet;
import org.junit.Test;
import database.DataAccess;

public class DataAccessTest 
{
   @Test
   public void testDataAccess() 
   {
      DataAccess da = new DataAccess();
   }

   @Test
   public void testGetQuery() 
   {
      System.out.println("Ejecución de pruebas del método getQuery.");
      DataAccess da = new DataAccess();
      ResultSet rs = null;

      System.out.println("Busqueda nula. ERROR.");
      // Genera error de query nula. OK
      rs = da.getQuery("");
      assertNull(rs);

      System.out.println("Busqueda despistada. ERROR.");
      // Genera error de sintaxis SQL. OK
      rs = da.getQuery("Textile mañánero");
      assertNull(rs);

      System.out.println("Tabla desconocida. ERROR.");
      // Genera error por tabla desconocida. OK
      rs = da.getQuery("SELECT * FROM Lucas");
      assertNull(rs);

      System.out.println("Id fuera de rango. ERROR.");
      // No genera error. ERROR
      rs = da.getQuery("SELECT * FROM Customers WHERE customerID = 111111111111");
      assertNull(rs);
      //System.out.println(rs.toString());

      System.out.println("Id distinto tipo. ERROR.");
      // No genera error. ERROR
      rs = da.getQuery("SELECT * FROM Customers WHERE customerID = 'lucas'");
      assertNull(rs);
      //System.out.println(rs.toString());

      System.out.println("Id inexistente. OK.");
      // Genera algo. OK
      rs = da.getQuery("SELECT * FROM Customers WHERE customerID = -111");
      assertNotNull(rs);
      System.out.println(rs.toString());

      System.out.println("Busqueda correcta. OK.");
      // Genera algo. OK
      rs = da.getQuery("SELECT * FROM Customers");
      assertNotNull(rs);
      System.out.println(rs.toString());
   }

   @Test
   public void testSetQuery() 
   {
      System.out.println("Ejecución de pruebas del método setQuery.");
      DataAccess da = new DataAccess();

      System.out.println("Busqueda nula. ERROR.");
      // Genera error de query nula.
      da.setQuery("");

      System.out.println("Busqueda despistada. ERROR.");
      // Genera error de sintaxis SQL.
      da.setQuery("Textile mañánero");

      System.out.println("Tabla desconocida. ERROR.");
      // Genera error por tabla desconocida.
      da.setQuery("SELECT * FROM Lucas");

      System.out.println("Id fuera de rango. ERROR.");
      da.setQuery("SELECT * FROM Customers WHERE customerID = 111111111111");

      System.out.println("Id distinto tipo. ERROR.");
      da.setQuery("SELECT * FROM Customers WHERE customerID = 'lucas'");

      System.out.println("Id inexistente. OK.");
      da.setQuery("SELECT * FROM Customers WHERE customerID = -111");

      System.out.println("Busqueda correcta. OK.");
      da.setQuery("SELECT * FROM Customers");
   }
}
