package es.ies.puerto.mgs.project.controller.interfaces;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * @author nalleon
 */
public interface IController <T> {
    public ResponseEntity<?> add(@RequestBody T t);

    public ResponseEntity<?> update(@PathVariable int id, @RequestBody T t);

    public ResponseEntity<List<?>> getAll();

    public ResponseEntity<T> getById(int id);

    public ResponseEntity<?> delete(int id);
}