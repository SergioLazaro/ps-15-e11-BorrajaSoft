package façade;

public class Prenda {
	
	private int idProd;
	private double precio;
	private String nombre;
	private String marca;
	private int cantidad;
	private int idTypeProd;
	
	
	/**
	 * Crea una Prenda a partir de los datos parametrizados
	 * @param idProd
	 * @param precio
	 * @param nombre
	 * @param marca
	 * @param cantidad
	 * @param idTypeProd
	 */
	public Prenda(int idProd, double precio, String nombre, String marca, int cantidad, int idTypeProd) {
		this.idProd = idProd;
		this.precio = precio;
		this.nombre = nombre;
		this.marca =  marca;
		this.cantidad = cantidad;
		this.idTypeProd = idTypeProd;
	}

	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getIdTypeProd() {
		return idTypeProd;
	}

	public void setIdTypeProd(int idTypeProd) {
		this.idTypeProd = idTypeProd;
	}
	
	public String toString() {
		return idProd + "\t" + precio + "\t" + nombre + "\t" + marca + "\t" + cantidad + "\t" + idTypeProd;
	}
}
