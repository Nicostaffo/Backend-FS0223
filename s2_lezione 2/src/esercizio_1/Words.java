package esercizio_1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Words {

	 static Logger log = LoggerFactory.getLogger(Words.class);
	 static Scanner scanner = new Scanner(System.in);
	 
	public static void main(String[] args) {
		

	        log.info("Inserisci il numero di parole che scriverai: ");
	        int n = scanner.nextInt();

	        Set<String> parole = new HashSet<>();
	        Set<String> paroleDuplicate = new HashSet<>();

	        log.info("Inserisci le parole una per volta:");
	        
	        for (int i = 0; i < n; i++) {
	            String singolaParola = scanner.next();

	            if (!parole.add(singolaParola)) {
	                paroleDuplicate.add(singolaParola);
	            }
	        }

	        log.info("Parole duplicate:");
	        for (String singolaParola : paroleDuplicate) {
	            log.info(singolaParola);
	        }

	        log.info("Numero di parole distinte: " + parole.size());

	        log.info("Elenco delle parole distinte:");
	        for (String singolaParola : parole) {
	            log.info(singolaParola);
	        }

	}

}
