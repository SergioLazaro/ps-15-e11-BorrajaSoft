package facade;

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

      Product p = new Product(1001, 1234, "nuevaMarca", "nuevoProducto", 11, 111);
      dt.insertProduct(p);
   }

   /**
    * Insert data into the ProductType table.
    * 
    * @param productType
    *           The data to insert.
    */
   public void insertProductType(ProductType productType) {
      mda.setQuery("INSERT INTO ProductTypes VALUES (" + productType.toString() + ")");
   }

   /**
    * Insert data into the Products table.
    * 
    * @param product
    *           The data to insert.
    */
   public void insertProduct(Product product) {
      mda.setQuery("INSERT INTO Products VALUES (" + product.toString() + ")");
   }

   /**
    * Insert data into the Customers table.
    * 
    * @param customer
    *           The data to insert.
    */
   public void insertCustomer(Customer customer) {
      mda.setQuery("INSERT INTO Customers VALUES (" + customer.toString() + ")");
   }

   /**
    * Insert data into the ShoppingCarts table.
    * 
    * @param shoppingCart
    *           The data to insert.
    */
   public void insertShoppingCart(ShoppingCart shoppingCart) {
      mda.setQuery("INSERT INTO ShoppingCarts VALUES (" + shoppingCart.toString() + ")");
   }

   /**
    * Insert data into the Orders table.
    * 
    * @param order
    *           The data to insert.
    */
   public void insertOrder(Order order) {
      mda.setQuery("INSERT INTO Orders VALUES (" + order.toString() + ")");
   }

   /**
    * Insert data into the OrderRecords table.
    * 
    * @param orderRecord
    *           The data to insert.
    */
   public void insertOrderRecord(OrderRecord orderRecord) {
      mda.setQuery("INSERT INTO OrderRecords VALUES (" + orderRecord.toString() + ")");
   }
}
