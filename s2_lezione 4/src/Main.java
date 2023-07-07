import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import classi.*;


public class Main {

	
    static List<Product> listaProdotti = new ArrayList<Product>();
	static List<Order> listaOrdini = new ArrayList<Order>();
	static List<Customer> listaCustomer = new ArrayList<Customer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       listaProdotti.add(new Product("samsung","smartphone",98.10 ));
       listaProdotti.add(new Product("apple","smartphone",50.15 ));
       listaProdotti.add(new Product("huawei","smartphone",22.30 ));
       
       List<Product> s = listaProdotti.stream()
    		   .filter(prod -> prod.price > 100)
               .filter(prod -> prod.category == "smartphone")
               .collect(Collectors.toList());
       s.forEach(n -> System.out.println(n.toString()));
	}
	
}
