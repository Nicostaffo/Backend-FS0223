package esercizi;

import java.util.Scanner;

import esercizi.enums.Dipartimento;
import esercizi.enums.Livello;

public class Dipendente {
	
	  public static int stipendioBase;
      String matricola;
	  double stipendio;
      double importoOrarioStraordinario;
      private Livello livello;
      Dipartimento dipartimento;
    
    
        public Dipendente(String matricola, Dipartimento dipartimento) {
		super();
		this.matricola = matricola;
		this.dipartimento = dipartimento;
		this.stipendio = stipendioBase;
		this.importoOrarioStraordinario = 30;
		this.livello = livello.OPERAIO;
	}


		public Dipendente(String matricola, int stipendio, double importoOrarioStraordinario, Livello livello,
				Dipartimento dipartimento) {
			super();
			this.matricola = matricola;
			this.stipendio = stipendio;
			this.importoOrarioStraordinario = importoOrarioStraordinario;
			this.livello = livello;
			this.dipartimento = dipartimento;
		}


		public double getImportoOrarioStraordinario() {
			return importoOrarioStraordinario;
		}


		public void setImportoOrarioStraordinario(double importoOrarioStraordinario) {
			this.importoOrarioStraordinario = importoOrarioStraordinario;
		}


		public Dipartimento getDipartimento() {
			return dipartimento;
		}


		public void setDipartimento(Dipartimento dipartimento) {
			this.dipartimento = dipartimento;
		}


		public static int getStipendioBase() {
			return stipendioBase;
		}


		public double getStipendio() {
			return stipendio;
		}


		public Livello getLivello() {
			return livello;
		}
		
		public void stampaDatiDipendenti() {
			System.out.println(this.matricola);
			System.out.println(this.stipendio);
			System.out.println(this.importoOrarioStraordinario);
			System.out.println(this.livello);
			System.out.println(this.dipartimento);
		} 
		private void promuovi(Dipendente Luca) {
			switch(Luca.livello) {
			case OPERAIO: Luca.livello = Livello.IMPIEGATO; 
			   Luca.stipendio = stipendio * 1.2;
			   System.out.println("Sei stato promosso a " + Luca.livello);
				break;
			case IMPIEGATO: Luca.livello = Livello.QUADRO;
			   Luca.stipendio = stipendio * 1.5;
			   System.out.println("Sei stato promosso a quadro" + Luca.livello);
			    break;
			case QUADRO: Luca.livello = Livello.DIRIGENTE;
			   Luca.stipendio = stipendio * 2;
			   System.out.println("Sei stato promosso a " + Luca.livello);
			    break;
			    default : System.out.println("licenziato");
			}
	
		}
}
