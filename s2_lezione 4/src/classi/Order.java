package classi;

import java.time.LocalDate;
import java.util.List;

public class Order {
private long id;
public String status;
public LocalDate orderDate;
public LocalDate deliveryDate;
public List<Product> products;
public Customer customer;

public Order( String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products,
		Customer customer) {
	super();
	
	this.status = status;
	this.orderDate = orderDate;
	this.deliveryDate = deliveryDate;
	this.products = products;
	this.customer = customer;
}

public long getId() {
	return id;
}
}
