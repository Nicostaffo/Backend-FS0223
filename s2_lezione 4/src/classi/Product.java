package classi;

public class Product {
private long id;
public String name;
public String category;
public double price;

public Product( String name, String category, double price) {
	super();
	this.name = name;
	this.category = category;
	this.price = price;
}

public long getId() {
	return id;
}


}
