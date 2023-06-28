package esercizio_3;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		
		
		while(true) {
		System.out.println("inserire stringa:");
		
		Scanner sc = new Scanner(System.in);
		
		String stringaInEntrata = sc.nextLine();
		
		if(stringaInEntrata.equals("q")) {
			System.out.println("hai inserito il codice riavvio");
			sc.close();
			break;
			}
		String[] arrStringhe = stringaInEntrata.split("");
		System.out.println(Arrays.toString(arrStringhe));
		}
	}
	
	


}
