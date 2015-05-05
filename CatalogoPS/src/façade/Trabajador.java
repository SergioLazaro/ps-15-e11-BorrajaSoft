package façade;

public class Trabajador {

	private int idTrabajador;
	private String nombre;
	private String direccion;
	private String mail;
	private int telefono;
	private String password;
	
	
	public Trabajador(int idTrabajador, String nombre, String direccion, String mail, int telefono, String password) {
		this.idTrabajador = idTrabajador;
		this.nombre = nombre;
		this.direccion = direccion;
		this.mail = mail;
		this.telefono = telefono;
		this.password = password;
	}


	@Override
	public String toString() {
		return idTrabajador + "\t" + nombre + "\t" + direccion + "\t" + mail + "\t" + telefono + "\t" + password;
	}


	public int getidTrabajador() {
		return idTrabajador;
	}


	public void setidTrabajador(int idTrabajador) {
		this.idTrabajador = idTrabajador;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getMail() {
		return mail;
	}


	public void setMail(String mail) {
		this.mail = mail;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
