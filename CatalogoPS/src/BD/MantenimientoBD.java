package BD;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class MantenimientoBD {

	public static void main(String[] args) {
		MyDataAcces mda = new MyDataAcces();
		insertPath(mda);		
	}
	
	/**
	 * PRE: mda != null 
	 * POST: Modifica todas las filas de la tabla TypeProd asignando un valor a 
	 * 		a la columna "estilo" segun un numero obtenido mediante un objeto Random
	 */
	private static void modificarTypeProd(MyDataAcces mda){
		ResultSet result;
		result = mda.getQuery("SELECT * FROM TypeProd ");
		String prenda = "";
		int id = -1;
		int num = -1;
		Random rm = new Random();
		try {
			while(result.next()){
				id = result.getInt("idTypeProd");
				prenda = result.getString("prenda");
				if ( prenda.equals("polo") ){
					num = rm.nextInt(2);
					if ( num == 0 ){
						mda.setQuery("UPDATE TypeProd SET estilo = 'liso' WHERE idTypeProd = " + id);
						System.out.println("Polo modificado");
					}
					else{
						mda.setQuery("UPDATE TypeProd SET estilo = 'a rayas' WHERE idTypeProd = " + id);
						System.out.println("Polo modificado");
					}
				}
				else if( prenda.equals("jersey")){
					num = rm.nextInt(2);
					if ( num == 0 ){
						mda.setQuery("UPDATE TypeProd SET estilo = 'liso' WHERE idTypeProd = " + id);
						System.out.println("Jersey modificado");
					}
					else{
						mda.setQuery("UPDATE TypeProd SET estilo = 'a rayas' WHERE idTypeProd = " + id);
						System.out.println("Jersey modificado");
					}
				}
				else if(prenda.equals("camiseta")){
					num = rm.nextInt(2);
					if ( num == 0 ){
						mda.setQuery("UPDATE TypeProd SET estilo = 'liso' WHERE idTypeProd = " + id);
						System.out.println("Camiseta modificada");
					}
					else{
						mda.setQuery("UPDATE TypeProd SET estilo = 'a rayas' WHERE idTypeProd = " + id);
						System.out.println("Camiseta modificada ");
					}
				}
				else if(prenda.equals("calcetines")){
					num = rm.nextInt(2);
					if ( num == 0 ){
						mda.setQuery("UPDATE TypeProd SET estilo = 'cortos' WHERE idTypeProd = " + id);
						System.out.println("Calcetines modificados");
					}
					else{
						mda.setQuery("UPDATE TypeProd SET estilo = 'largos' WHERE idTypeProd = " + id);
						System.out.println("Calcetines modificados");
					}
				}
				else if(prenda.equals("pantalon")){
					num = rm.nextInt(2);
					if ( num == 0 ){
						mda.setQuery("UPDATE TypeProd SET estilo = 'vaquero' WHERE idTypeProd = " + id);
						System.out.println("Pantalon modificado");
					}
					else{
						mda.setQuery("UPDATE TypeProd SET estilo = 'corto' WHERE idTypeProd = " + id);
						System.out.println("Pantalon modificado");
					}
				}
				else if(prenda.equals("calzoncillos")){
					num = rm.nextInt(2);
					if ( num == 0 ){
						mda.setQuery("UPDATE TypeProd SET estilo = 'boxer' WHERE idTypeProd = " + id);
						System.out.println("Calzoncillos modificados");
					}
					else{
						mda.setQuery("UPDATE TypeProd SET estilo = 'slip' WHERE idTypeProd = " + id);
						System.out.println("Calzoncillos modificados");
					}
				}
				else if(prenda.equals("sudadera")){
					num = rm.nextInt(2);
					if ( num == 0 ){
						mda.setQuery("UPDATE TypeProd SET estilo = 'con capucha lisa' WHERE idTypeProd = " + id);
						System.out.println("Sudadera modificados");
					}
					else{
						mda.setQuery("UPDATE TypeProd SET estilo = 'con capucha a rayas' WHERE idTypeProd = " + id);
						System.out.println("Sudadera modificados");
					}
				}
				
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	/**
	 * PRE: mda != null
	 * POST: Modifica la tabla Productos estableciendo la columna nombre como una union
	 * 		de tres elementos de la tabla TypeProd:
	 * 		nombre = prenda + estilo + color
	 */
	private static void modificarProductos(MyDataAcces mda){
		ResultSet result1;
		ResultSet result2 = mda.getQuery("SELECT * FROM Productos");
		String nombre = "";
		int idType = -1;
		try{
			while(result2.next()){
				result1 = mda.getQuery("SELECT * FROM TypeProd WHERE idTypeProd = " + result2.getInt("idTypeProd"));
				while(result1.next()){
					idType = result1.getInt("idTypeProd");
					nombre = result1.getString("prenda") +" " + result1.getString("estilo") + 
							" de color " + result1.getString("color");
				}
				System.out.println(nombre);
				mda.setQuery("UPDATE Productos SET nombre = '" + nombre + "' WHERE idProd = " + 
						result2.getInt("idProd") + " AND idTypeProd = " + idType);
				System.out.println("UPDATE HECHO");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	/**
	 * PRE: mda != null
	 * POST: Realiza una comprobacion de un elemento de la tabla, en este caso del elemento 
	 * 		con idProd = 54, para tener certeza de que el campo "nombre" de la tabla Productos
	 * 		ha sido rellenado correctamente con los tres elementos de la tabla TypeProd que lo forman. 
	 * 		nombre = prenda + estilo + color
	 */
	private static void comprobarTablaProductos(MyDataAcces mda){
		ResultSet result2 = mda.getQuery("SELECT * FROM Productos WHERE idProd = 54");
		String nombre = "";
		int idType = -1;
		try {
			while(result2.next()){
				idType = result2.getInt("idTypeProd");
				System.out.println(result2.getString("nombre"));
			}
			ResultSet result1 = mda.getQuery("SELECT * FROM TypeProd WHERE idTypeProd = "+idType);
			while(result1.next()){
				nombre = result1.getString("prenda") +" " + result1.getString("estilo") + 
						" de color " + result1.getString("color");
				System.out.println(nombre);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * PRE: mda != null 
	 * POST: Modifica la tabla PYMES añadiendo en la columna "password" una contraseña
	 * 		estandar, en este caso, 1234.
	 */
	private static void insertarPassword(MyDataAcces mda){
		ResultSet result = mda.getQuery("SELECT * FROM PYMES");
		int id = -1;
		try {
			while(result.next()){
				id = result.getInt("idPYME");
				mda.setQuery("UPDATE PYMES SET password = '1234' WHERE idPYME = " + id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * PRE: mda != null
	 * POST: Modifica la tabla TypeProd asignandole a la columna "path" una ruta de foto acorde
	 * 		al tipo de prenda que se trate.
	 * 		Ejemplo: prenda = camiseta -> path = /photos/camiseta.jpg 
	 *
	 */
	private static void insertPath(MyDataAcces mda){
		ResultSet result = mda.getQuery("SELECT * FROM TypeProd");
		String prenda = "";
		try{
			while(result.next()){
				prenda = result.getString("prenda");
				mda.setQuery("UPDATE TypeProd SET path = '/photos/" + prenda + ".jpg' WHERE idTypeProd = " + 
						result.getInt("idTypeProd"));
			}
			System.out.println("Paths modificados");
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

}
