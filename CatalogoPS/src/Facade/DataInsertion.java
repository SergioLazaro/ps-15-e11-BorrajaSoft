package Facade;

import BD.MyDataAcces;

public class DataInsertion {

	private static MyDataAcces mda;

	public static void main(String[] args) {
		DataInsertion dt = new DataInsertion();

		Prenda p = new Prenda(1001, 1234, "nuevoProducto", "nuevaMarca", 111, 1);
		dt.insertProducto(p);
	}

	public DataInsertion() {
		mda = new MyDataAcces();
	}

	/**
	 * Inserta en la BD el Pedido parametrizado
	 * 
	 * @param pedido
	 */
	public void insertPedido(Pedido pedido) {
		mda.setQuery("INSERT INTO `pedidos` VALUES (" + pedido.getIdPyme()
				+ ", " + pedido.getIdProducto() + ", " + pedido.getCantidad()
				+ ", '" + pedido.getFecha() + "')");
	}
	

	/**
	 * Inserta en la BD la Prenda parametrizada
	 * @param prenda
	 */
	public void insertProducto(Prenda prenda) {
		mda.setQuery("INSERT INTO `productos` VALUES (" + prenda.getIdProd()
				+ ", " + prenda.getPrecio() + ", '" + prenda.getNombre()
				+ "', '" + prenda.getMarca() + "', " + prenda.getCantidad()
				+ ", "+ prenda.getIdTypeProd() + ")");
	}
}
