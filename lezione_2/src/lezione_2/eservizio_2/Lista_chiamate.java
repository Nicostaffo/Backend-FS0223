package lezione_2.eservizio_2;

public class Lista_chiamate {
double tempoChiamata;
Sim utente1;
int utente2;

public Lista_chiamate(int tempoChiamata,Sim utente1, int utente2) {
this.tempoChiamata = tempoChiamata;
utente1.chiamate++;
this.utente2 = utente2;
this.utente1 = utente1;
}
public void showdati() {
	System.out.println("durata call " + this.tempoChiamata);
	System.out.println("utente chiamato " + this.utente2);
}
}
