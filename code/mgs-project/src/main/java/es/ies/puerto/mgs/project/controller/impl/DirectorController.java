package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.DirectorDTO;
import es.ies.puerto.mgs.project.service.rest.impl.DirectorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/directors")
public class DirectorController implements IController<DirectorDTO> {
    /**
     * Properties
     */

    private DirectorService service;

    /**
     * Default constructor of the class
     */
    public DirectorController() {
    }

    /**
     * Constructor of the class
     * @param service
     */
    public DirectorController(DirectorService service) {
        this.service = service;
    }

    /**
     * Setter of the service
     * @param service
     */
    @Autowired
    public void setDirectorService(DirectorService service) {
        this.service = service;
    }

    @Override
    @PostMapping("/")
    @Operation(summary = "Insert director")
    public ResponseEntity add(@RequestBody DirectorDTO directorDTO) {
        service.add(directorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update director")
    @Override
    public ResponseEntity update(@PathVariable(value = "id") int id, @Valid @RequestBody DirectorDTO directorDTO) {
        try {
            service.update(id, directorDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/")
    @Operation(summary = "Get all directors")
    @Override
    public ResponseEntity<List<DirectorDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get director by ID")
    public ResponseEntity<DirectorDTO> getById(int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete director")
    public ResponseEntity delete(int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
