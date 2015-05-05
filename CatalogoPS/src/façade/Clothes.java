package façade;

public class Clothes {
   private String brand;
   private String name;
   private double price;
   private int productID;
   private int productTypeID;
   private int stock;

   /**
    * Create clothes object based on the input data.
    * 
    * @param productID
    * @param productTypeID
    * @param name
    * @param brand
    * @param stock
    * @param price
    */
   public Clothes(int productID, double price, String name, String brand, int stock, int productTypeID) {
      this.productID = productID;
      this.price = price;
      this.name = name;
      this.brand = brand;
      this.stock = stock;
      this.productTypeID = productTypeID;
   }

   public String getBrand() {
      return brand;
   }

   public String getName() {
      return name;
   }

   public double getPrice() {
      return price;
   }

   public int getProductID() {
      return productID;
   }

   public int getProductTypeID() {
      return productTypeID;
   }

   public int getStock() {
      return stock;
   }

   public void setBrand(String brand) {
      this.brand = brand;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setPrice(double price) {
      this.price = price;
   }

   public void setProductID(int productID) {
      this.productID = productID;
   }

   public void setProductTypeID(int productTypeID) {
      this.productTypeID = productTypeID;
   }

   public void setStock(int stock) {
      this.stock = stock;
   }

   @Override
   public String toString() {
      return productID + "\t" + price + "\t" + name + "\t" + brand + "\t" + stock + "\t" + productTypeID;
   }
}
