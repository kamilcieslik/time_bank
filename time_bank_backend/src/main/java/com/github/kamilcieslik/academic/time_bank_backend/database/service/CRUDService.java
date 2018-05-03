package com.github.kamilcieslik.academic.time_bank_backend.database.service;

import java.util.List;

public interface CRUDService<T> {
    List<T> findAll();

    T save(T entity);

    void delete(Integer id);

    void delete(T entity);

    T find(Integer id);
}
