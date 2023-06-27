package lezione_2.eservizio_2;

public class Main_2 {

	public static void main(String[] args) {
		Sim tipo1 = new Sim(34584466);
		Sim tipo2 = new Sim(45845554);
		tipo1.mostraSim();
		tipo2.mostraSim();
		Lista_chiamate c1 = new Lista_chiamate(5,tipo1,tipo2.numero);
		c1.showdati();
	}

}
