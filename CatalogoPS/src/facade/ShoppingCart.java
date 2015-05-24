package facade;

public class ShoppingCart {
   private int customerID;
   private int numItems;
   private String productID;

   public ShoppingCart(int customerID, String productID, int numItems) {
      this.customerID = customerID;
      this.productID = productID;
      this.numItems = numItems;
   }

   public int getCustomerID() {
      return customerID;
   }

   public int getNumItems() {
      return numItems;
   }

   public String getProductID() {
      return productID;
   }

   public void setCustomerID(int customerID) {
      this.customerID = customerID;
   }

   public void setNumItems(int numItems) {
      this.numItems = numItems;
   }

   public void setProductID(String productID) {
      this.productID = productID;
   }

   @Override
   public String toString() {
      return customerID + ", " + productID + ", " + numItems;
   }
}
