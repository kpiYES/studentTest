package com.app.dao;

import java.util.Set;

public interface AbstractDAO<T> {
    Long insert(T entity);

    void update(T t);

    void delete(T t);

    T findById(Long id);

    Set<T> findAll();
}
