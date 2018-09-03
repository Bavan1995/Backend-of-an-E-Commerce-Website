package com.sievehq.demo_project.daoImpl;

import com.sievehq.demo_project.dao.SieveGenericDAO;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class SieveGenericDAOImpl<T> implements SieveGenericDAO<T> {
    private Class<T> clazz;

    @PersistenceContext
    private EntityManager entityManager;
    private Session session;


    public Session getSession() {
        this.session = entityManager.unwrap(Session.class);
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Class<T> getClazz() {
        return clazz;
    }

    public void setClazz(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void create(T entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(T entity) {
        entityManager.merge(entity);
    }

    @Override
    public void delete(T entity) {
        entityManager.remove(entity);
    }
}