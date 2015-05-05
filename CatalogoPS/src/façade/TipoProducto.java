package façade;

public class TipoProducto {

	private int idTypeProd;
	private String prenda;
	private String color;
	private String estilo;
	private String path;
	private String talla;
	
	
	public TipoProducto (int idTypeProd, String prenda, String color, String estilo, String path, String talla) {
		this.idTypeProd = idTypeProd;
		this.prenda = prenda;
		this.color = color;
		this.estilo = estilo;
		this.path = path;
		this.talla = talla;
	}
	
	
	public String toString() {
		return idTypeProd + "\t" + prenda + "\t" + color + "\t" + estilo + "\t" + path + "\t" + talla;
	}


	public int getIdTypeProd() {
		return idTypeProd;
	}


	public void setIdTypeProd(int idTypeProd) {
		this.idTypeProd = idTypeProd;
	}


	public String getPrenda() {
		return prenda;
	}


	public void setPrenda(String prenda) {
		this.prenda = prenda;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}


	public String getEstilo() {
		return estilo;
	}


	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getTalla() {
		return talla;
	}


	public void setTalla(String talla) {
		this.talla = talla;
	}
	
	
}
