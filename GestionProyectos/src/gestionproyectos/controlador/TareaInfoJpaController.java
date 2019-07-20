/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionproyectos.controlador;

import gestionproyectos.controlador.exceptions.NonexistentEntityException;
import gestionproyectos.modelo.TareaInfo;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author gianlucasorem
 */
public class TareaInfoJpaController implements Serializable {

    public TareaInfoJpaController( ) {
        this.emf = Persistence.createEntityManagerFactory("GestionProyectosPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TareaInfo tareaInfo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tareaInfo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TareaInfo tareaInfo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tareaInfo = em.merge(tareaInfo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tareaInfo.getId();
                if (findTareaInfo(id) == null) {
                    throw new NonexistentEntityException("The tareaInfo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TareaInfo tareaInfo;
            try {
                tareaInfo = em.getReference(TareaInfo.class, id);
                tareaInfo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tareaInfo with id " + id + " no longer exists.", enfe);
            }
            em.remove(tareaInfo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TareaInfo> findTareaInfoEntities() {
        return findTareaInfoEntities(true, -1, -1);
    }

    public List<TareaInfo> findTareaInfoEntities(int maxResults, int firstResult) {
        return findTareaInfoEntities(false, maxResults, firstResult);
    }

    private List<TareaInfo> findTareaInfoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TareaInfo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TareaInfo findTareaInfo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TareaInfo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTareaInfoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TareaInfo> rt = cq.from(TareaInfo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
