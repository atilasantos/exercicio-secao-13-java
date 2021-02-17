package entities;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entitie.enums.OrderStatus;

public class Order {

	public final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private Date moment;
	private OrderStatus status;
	private List<OrderItem> itemList = new ArrayList();
	private Client client;
	
	public Order() {}
	
	public Order(OrderStatus status, Client client) {
		this.moment = new Date();
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getItemList() {
		return itemList;
	}
	
	public void addItem(OrderItem item) {
		itemList.add(item);
	}
	
	public void removeItem(OrderItem item) {
		itemList.remove(item);
	}
	
	public Double total() {
		double total = 0;
		
		for (OrderItem orderItem : itemList) {
			total += orderItem.subTotal();
		}
		
		return total;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Order moment: ");
		sb.append(sdf.format(moment));
		sb.append(System.getProperty("line.separator"));
		sb.append("Order status: " + status.toString());
		sb.append(System.getProperty("line.separator"));
		sb.append(client);
		sb.append(System.getProperty("line.separator"));
		sb.append("Order items: \n");
		for (OrderItem orderItem : itemList) {
			sb.append(orderItem);
			sb.append(System.getProperty("line.separator"));
		}
		sb.append("Total price: $" + String.format("%.2f", this.total()));
		
		return sb.toString();
	}

	
}
