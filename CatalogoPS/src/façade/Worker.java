package façade;

public class Worker {
   private String direccion;
   private int idTrabajador;
   private String mail;
   private String nombre;
   private String password;
   private int telefono;

   public Worker(int idTrabajador, String nombre, String direccion, String mail, int telefono, String password) {
      this.idTrabajador = idTrabajador;
      this.nombre = nombre;
      this.direccion = direccion;
      this.mail = mail;
      this.telefono = telefono;
      this.password = password;
   }

   public String getDireccion() {
      return direccion;
   }

   public int getidTrabajador() {
      return idTrabajador;
   }

   public String getMail() {
      return mail;
   }

   public String getNombre() {
      return nombre;
   }

   public String getPassword() {
      return password;
   }

   public int getTelefono() {
      return telefono;
   }

   public void setDireccion(String direccion) {
      this.direccion = direccion;
   }

   public void setidTrabajador(int idTrabajador) {
      this.idTrabajador = idTrabajador;
   }

   public void setMail(String mail) {
      this.mail = mail;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public void setTelefono(int telefono) {
      this.telefono = telefono;
   }

   @Override
   public String toString() {
      return idTrabajador + "\t" + nombre + "\t" + direccion + "\t" + mail + "\t" + telefono + "\t"
               + password;
   }
}
