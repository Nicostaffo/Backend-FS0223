package esercizio_2;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Main2.costruttoSwitch();
	}
  private static void costruttoSwitch() {
	  Scanner sc = new Scanner(System.in);
	  System.out.println("inserisci il valore:");
	  int n = sc.nextInt();
	  
	  switch(n) {
	  case 0: System.out.println("Zero");
	  break;
	  case 1: System.out.println("Uno");
	  break;
	  case 2: System.out.println("Due");
	  break;
	  default:
	  System.out.println("errore");
	  
	  }
  }
}
