package classi;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Archivio archivio = new Archivio();

        // Aggiunta di un libro
        Books libro = new Books("123456789", "Titolo libro", 2021, 200, "Autore libro", "Genere libro");
        archivio.aggiungiElementoCatalogo(libro);

        // Aggiunta di una rivista
        Magazines rivista = new Magazines("987654321", "Titolo rivista", 2022, 50, periodicity.MENSILE);
        archivio.aggiungiElementoCatalogo(rivista);

        // Ricerca per ISBN
        CatalogoBiblio elemento = archivio.ricercaPerISBN("123456789");
        if (elemento != null) {
            System.out.println("Elemento trovato: " + elemento.getTitolo());
        } else {
            System.out.println("Elemento non trovato");
        }

        // Ricerca per anno di pubblicazione
        List<CatalogoBiblio> risultatiAnno = archivio.ricercaPerAnnoPubblicazione(2021);
        System.out.println("Risultati ricerca per anno:");
        for (CatalogoBiblio risultato : risultatiAnno) {
            System.out.println(risultato.getTitolo());
        }

        // Ricerca per autore
        List<CatalogoBiblio> risultatiAutore = archivio.ricercaPerAutore("Autore libro");
        System.out.println("Risultati ricerca per autore:");
        for (CatalogoBiblio risultato : risultatiAutore) {
            System.out.println(risultato.getTitolo());
        }

        // Ricerca per titolo
        List<CatalogoBiblio> risultatiTitolo = archivio.ricercaPerTitolo("Titolo");
        System.out.println("Risultati ricerca per titolo:");
        for (CatalogoBiblio risultato : risultatiTitolo) {
            System.out.println(risultato.getTitolo());
        }
    }
}
