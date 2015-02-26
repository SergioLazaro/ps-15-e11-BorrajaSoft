package Facade;

public class Pedido {

	private int idPyme;
	private int idProducto;
	private int cantidad;
	private String fecha;
	
	/**
	 * Crea un Pedido a partir de los datos parametrizados
	 * @param idPyme
	 * @param idProducto
	 * @param cantidad
	 * @param fecha
	 */
	public Pedido(int idPyme, int idProducto, int cantidad, String fecha) {
		this.idPyme = idPyme;
		this.idProducto = idProducto;
		this.cantidad = cantidad;
		this.fecha =  fecha;
	}
		
	public String toString() {
		return idPyme + "\t" + idProducto + "\t" + cantidad + "\t" + fecha;
	}

	public int getIdPyme() {
		return idPyme;
	}

	public void setIdPyme(int idPyme) {
		this.idPyme = idPyme;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	
}
