package façade;

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
    * 
    * @param usermail
    * @param password
    * @return
    * @throws SQLException
    */
   public int enter(String usermail, String password) throws SQLException {
      int idUser = -1;
      ResultSet result = mda.getQuery("SELECT mail , password , idTrabajador FROM Trabajador"
               + " WHERE mail = '" + usermail + "' AND password = '" + password + "'");

      while (result.next()) {
         String nameAux = result.getString("mail");
         String passwordAux = result.getString("password");
         if (nameAux.equalsIgnoreCase(usermail) && passwordAux.equalsIgnoreCase(password)) {
            idUser = result.getInt("idTrabajador");
         }
      }

      System.out.println("Fin enter");
      return idUser;
   }

   /**
    * 
    * @param idTrabajador
    * @return
    * @throws SQLException
    */
   public ArrayList<String> gettingHistorical(int idTrabajador) throws SQLException {
      ArrayList<String> array = new ArrayList<String>();
      ResultSet result = mda.getQuery("SELECT t1.nombre as nombre , t1.marca as marca ,"
               + " t1.precio as precio FROM Productos t1 , Historico t2 "
               + "WHERE t1.idProd = t2.idProducto AND t2.idTrabajador = " + idTrabajador
               + " limit 10");

      while (result.next()) {
         String nombre = result.getString("nombre");
         String marca = result.getString("marca");
         double precio = result.getDouble("precio");
         array.add("- " + nombre + "   " + marca + "   " + precio + "€");
      }

      return array;
   }

   /**
    * 
    * @param idTrabajador
    * @return
    * @throws SQLException
    */
   public ArrayList<String> gettingShoppingCart(int idTrabajador) throws SQLException {
      ArrayList<String> array = new ArrayList<String>();
      array.add("CARRITO DE LA COMPRA: ");
      ResultSet result = mda.getQuery("SELECT t1.nombre as nombre , t1.marca as marca ,"
               + " t1.precio as precio FROM Productos t1 , Carrito t2 "
               + "WHERE t1.idProd = t2.idProducto AND t2.idTrabajador = " + idTrabajador);

      while (result.next()) {
         String nombre = result.getString("nombre");
         String marca = result.getString("marca");
         double precio = result.getDouble("precio");
         array.add("- " + nombre + "\t" + marca + "\t" + precio + "€");
      }

      System.out.println("Fin gettingShoppingCart");
      return array;
   }

   /**
    * 
    * @param prenda
    * @return
    * @throws SQLException
    */
   public ArrayList<String> gettingStyleProd(String prenda) throws SQLException {
      ArrayList<String> array = new ArrayList<String>();
      ResultSet result = mda.getQuery("SELECT DISTINCT estilo FROM TypeProd " + "WHERE prenda = '" + prenda + "'");

      while (result.next()) {
         String estilo = result.getString("estilo");
         array.add(estilo);
      }

      System.out.println("Fin gettingStyleProd");
      return array;
   }

   /**
    * 
    * @return
    * @throws SQLException
    */
   public ArrayList<String> gettingTypeProd() throws SQLException {
      ArrayList<String> array = new ArrayList<String>();
      ResultSet result = mda.getQuery("SELECT DISTINCT prenda FROM TypeProd");

      while (result.next()) {
         String prenda = result.getString("prenda");
         array.add(prenda);
      }

      System.out.println("Fin gettingTypeProd");
      return array;
   }

   /**
    * 
    * @param query
    * @return
    * @throws SQLException
    */
   public ArrayList<Clothes> lookingForClothes(String query) throws SQLException {
      ArrayList<Clothes> prodArray = new ArrayList<Clothes>();
      ResultSet result = mda.getQuery("SELECT * FROM Productos WHERE nombre " + "LIKE '%" + query + "%'");

      // Buscamos en la tabla Prenda a ver si esta la busqueda del cliente.
      while (result.next()) { 
         int idProd = result.getInt("idProd");
         String nombre = result.getString("nombre");
         String marca = result.getString("marca");
         double precio = result.getDouble("precio");
         int cantidad = result.getInt("cantidad");
         int idTypeProd = result.getInt("idTypeProd");
         Clothes clothes = new Clothes(idProd, precio, nombre, marca, cantidad, idTypeProd);
         prodArray.add(clothes);
      }

      System.out.println("Fin ejecucion lookingForPrenda");
      return prodArray;
   }

   /**
    * 
    */
   public ArrayList<Worker> lookingForWorkers(String query) throws SQLException {
      ArrayList<Worker> TrabajadorArray = new ArrayList<Worker>();
      ResultSet result = mda.getQuery("select * from Trabajador WHERE nombre LIKE '%" + query + "%'");

      // Buscamos en la tabla Trabajador a ver si esta la busqueda del cliente.
      while (result.next()) { 
         int idTrabajador = result.getInt("idTrabajador");
         int telefono = result.getInt("telefono");
         String nombreTrabajador = result.getString("nombre");
         String direccion = result.getString("direccion");
         String mail = result.getString("mail");
         String password = result.getString("password");
         Worker worker = new Worker(idTrabajador, nombreTrabajador, direccion, mail, telefono, password);
         TrabajadorArray.add(worker);
      }

      System.out.println("Fin lookingForTrabajadors");
      return TrabajadorArray;
   }
}
