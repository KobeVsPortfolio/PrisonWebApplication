
package com.realdolmen.erkoja.boxed.repositories;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PreDestroy;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

public abstract class AbstractRepository<C, T>{

    
    protected abstract EntityManager em();

    private Class<C> entityClass;

    public AbstractRepository(Class<C> entityClass) {
        this.entityClass = entityClass;
    }
    
    public C findById(T id) {
        return em().find(entityClass,id);
    }
    
    @Transactional
    public void save(C c) {
        if (c != null) {
            try {
                em().persist(c);
            } catch (Exception ex) {
                Logger.getLogger(AbstractRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Transactional
    public void delete(T id) {
        em().remove(em().find(entityClass, id));
    }
    
    public List<C> findAll(){
        String clazzz = entityClass.getName();
        return em().createQuery("select c from "+clazzz+" c").getResultList();
    }
    
    @Transactional
    public void update(C c) {
        if (c != null) {
            try {
                em().merge(c);
            } catch (Exception ex) {
                Logger.getLogger(AbstractRepository.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    protected void commit() {
       em().getTransaction().commit();
    }

    protected void begin() {
        em().getTransaction().begin();
        }
    
    @PreDestroy
    public void close() {
        if (em() != null) {
            em().close();
        }   
    }
}

