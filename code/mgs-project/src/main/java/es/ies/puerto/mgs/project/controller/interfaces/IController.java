package es.ies.puerto.mgs.project.controller.interfaces;

import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author nalleon
 */
public interface IController <T> {
    public ResponseEntity add(T t);

    public ResponseEntity update(T t);

    public ResponseEntity<List<T>> getAll();

    public ResponseEntity<T> getById(int id);

    public ResponseEntity delete(int id);
}