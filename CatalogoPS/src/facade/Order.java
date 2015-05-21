package facade;

public class Order {
   private int customerID;
   private String date;
   private int orderID;
   private double totalPrice;

   /**
    * Constructor
    */ 
   public Order(int orderID, int customerID, String date, double totalPrice) {
      this.orderID = orderID;
      this.customerID = customerID;
      this.date = date;
      this.totalPrice = totalPrice;
   }

   public int getCustomerID() {
      return customerID;
   }

   public String getDate() {
      return date;
   }

   public int getOrderID() {
      return orderID;
   }

   public double getTotalPrice() {
      return totalPrice;
   }

   public void setCustomerID(int customerID) {
      this.customerID = customerID;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public void setOrderID(int orderID) {
      this.orderID = orderID;
   }

   public void setTotalPrice(double totalPrice) {
      this.totalPrice = totalPrice;
   }

   @Override
   public String toString() {
      return orderID + "\t" + customerID + "\t" + date + "\t" + totalPrice;
   }

   /**
    * Create the sentence to insert a row in the table Order.
    * 
    * @return The string to insert.
    */
   public String toInsert() {
      return customerID + ", " +
             "'" + date + "', " +
             totalPrice;
   }
}
