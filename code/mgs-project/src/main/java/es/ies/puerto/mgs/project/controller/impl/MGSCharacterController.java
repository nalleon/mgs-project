package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
import es.ies.puerto.mgs.project.service.impl.MGSCharacterService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/characters")
public class MGSCharacterController implements IController<MGSCharacterDTO> {
    /**
     * Properties
     */
    private MGSCharacterService service;

    /**
     * Default constructor of the class
     */
    public MGSCharacterController() {
    }

    /**
     * Constructor of the class
     * @param service
     */
    public MGSCharacterController(MGSCharacterService service) {
        this.service = service;
    }

    /**
     * Setter of the service
     * @param service
     */
    @Autowired
    public void setMgsCharacterService(MGSCharacterService service) {
        this.service = service;
    }

    @Override
    @PostMapping("/")
    @Operation(summary = "Insert character")
    public ResponseEntity add(MGSCharacterDTO mgsCharacterDTO) {
        service.add(mgsCharacterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update character")
    @Override
    public ResponseEntity update(@PathVariable(value = "id") int id, @Valid @RequestBody MGSCharacterDTO mgsCharacterDTO) {
        try {
            service.update(id, mgsCharacterDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/")
    @Operation(summary = "Get all characters")
    @Override
    public ResponseEntity<List<MGSCharacterDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get character by ID")
    public ResponseEntity<MGSCharacterDTO> getById(int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete character")
    public ResponseEntity delete(int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
