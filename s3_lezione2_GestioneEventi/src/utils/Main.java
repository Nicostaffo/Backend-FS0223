package utils;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Dao.EventoDAO;
import model.Evento;
import model.TipoEvento;

public class Main {
    static EntityManagerFactory  emf = Persistence.createEntityManagerFactory("s3_lezione2_GestioneEventi");
    static EntityManager em = emf.createEntityManager();
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	 
          Evento evento = new Evento("Messa", LocalDate.of(2023, 7, 15), "Rosario di 12 ore", TipoEvento.PUBBLICO, 100);
          Evento evento1 = new Evento("Helvis's back", LocalDate.of(2023, 8, 22), "Esibizione su una imbarcazione", TipoEvento.PUBBLICO, 45000);
           EventoDAO eventoDAO = new EventoDAO();
           
          // eventoDAO.save(evento);
          // System.out.println("Evento salvato: " + evento);
           
          // eventoDAO.save(evento1);
           //System.out.println("Evento salvato: " + evento1);
           
           Long eventoId = evento.getId(); 
           Evento eventoRecuperato = eventoDAO.getById(eventoId);
           System.out.println("Evento recuperato: " + eventoRecuperato);
           
           Long eventoId1 = evento1.getId(); 
           Evento evento1Recuperato = eventoDAO.getById(eventoId1);
          System.out.println("Evento recuperato: " + evento1Recuperato);
           
           eventoDAO.delete(evento);
           System.out.println("Evento eliminato");
           
           eventoDAO.delete(evento1);
           System.out.println("Evento 1 eliminato");

          
           //eventoDAO.refresh(eventoRecuperato);
           //System.out.println("Evento aggiornato");
           
           //eventoDAO.refresh(evento1Recuperato);
           //System.out.println("Evento 1 aggiornato");
           
       
          
    }

}
