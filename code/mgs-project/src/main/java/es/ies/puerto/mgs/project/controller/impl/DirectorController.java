package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.DirectorDTO;
import es.ies.puerto.mgs.project.service.impl.DirectorService;
import io.swagger.v3.oas.annotations.Operation;
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

    private DirectorService directorService;

    /**
     * Default constructor of the class
     */
    public DirectorController() {
    }

    /**
     * Constructor of the class
     * @param directorService
     */
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    /**
     * Setter of the service
     * @param directorService
     */
    @Autowired
    public void setDirectorService(DirectorService directorService) {
        this.directorService = directorService;
    }

    @Override
    @PostMapping("/")
    @Operation(summary = "Insert director")
    public ResponseEntity add(DirectorDTO directorDTO) {
        directorService.addUpdate(directorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/")
    @Operation(summary = "Update director")
    @Override
    public ResponseEntity update(DirectorDTO directorDTO) {
        directorService.addUpdate(directorDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    @Operation(summary = "Get all directors")
    @Override
    public ResponseEntity<List<DirectorDTO>> getAll() {
        return ResponseEntity.ok(directorService.getAll());
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get director by ID")
    public ResponseEntity<DirectorDTO> getById(int id) {
        return ResponseEntity.ok(directorService.getById(id));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete director")
    public ResponseEntity delete(int id) {
        directorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
