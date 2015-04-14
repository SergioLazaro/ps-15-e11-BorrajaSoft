package Facade;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import BD.MyDataAcces;

public class DataExtraction {	
	
	private MyDataAcces mda;
	
	
	public DataExtraction() {
		mda = new MyDataAcces();
	}
	
	
	/**
	 * 
	 * @return un array con todas las prendas (productos) contenidos en la BD
	 * @throws SQLException
	 */
	public ArrayList<Prenda> extractPrendas() throws SQLException {
		ArrayList<Prenda> array = new ArrayList<Prenda>();
		
		ResultSet result = mda.getQuery("Select * from Productos");
		
		int idProd, cantidad, idTypeProd;
		double precio;
		String nombre, marca;
		
		while (result.next()) {
			idProd = result.getInt("idProd");
			precio = result.getDouble("precio");
			nombre = result.getString("nombre");
			marca = result.getString("marca");
			cantidad = result.getInt("cantidad");
			idTypeProd = result.getInt("idTypeProd");
			
			Prenda aux = new Prenda(idProd, precio, nombre, marca, cantidad, idTypeProd);
			System.out.println(aux.toString());
			array.add(aux);
		}
		
		System.out.println("Cantidad total = " + array.size());
		return array;
	}

	
	/**
	 * 
	 * @return un array con todos los pedidos contenidos en la BD
	 * @throws SQLException
	 */
	public ArrayList<Pedido> extractPedidos() throws SQLException {
		ArrayList<Pedido> array = new ArrayList<Pedido>();
		
		ResultSet result = mda.getQuery("Select * from Pedidos");
		
		int idPyme, idProducto, cantidad;
		String fecha;
		
		while (result.next()) {
			idPyme = result.getInt("idPyme");
			idProducto = result.getInt("idProducto");
			cantidad = result.getInt("cantidad");
			fecha = result.getString("fecha");
			
			Pedido aux = new Pedido(idPyme, idProducto, cantidad, fecha);
			System.out.println(aux.toString());
			array.add(aux);
		}
		
		System.out.println("Cantidad total = " + array.size());
		return array;
	}
	
	
	/**
	 * 
	 * @return un array con todas las Pymes de la BD
	 * @throws SQLException
	 */
	public ArrayList<Pyme> extractPymes() throws SQLException {
		ArrayList<Pyme> array = new ArrayList<Pyme>();
		
		ResultSet result = mda.getQuery("Select * from Productos");
		
		int idPyme, telefono;
		String nombre, direccion, mail, password;
		
		while (result.next()) {
			idPyme = result.getInt("idPyme");
			telefono = result.getInt("telefono");
			nombre = result.getString("nombre");
			direccion = result.getString("direccion");
			mail = result.getString("mail");
			password = result.getString("password");
			
			Pyme aux = new Pyme(idPyme, nombre, direccion, mail, telefono, password);
			System.out.println(aux.toString());
			array.add(aux);
		}
				
		System.out.println("Cantidad total = " + array.size());
		return array;
	}
	
	
	/**
	 * 
	 * @return un array con todos los TipoProducto de la BD
	 * @throws SQLException
	 */
	public ArrayList<TipoProducto> extractTipoProducto() throws SQLException {
		ArrayList<TipoProducto> array = new ArrayList<TipoProducto>();
		
		ResultSet result = mda.getQuery("Select * from typeProd");
		
		int idTypeProd;
		String prenda, color, estilo, path, talla;
		
		while (result.next()) {
			idTypeProd = result.getInt("idTypeProd");
			prenda = result.getString("prenda");
			color = result.getString("color");
			estilo = result.getString("estilo");
			path = result.getString("path");
			talla = result.getString("talla");
			
			TipoProducto aux = new TipoProducto(idTypeProd, prenda, color, estilo, path, talla);
			System.out.println(aux.toString());
			array.add(aux);
		}
		
		System.out.println("Cantidad total = " + array.size());
		return array;
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
			System.out.println(prenda.toString());
			prodArray.add(prenda);
		}
		System.out.println("Fin ejecucion lookingForPrenda.");
		return prodArray;
	}
	
	public ArrayList<Pyme> lookingForPymes(String query) throws SQLException{
		ResultSet result = mda.getQuery("select * from Pymes WHERE nombre LIKE '%" 
				+ query + "%'" );
		ArrayList<Pyme> pymesArray = new ArrayList<Pyme>();
		int idPyme, telefono;
		String nombrePyme, direccion, mail, password;
		Pyme pyme;
		while(result.next()){	//buscamos en la tabla Pyme a ver si esta la busqueda del cliente
			idPyme = result.getInt("idPyme");
			telefono = result.getInt("telefono");
			nombrePyme = result.getString("nombre");
			direccion = result.getString("direccion");
			mail = result.getString("mail");
			password = result.getString("password");
			
			pyme = new Pyme(idPyme, nombrePyme, direccion, mail, telefono, password);
			System.out.println(pyme.toString());
			pymesArray.add(pyme);
		}
		System.out.println("Fin ejecucion lookingForPymes.");
		return pymesArray;
	}
	
}
