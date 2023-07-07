package classi;

public class Customer {
	
private long id;
String name;
int tier;

public Customer( String name, int tier) {
	super();
	
	this.name = name;
	this.tier = tier;
}

public long getId() {
	return id;
}
}
