package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.ArtistDTO;
import es.ies.puerto.mgs.project.service.rest.impl.ArtistService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/artists")
public class ArtistController implements IController<ArtistDTO> {
    /**
     * Properties
     */

    private ArtistService service;

    /**
     * Default constructor of the class
     */
    public ArtistController() {
    }

    /**
     * Constructor of the class
     *
     * @param service
     */
    public ArtistController(ArtistService service) {
        this.service = service;
    }

    /**
     * Setter of the service
     *
     * @param service
     */
    @Autowired
    public void setArtistService(ArtistService service) {
        this.service = service;
    }

    @Override
    @Operation(summary = "Insert artist")
    @PostMapping("/")
    public ResponseEntity add(ArtistDTO artistDTO) {
        service.add(artistDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update artist")
    @Override
    public ResponseEntity update(@PathVariable(value = "id") int id, @Valid @RequestBody ArtistDTO artistDTO) {
        try {
            service.update(id, artistDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/")
    @Operation(summary = "Get all artist")
    @Override
    public ResponseEntity<List<ArtistDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get artist by ID")
    public ResponseEntity<ArtistDTO> getById(int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Override
    @Operation(summary = "Delete artist")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
