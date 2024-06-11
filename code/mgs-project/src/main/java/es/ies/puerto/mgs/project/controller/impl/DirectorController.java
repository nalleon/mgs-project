package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.DirectorDTO;
import es.ies.puerto.mgs.project.service.impl.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/director")
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
    public ResponseEntity add(DirectorDTO directorDTO) {
        directorService.addUpdate(directorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/")
    @Override
    public ResponseEntity update(DirectorDTO directorDTO) {
        directorService.addUpdate(directorDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<List<DirectorDTO>> getAll() {
        return ResponseEntity.ok(directorService.getAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<DirectorDTO> getById(int id) {
        return ResponseEntity.ok(directorService.getById(id));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(int id) {
        directorService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
