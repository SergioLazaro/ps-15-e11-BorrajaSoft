package façade;

public class ProductType {
   private String color;
   private String estilo;
   private int idTypeProd;
   private String path;
   private String prenda;
   private String talla;

   /**
    * 
    * @param idTypeProd
    * @param prenda
    * @param color
    * @param estilo
    * @param path
    * @param talla
    */
   public ProductType(int idTypeProd, String prenda, String color, String estilo, String path, String talla) {
      this.idTypeProd = idTypeProd;
      this.prenda = prenda;
      this.color = color;
      this.estilo = estilo;
      this.path = path;
      this.talla = talla;
   }

   public String getColor() {
      return color;
   }

   public String getEstilo() {
      return estilo;
   }

   public int getIdTypeProd() {
      return idTypeProd;
   }

   public String getPath() {
      return path;
   }

   public String getPrenda() {
      return prenda;
   }

   public String getTalla() {
      return talla;
   }

   public void setColor(String color) {
      this.color = color;
   }

   public void setEstilo(String estilo) {
      this.estilo = estilo;
   }

   public void setIdTypeProd(int idTypeProd) {
      this.idTypeProd = idTypeProd;
   }

   public void setPath(String path) {
      this.path = path;
   }

   public void setPrenda(String prenda) {
      this.prenda = prenda;
   }

   public void setTalla(String talla) {
      this.talla = talla;
   }

   public String toString() {
      return idTypeProd + "\t" + prenda + "\t" + color + "\t" + estilo + "\t" + path + "\t" + talla;
   }
}
