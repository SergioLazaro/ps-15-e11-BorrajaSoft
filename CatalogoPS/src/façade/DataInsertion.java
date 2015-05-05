package façade;

import database.DataAccess;

public class DataInsertion {
   private static DataAccess mda;

   /**
    * 
    */
   public DataInsertion() {
      mda = new DataAccess();
   }

   /**
    * 
    * @param args
    */
   public static void main(String[] args) {
      DataInsertion dt = new DataInsertion();

      Clothes p = new Clothes(1001, 1234, "nuevoProducto", "nuevaMarca", 111, 1);
      dt.insertProducto(p);
   }

   /**
    * Inserta en la BD el Pedido parametrizado
    * 
    * @param pedido
    */
   public void insertPedido(Order pedido) {
      mda.setQuery("INSERT INTO `pedidos` VALUES (" + pedido.getIdPyme() + ", "
               + pedido.getIdProducto() + ", " + pedido.getCantidad() + ", '" + pedido.getFecha()
               + "')");
   }

   /**
    * Inserta en la BD la Prenda parametrizada
    * 
    * @param prenda
    */
   public void insertProducto(Clothes prenda) {
      mda.setQuery("INSERT INTO `productos` VALUES (" + prenda.getIdProd() + ", "
               + prenda.getPrecio() + ", '" + prenda.getNombre() + "', '" + prenda.getMarca()
               + "', " + prenda.getCantidad() + ", " + prenda.getIdTypeProd() + ")");
   }
}
