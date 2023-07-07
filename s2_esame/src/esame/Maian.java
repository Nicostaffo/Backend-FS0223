package esame;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import classi.Books;
import classi.CatalogoBiblio;
import classi.Magazines;

import classi.periodicity;


public class Maian  {
	
	static Logger log = LoggerFactory.getLogger(Maian.class);
	static File file = new File("doc/test.txt");
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		Books book1 = new Books("IS123", "La bio di silvio", 2010, 200, "Luca Brancato", "Autobiografico");
        Books book2 = new Books("BN456", "In cucina con richard", 1997, 300, "Richard", "Cucina");
       
        
        Magazines magazine1 = new Magazines("IN789", "Focus senior", 2022, 50, periodicity.SEMESTRALE);
        Magazines magazine2 = new Magazines("BN101", "Motori e Papere", 2023, 40, periodicity.MENSILE);
        Magazines magazine3 = new Magazines("SB475", "Caccia e Frutta", 2022, 25, periodicity.SETTIMANALE);
        
       Set<CatalogoBiblio> setCatalogo = new HashSet<CatalogoBiblio>(); 
       
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
       try { 
    	   
		   System.out.println(leggidaFile()); 
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
       
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
       converter(setCatalogo);
       

	}
	
	public static void scriviSuFile(String testo) throws IOException {
		FileUtils.writeStringToFile(file, testo, "UTF-8"); 
	}
	public static void converter( Set<CatalogoBiblio> setCatalogo) {
		String elementSaved = "";
		for(CatalogoBiblio element : setCatalogo ) {
			elementSaved += (element.toString()+ " # ");
		}
		try {
			scriviSuFile(elementSaved);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static String leggidaFile() throws IOException {
		String textFile = FileUtils.readFileToString(file, "UTF-8");
		return textFile;
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
