package ug.ite2200.chatapp.repositories;

import java.util.List;
import java.util.UUID;

/**
 * @author amritaramnauth
 */
public interface Repository <T> {
    T get(UUID id);
    List<T> findAll();
    void add(T t);
    void delete(UUID id);
}
