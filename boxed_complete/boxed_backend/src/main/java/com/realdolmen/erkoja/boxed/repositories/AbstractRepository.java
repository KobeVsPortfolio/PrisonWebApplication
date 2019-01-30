
package com.realdolmen.erkoja.boxed.repositories;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public abstract class AbstractRepository<C, T> {

    protected EntityManager em;
    private EntityTransaction transaction;
    private Class<C> entityClass;


    public AbstractRepository(EntityManager em,Class<C> entity) {
        this.em = em;
        this.entityClass = entity;
    }


    public C findById(T id) {

        return em.find(entityClass,id);
    }

    public void save(C c) {
        if (c != null) {
            begin();
            em.persist(c);
            commit();
        }
    }

    public void delete(T id) {
        begin();
        em.remove(em.find(entityClass, id));
        commit();
    }

    public List<C> findAll(){
        String clazzz = entityClass.getName();
        return em.createQuery("select c from "+clazzz+" c").getResultList();
    }

    public void update(C c) {
        if (c != null) {
            begin();
            em.merge(c);
            commit();
        }
    }

    protected void commit() {
        if (transaction != null && transaction.isActive()) {
            transaction.commit();
        }
    }

    protected void begin() {
        transaction = em.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
    }

    protected void close() {
        if (em != null) {
            em.close();
        }
    }
}

