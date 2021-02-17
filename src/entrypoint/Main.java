package entrypoint;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entitie.enums.OrderStatus;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;

public class Main {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter the client data:");
		System.out.print("Name: ");
		String name = sc.nextLine();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String dateString = sc.next();
		Date date = sdf.parse(dateString);
		
		
		System.out.println("Enter order data: ");
		System.out.print("Status: ");
		String temporaryStatus = sc.next();
		OrderStatus status = OrderStatus.PROCESSING;
		status = OrderStatus.valueOf(temporaryStatus);
		
		Order order = new Order(status, new Client(name, email, date));
		
		System.out.print("How many items to this order? ");
		Integer itemsQuantity = sc.nextInt();
		
		for(int i = 1; i <= itemsQuantity; i++) {
			
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			String productName = sc.next();
			System.out.print("Product price: ");
			Double productPrice = sc.nextDouble();
			System.out.print("Quantity: ");
			Integer productQuantity = sc.nextInt();
			
			OrderItem orderItem = new OrderItem(productQuantity, productPrice, new Product(productName));
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
	}

}
