package com.sievehq.demo_project.dao;

public interface SieveGenericDAO<T>  {

    void create(final T entity);
    void update(final T entity);
    void delete(final T entity);
}
