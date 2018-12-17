package com.fryzjerappbackend.DAO;

import java.util.Collection;
import java.util.Optional;

public interface Dao<T> {

    Optional<T> get(int id);

    Collection<T> getAll();

    void update(T t);

    void delete(T t);
}