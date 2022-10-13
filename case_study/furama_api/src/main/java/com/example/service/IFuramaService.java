package com.example.service;

import java.util.List;

public interface IFuramaService<T> {
    List<T> findAll();

    T findById(int id);

    T insert(T element);

    T update(T element);

    boolean delete(int id);
}
