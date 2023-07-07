package esame;

import java.util.Date;
import java.util.HashSet;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import classi.Books;
import classi.CatalogoBiblio;
import classi.Magazines;

import classi.periodicity;


public class Maian  {
	
	static Logger log = LoggerFactory.getLogger(Maian.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Books book1 = new Books("IS123", "La bio di silvio", 2010, 200, "Luca Brancato", "Autobiografico");
        Books book2 = new Books("BN456", "In cucina con richard", 1997, 300, "Richard", "Cucina");
       
        
        Magazines magazine1 = new Magazines("IN789", "Focus senior", 2022, 50, periodicity.SEMESTRALE);
        Magazines magazine2 = new Magazines("BN101", "Motori e Papere", 2023, 40, periodicity.MENSILE);
        Magazines magazine3 = new Magazines("SB475", "Caccia e Frutta", 2022, 25, periodicity.SETTIMANALE);
        
       Set<CatalogoBiblio> setCatalogo = new HashSet(); 
       
       setCatalogo.add(book1);
       setCatalogo.add(book2);
       setCatalogo.add(magazine1);
       setCatalogo.add(magazine2);
       setCatalogo.add(magazine3);

       log.info("Oggetti aggiunti al Catalogo: " + setCatalogo.size());
   
       // Aggiunta di un elemento
       Books book3 = new Books("BS511", "Deforestazione nel sahara", 2007, 150, "Manuel D'arabia", "Documentario");
       setCatalogo.add(book3);
       
       printCatalogo(setCatalogo);
       
       // Rimozione di un elemento per parametro univoco
       String remove = "IN789";
       setCatalogo.removeIf(item -> item.getISBM().equals(remove));
       
       printCatalogo(setCatalogo);
       
       // Ricerca di un elemento per parametro univoco
       String searchByIsbm = "BN101";
       setCatalogo.stream()
               .filter(item -> item.getISBM().equals(searchByIsbm))
               .forEach(item -> log.info("Elemento trovato per ISBM: " + item.getTitolo()));

       // Ricerca elemento per anno di pubblicazione
       int yearToSearch = 2022;
       setCatalogo.stream()
               .filter(item -> item.getReleaseDate() == yearToSearch)
               .forEach(item -> log.info("Elemento trovato per anno di pubblicazione: " + item.getTitolo()));
       
       // Ricerca elemento per author
       String authorToSearch = "Richard";
       setCatalogo.stream()
               .filter(item -> item instanceof Books && ((Books) item).getAuthor().equals(authorToSearch))
               .forEach(item -> log.info("Elemento trovato per autore: " + item.getTitolo()));

	}

	public static void printCatalogo(Set<CatalogoBiblio> catalogo) {
        log.info("Catalogo:");
        for (CatalogoBiblio item : catalogo) {
            if (item instanceof Books) {
                Books book = (Books) item;
                log.info("Libro - ISBN: " + book.getISBM() + ", Titolo: " + book.getTitolo() + ", Autore: " + book.getAuthor());
            } else if (item instanceof Magazines) {
                Magazines magazine = (Magazines) item;
                log.info("Rivista - ISBN: " + magazine.getISBM() + ", Titolo: " + magazine.getTitolo() + ", Periodicità: " + magazine.getPeriodicity());
            }
        }
   }
}
