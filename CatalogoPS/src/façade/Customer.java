package façade;

public class Customer {
   private int customerID;
   private String deliveringAddress;
   private String mailAddress;
   private String name;
   private String password;
   private String surname;
   private int telephone;
   private String username;

   public Customer(int customerID, String username, String password, String name, String surname,
            String deliveringAddress, String mailAddress, int telephone) {
      this.customerID = customerID;
      this.username = username;
      this.password = password;
      this.name = name;
      this.surname = surname;
      this.deliveringAddress = deliveringAddress;
      this.mailAddress = mailAddress;
      this.telephone = telephone;
   }

   public int getCustomerID() {
      return customerID;
   }

   public String getDeliveringAddress() {
      return deliveringAddress;
   }

   public String getMailAddress() {
      return mailAddress;
   }

   public String getName() {
      return name;
   }

   public String getPassword() {
      return password;
   }

   public String getSurname() {
      return surname;
   }

   public int getTelephone() {
      return telephone;
   }

   public String getUsername() {
      return username;
   }

   public void setCustomerID(int customerID) {
      this.customerID = customerID;
   }

   public void setDeliveringAddress(String deliveringAddress) {
      this.deliveringAddress = deliveringAddress;
   }

   public void setMailAddress(String mailAddress) {
      this.mailAddress = mailAddress;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public void setSurname(String surname) {
      this.surname = surname;
   }

   public void setTelephone(int telephone) {
      this.telephone = telephone;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   @Override
   public String toString() {
      return customerID + ", " +
             "'" + username + "', " +
             "'" + password + "', " +
             "'" + name + "', " +
             "'" + surname + "', " +
             "'" + deliveringAddress + "', " +
             "'" + mailAddress + "', " +
             telephone;
   }
}
