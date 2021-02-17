package entities;

public class OrderItem {
	
	private Product product;
	private Integer quantity;
	private Double price;
	
	
	public OrderItem() {}
	
	public OrderItem(Integer quantity, Double price, Product product) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}
	public Product getProduct() {
		return product;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Double subTotal() {
		return quantity * price;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(product.getName() + ", $");
		sb.append(String.format("%.2f", price) + ", Quantity: ");
		sb.append(quantity + ", Subtotal: $");
		sb.append(String.format("%.2f", this.subTotal()));
		
		return sb.toString();
	}
	
	
}
