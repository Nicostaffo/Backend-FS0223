package esercizi_g1;

import java.util.Random;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	
 static Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
	    
		int[] array = new int[5];
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        // Inizializza l'array con valori casuali
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(10) + 1; // Genera un numero casuale tra 1 e 10
        }
        
        log.info("Array iniziale:");
        printArray(array);

        int position;
        int value;
        do {
            try {
                log.info("Inserisci un numero (0 per terminare): ");
                value = scanner.nextInt();

                if (value == 0) {
                    break; // Termina il programma se l'utente inserisce 0
                }

                log.info("Inserisci la posizione (0-4): ");
                position = scanner.nextInt();

                if (position < 0 || position >= array.length) {
                    throw new IndexOutOfBoundsException("Posizione non valida!");
                }

                array[position] = value;

                // Stampa il nuovo stato dell'array
                log.info("Nuovo stato dell'array:");
                printArray(array);
            } catch (IndexOutOfBoundsException e) {
                log.error("Errore: {}", e.getMessage());
            }
        } while (true);
 }
	private static void printArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]).append(" ");
        }
        log.info(sb.toString());
    }
}
