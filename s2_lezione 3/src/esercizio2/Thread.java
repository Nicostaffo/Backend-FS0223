package esercizio2;

import java.util.Random;

public class Thread {

	public Thread(String string) {
		int[]arr = genArr(3000);
		sommaArr(arr);		
	
	}
	public static int[] genArr(int randomNum) {
		 int[] arr = new int[randomNum];
	        Random random = new Random();
	        
	        for (int i = 0; i < randomNum; i++) {
	            arr[i] = random.nextInt();
	        }
	        
	        return arr;
	}
	public static void sommaArr(int[] arr) {
		 int sum = 0;
		    
		    for (int i = 0; i < arr.length; i++) {
		        sum += arr[i];
		    }
		    
		    System.out.println("La somma di tutti i valori randomici generati è: " + sum);
	}
}
