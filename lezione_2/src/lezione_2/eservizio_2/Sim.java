package lezione_2.eservizio_2;

public class Sim {
public int numero ;
public double credito = 0;
public int chiamate = 0;


public Sim(int numero) {
	this.numero = numero;
}
public void mostraSim() {
	System.out.println("numero cellulare " + this.numero);
	System.out.println("credito residuo " + this.credito);
	System.out.println("totale chiamate effettuate " + this.chiamate);
	
}
}

