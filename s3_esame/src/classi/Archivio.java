package classi;

import javax.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Archivio {
    private EntityManagerFactory entityManagerFactory;

    public Archivio() {
        entityManagerFactory = Persistence.createEntityManagerFactory("NomeUnitaPersistenza");
    }

    public void aggiungiElementoCatalogo(CatalogoBiblio elemento) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(elemento);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public void rimuoviElementoCatalogo(String codiceISBN) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            CatalogoBiblio elemento = entityManager.find(CatalogoBiblio.class, codiceISBN);
            if (elemento != null) {
                entityManager.remove(elemento);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public CatalogoBiblio ricercaPerISBN(String codiceISBN) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        CatalogoBiblio elemento = entityManager.find(CatalogoBiblio.class, codiceISBN);
        entityManager.close();
        return elemento;
    }

    public List<CatalogoBiblio> ricercaPerAnnoPubblicazione(int anno) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<CatalogoBiblio> query = entityManager.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.annoPubblicazione = :anno", CatalogoBiblio.class);
        query.setParameter("anno", anno);
        List<CatalogoBiblio> risultati = query.getResultList();
        entityManager.close();
        return risultati;
    }

    public List<CatalogoBiblio> ricercaPerAutore(String autore) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Books> query = entityManager.createQuery("SELECT l FROM Libro l WHERE l.autore = :autore", Books.class);
        query.setParameter("autore", autore);
        List<CatalogoBiblio> risultati = new ArrayList<>(query.getResultList());
        entityManager.close();
        return risultati;
    }

    public List<CatalogoBiblio> ricercaPerTitolo(String titolo) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<CatalogoBiblio> query = entityManager.createQuery("SELECT e FROM ElementoCatalogo e WHERE LOWER(e.titolo) LIKE :titolo", CatalogoBiblio.class);
        query.setParameter("titolo", "%" + titolo.toLowerCase() + "%");
        List<CatalogoBiblio> risultati = query.getResultList();
        entityManager.close();
        return risultati;
    }

    public List<Prestiti> ricercaPrestitiInCorso(int numeroTessera) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Prestiti> query = entityManager.createQuery("SELECT p FROM Prestito p WHERE p.utente.numeroTessera = :numeroTessera AND p.dataRestituzioneEffettiva IS NULL", Prestiti.class);
        query.setParameter("numeroTessera", numeroTessera);
        List<Prestiti> risultati = query.getResultList();
        entityManager.close();
        return risultati;
    }

    public List<Prestiti> ricercaPrestitiScadutiNonRestituiti() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        TypedQuery<Prestiti> query = entityManager.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzionePrevista < CURRENT_DATE AND p.dataRestituzioneEffettiva IS NULL", Prestiti.class);
        List<Prestiti> risultati = query.getResultList();
        entityManager.close();
        return risultati;
    }

    public void effettuaPrestito(Utente utente, CatalogoBiblio elemento, LocalDate dataInizioPrestito) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Prestiti prestito = new Prestiti(utente, elemento, dataInizioPrestito, dataInizioPrestito, dataInizioPrestito);
            entityManager.persist(prestito);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }

    public void restituisciElemento(CatalogoBiblio elemento, LocalDate dataRestituzioneEffettiva) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            TypedQuery<Prestiti> query = entityManager.createQuery("SELECT p FROM Prestito p WHERE p.elementoPrestato = :elemento AND p.dataRestituzioneEffettiva IS NULL", Prestiti.class);
            query.setParameter("elemento", elemento);
            List<Prestiti> prestiti = query.getResultList();
            if (!prestiti.isEmpty()) {
                Prestiti prestito = prestiti.get(0);
                prestito.setDataRestituzioneEffettiva(dataRestituzioneEffettiva);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            entityManager.close();
        }
    }
}