package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataAccess {
   private static String _bd = "CatalogueDB";
   private static String _url = "jdbc:mysql://localhost/" + _bd;
   private String _pwd = ""; // CONTROLAR CONTRASEÑA DEL SERVIDOR
   private String _usuario = "root";
   private Connection conn = null;

   /**
    * Create the connection with the database.
    */
   public DataAccess() {
      try {
         Class.forName("com.mysql.jdbc.Connection");
         conn = (Connection) DriverManager.getConnection(_url, _usuario, _pwd);
         if (conn != null) {
            System.out.println("Conexion a base de datos " + _url + " . . . Ok");
         }
      } catch (SQLException ex) {
         System.out.println("Hubo un problema al intentar conectarse a la base de datos " + _url);
      } catch (ClassNotFoundException ex) {
         System.out.println(ex);
      }
   }

   /**
    * Return the result of a search in the database. 
    * 
    * @param query Expression searched.
    * @return      Rows that granted the searched.
    */
   public ResultSet getQuery(String query) {
      ResultSet resultado = null;

      try {
         Statement state = (Statement) conn.createStatement();
         resultado = state.executeQuery(query);
      } catch (SQLException e) {
         e.printStackTrace();
      }

      return resultado;
   }

   /**
    * Set a query to the database.
    * 
    * @param query Query to set.
    */
   public void setQuery(String query) {
      try {
         Statement state = (Statement) conn.createStatement();
         state.execute(query);
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
}
