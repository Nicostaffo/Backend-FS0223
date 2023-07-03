package esercizio_3;

public class ContoCorrente {
	String titolare;
	int nMovimenti;
	final int maxMovimenti = 50;
	double saldo;

	ContoCorrente(String titolare, double saldo) {
		this.titolare = titolare;
		this.saldo = saldo;
		nMovimenti = 0;
		}
	public void preleva(double x) throws BankException {
	    if (nMovimenti < maxMovimenti) {
	        double nuovoSaldo = saldo - x;
	        if (nuovoSaldo < 0) {
	            throw new BankException("Il conto è in rosso");
	        }
	        saldo = nuovoSaldo;
	    } else {
	        double nuovoSaldo = saldo - x - 0.50;
	        if (nuovoSaldo < 0) {
	            throw new BankException("Il conto è in rosso");
	        }
	        saldo = nuovoSaldo;
	    }
	    nMovimenti++;
	}

	double restituisciSaldo() {
		return saldo;
	}
}
