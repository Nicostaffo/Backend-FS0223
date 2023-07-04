package esercizio_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class ListaNumeri {

	public static void main(String[] args) {
		 int n = 10;
		 List<Integer> randomList = generateRandomList(n);
	        System.out.println("Lista casuale: " + randomList);
	        
	        List<Integer> combinedList = combineWithReverse(randomList);
	        System.out.println("Lista combinata con elementi in ordine inverso: " + combinedList);
	        
	        boolean printEvenPositions = true; // Stampare valori in posizioni pari
	        printListByPosition(combinedList, printEvenPositions);
	}

	private static List<Integer> combineWithReverse(List<Integer> randomList) {
		
		 List<Integer> combinedList = new ArrayList<>(randomList);
		    Collections.reverse(randomList); // Inverte l'ordine degli elementi di 'randomList'

		    combinedList.addAll(randomList); // Aggiunge gli elementi invertiti alla lista combinata

		    return combinedList;		
	}

	public static List<Integer> generateRandomList(int n) {
		
        List<Integer> randomList = new ArrayList<>();
        Random random = new Random();
        
        for (int i = 0; i < n; i++) {
            int randomNumber = random.nextInt(101); // Genera un intero casuale da 0 a 100
            randomList.add(randomNumber);
        }
        
        Collections.sort(randomList); // Ordina la lista in ordine crescente
        
        return randomList;
    }
	
	private static void printListByPosition(List<Integer> combinedList, boolean printEvenPositions) {
	    System.out.print("Valori in posizioni ");
	    
	    if (printEvenPositions) {
	        System.out.println("pari:");
	        for (int i = 0; i < combinedList.size(); i += 2) {
	            System.out.println(combinedList.get(i));
	        }
	    } else {
	        System.out.println("dispari:");
	        for (int i = 1; i < combinedList.size(); i += 2) {
	            System.out.println(combinedList.get(i));
	        }
	    }
	}

}
