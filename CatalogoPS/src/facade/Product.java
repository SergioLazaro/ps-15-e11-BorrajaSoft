package facade;

public class Product {
   private String brand;
   private String name;
   private double price;
   private int productID;
   private int productTypeID;
   private int stock;

   public Product(int productID, int productTypeID, String brand, String name, double price, int stock) {
      this.productID = productID;
      this.productTypeID = productTypeID;
      this.brand = brand;
      this.name = name;
      this.price = price;
      this.stock = stock;
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
      return productID + " , " +  name + " , " + brand + " , " + price +"€ , " + stock;
   }
   
  
}
