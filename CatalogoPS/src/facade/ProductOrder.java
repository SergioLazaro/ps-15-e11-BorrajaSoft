package facade;

public class ProductOrder {

	private int productId;
	private int numItems;
	private String brand;
	private String name;
	private double price;

	public ProductOrder(int productId, int numItems, String brand, String name,
			double price) {
		this.productId = productId;
		this.numItems = numItems;
		this.brand = brand;
		this.name = name;
		this.price = price;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getNumItems() {
		return numItems;
	}

	public void setNumItems(int numItems) {
		this.numItems = numItems;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public String toString() {
		return productId + " - " + brand + " - " + name + " - " + price + " - " + numItems;
	}

}
