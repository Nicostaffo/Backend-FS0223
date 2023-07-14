package Dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import utils.JpaUtil;
import model.Evento;

public class EventoDAO {
   private EntityManagerFactory entityManagerFactory = JpaUtil.getEntityManagerFactory();

   public void save(Evento evento) {
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      try {
         entityManager.getTransaction().begin();
         entityManager.persist(evento);
         entityManager.getTransaction().commit();
      } catch (Exception e) {
         entityManager.getTransaction().rollback();
      } finally {
         entityManager.close();
      }
   }

   public Evento getById(Long id) {
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      Evento evento = entityManager.find(Evento.class, id);
      entityManager.close();
      return evento;
   }

   public void delete(Evento evento) {
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      try {
         entityManager.getTransaction().begin();
         entityManager.remove(evento);
         entityManager.getTransaction().commit();
      } catch (Exception e) {
         entityManager.getTransaction().rollback();
      } finally {
         entityManager.close();
      }
   }

   public void refresh(Evento evento) {
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      entityManager.refresh(evento);
      entityManager.close();
   }
}
