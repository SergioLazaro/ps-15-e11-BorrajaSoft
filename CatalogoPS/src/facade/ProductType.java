package facade;

public class ProductType {
   private String clothes;
   private String colour;
   private String image;
   private int productTypeID;
   private String size;
   private String style;

   public ProductType(int productTypeID, String clothes, String colour, String style, String image,
            String size) {
      this.productTypeID = productTypeID;
      this.clothes = clothes;
      this.colour = colour;
      this.style = style;
      this.image = image;
      this.size = size;
   }

   public String getClothes() {
      return clothes;
   }

   public String getColour() {
      return colour;
   }

   public String getImage() {
      return image;
   }

   public int getProductTypeID() {
      return productTypeID;
   }

   public String getSize() {
      return size;
   }

   public String getStyle() {
      return style;
   }

   public void setClothes(String clothes) {
      this.clothes = clothes;
   }

   public void setColour(String colour) {
      this.colour = colour;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public void setProductTypeID(int productTypeID) {
      this.productTypeID = productTypeID;
   }

   public void setSize(String size) {
      this.size = size;
   }

   public void setStyle(String style) {
      this.style = style;
   }

   @Override
   public String toString() {
      return productTypeID + "," + "'" + clothes + "', " + "'" + colour + "', " + "'" + style
               + "', " + "'" + image + "', " + "'" + size + "'";
   }
}
