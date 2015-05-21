package facade;

public class OrderRecord {
   private int numItems;
   private int orderID;
   private int orderRecordID;
   private double pricePerItem;
   private int productID;

   public OrderRecord(int orderID, int orderRecordID, int productID, int numItems,
            double pricePerItem) {
      this.orderID = orderID;
      this.orderRecordID = orderRecordID;
      this.productID = productID;
      this.numItems = numItems;
      this.pricePerItem = pricePerItem;
   }

   public int getNumItems() {
      return numItems;
   }

   public int getOrderID() {
      return orderID;
   }

   public int getOrderRecordID() {
      return orderRecordID;
   }

   public double getPricePerItem() {
      return pricePerItem;
   }

   public int getProductID() {
      return productID;
   }

   public void setNumItems(int numItems) {
      this.numItems = numItems;
   }

   public void setOrderID(int orderID) {
      this.orderID = orderID;
   }

   public void setOrderRecordID(int orderRecordID) {
      this.orderRecordID = orderRecordID;
   }

   public void setPricePerItem(double pricePerItem) {
      this.pricePerItem = pricePerItem;
   }

   public void setProductID(int productID) {
      this.productID = productID;
   }

   @Override
   public String toString() {
      return orderID + ", " +
             //orderRecordID + ", " +
             productID + ", " +
             numItems;
             //pricePerItem;
   }
}
