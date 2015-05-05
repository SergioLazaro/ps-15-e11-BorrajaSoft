package façade;

public class Order {
   private int amount;
   private String fecha;
   private int idProducto;
   private int idPyme;

   /**
    * Crea un Pedido a partir de los datos parametrizados
    * 
    * @param idPyme
    * @param idProducto
    * @param cantidad
    * @param fecha
    */
   public Order(int idPyme, int idProducto, int cantidad, String fecha) {
      this.idPyme = idPyme;
      this.idProducto = idProducto;
      this.amount = cantidad;
      this.fecha = fecha;
   }

   public int getCantidad() {
      return amount;
   }

   public String getFecha() {
      return fecha;
   }

   public int getIdProducto() {
      return idProducto;
   }

   public int getIdPyme() {
      return idPyme;
   }

   public void setCantidad(int cantidad) {
      this.amount = cantidad;
   }

   public void setFecha(String fecha) {
      this.fecha = fecha;
   }

   public void setIdProducto(int idProducto) {
      this.idProducto = idProducto;
   }

   public void setIdPyme(int idPyme) {
      this.idPyme = idPyme;
   }

   public String toString() {
      return idPyme + "\t" + idProducto + "\t" + amount + "\t" + fecha;
   }
}
