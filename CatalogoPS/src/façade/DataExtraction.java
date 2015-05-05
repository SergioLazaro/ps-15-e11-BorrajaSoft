package façade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import database.DataAccess;

public class DataExtraction {	
	
	private DataAccess mda;
	
	
	public DataExtraction() {
		mda = new DataAccess();
	}
	
	public ArrayList<Prenda> lookingForPrenda(String query) throws SQLException{
		ResultSet result = mda.getQuery("SELECT * FROM Productos WHERE nombre "
				+ "LIKE '%" + query + "%'");
		
		ArrayList<Prenda> prodArray = new ArrayList<Prenda>();
		String nombre, marca;
		double precio;
		int cantidad, idTypeProd, idProd;
		Prenda prenda;
		while(result.next()){	//buscamos en la tabla Prenda a ver si esta la busqueda del cliente
			idProd = result.getInt("idProd");
			nombre = result.getString("nombre");
			marca = result.getString("marca");
			precio = result.getDouble("precio");
			cantidad = result.getInt("cantidad");
			idTypeProd = result.getInt("idTypeProd");
			prenda = new Prenda(idProd,precio,nombre,marca,cantidad,idTypeProd);
			prodArray.add(prenda);
		}
		System.out.println("Fin ejecucion lookingForPrenda");
		return prodArray;
	}
	
	public ArrayList<Trabajador> lookingForTrabajador(String query) throws SQLException{
		ResultSet result = mda.getQuery("select * from Trabajador WHERE nombre LIKE '%" 
				+ query + "%'" );
		ArrayList<Trabajador> TrabajadorArray = new ArrayList<Trabajador>();
		int idTrabajador, telefono;
		String nombreTrabajador, direccion, mail, password;
		Trabajador Trabajador;
		while(result.next()){	//buscamos en la tabla Trabajador a ver si esta la busqueda del cliente
			idTrabajador = result.getInt("idTrabajador");
			telefono = result.getInt("telefono");
			nombreTrabajador = result.getString("nombre");
			direccion = result.getString("direccion");
			mail = result.getString("mail");
			password = result.getString("password");
			
			Trabajador = new Trabajador(idTrabajador, nombreTrabajador, direccion, mail, telefono, password);
			TrabajadorArray.add(Trabajador);
		}
		System.out.println("Fin lookingForTrabajadors");
		return TrabajadorArray;
	}
	
	public ArrayList<String> gettingTypeProd() throws SQLException{
		ResultSet result = mda.getQuery("SELECT DISTINCT prenda FROM TypeProd");
		ArrayList<String> array = new ArrayList<String>();
		String prenda;
		while(result.next()){
			prenda = result.getString("prenda");
			array.add(prenda);
		}
		System.out.println("Fin gettingTypeProd");
		return array;
	}
	
	public ArrayList<String> gettingStyleProd(String prenda) throws SQLException{
		ResultSet result = mda.getQuery("SELECT DISTINCT estilo FROM TypeProd "
				+ "WHERE prenda = '" + prenda + "'");
		ArrayList<String> array = new ArrayList<String>();
		String estilo;
		while(result.next()){
			estilo = result.getString("estilo");
			array.add(estilo);
		}
		System.out.println("Fin gettingStyleProd");
		return array;
	}
	
	public ArrayList<String> gettingShoppingCart(int idTrabajador) throws SQLException{
		ResultSet result = mda.getQuery("SELECT t1.nombre as nombre , t1.marca as marca ,"
				+ " t1.precio as precio FROM Productos t1 , Carrito t2 "
				+ "WHERE t1.idProd = t2.idProducto AND t2.idTrabajador = " + idTrabajador);
		ArrayList<String> array = new ArrayList<String>();
		array.add("CARRITO DE LA COMPRA: ");
		String nombre, marca;
		double precio;
		while(result.next()){
			nombre = result.getString("nombre");
			marca = result.getString("marca");
			precio = result.getDouble("precio");
			array.add("- " + nombre + "\t" + marca + "\t" + precio + "€");
		}
		System.out.println("Fin gettingShoppingCart");
		return array;
	}
	
	public ArrayList<String> gettingHistorical(int idTrabajador) throws SQLException{
		ResultSet result = mda.getQuery("SELECT t1.nombre as nombre , t1.marca as marca ,"
				+ " t1.precio as precio FROM Productos t1 , Historico t2 "
				+ "WHERE t1.idProd = t2.idProducto AND t2.idTrabajador = " + idTrabajador
				+ " limit 10");
		ArrayList<String> array = new ArrayList<String>();
		String nombre, marca;
		double precio;
		while(result.next()){
			nombre = result.getString("nombre");
			marca = result.getString("marca");
			precio = result.getDouble("precio");
			array.add("- " + nombre + "   " + marca + "   " + precio + "€");
		}
		return array;
	}
	
	public int enter(String usermail, String password) throws SQLException{
		ResultSet result = mda.getQuery("SELECT mail , password , idTrabajador FROM Trabajador"
				+ " WHERE mail = '" + usermail + "' AND password = '" + password + "'");
		int idUser = -1;
		String nameAux,passwordAux;
		while(result.next()){
			nameAux = result.getString("mail");
			passwordAux = result.getString("password");
			if (nameAux.equalsIgnoreCase(usermail) && passwordAux.equalsIgnoreCase(password)){
				idUser = result.getInt("idTrabajador");
			}
		}
		System.out.println("Fin enter");
		return idUser;
	}
	
}
