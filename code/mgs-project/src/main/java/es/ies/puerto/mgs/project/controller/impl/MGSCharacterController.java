package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
import es.ies.puerto.mgs.project.service.impl.MGSCharacterService;
import io.swagger.v3.oas.annotations.Operation;
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
    private MGSCharacterService mgsCharacterService;

    /**
     * Default constructor of the class
     */
    public MGSCharacterController() {
    }

    /**
     * Constructor of the class
     * @param mgsCharacterService
     */
    public MGSCharacterController(MGSCharacterService mgsCharacterService) {
        this.mgsCharacterService = mgsCharacterService;
    }

    /**
     * Setter of the service
     * @param mgsCharacterService
     */
    @Autowired
    public void setMgsCharacterService(MGSCharacterService mgsCharacterService) {
        this.mgsCharacterService = mgsCharacterService;
    }

    @Override
    @PostMapping("/")
    @Operation(summary = "Insert character")
    public ResponseEntity add(MGSCharacterDTO mgsCharacterDTO) {
        mgsCharacterService.addUpdate(mgsCharacterDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/")
    @Operation(summary = "Update character")
    @Override
    public ResponseEntity update(MGSCharacterDTO mgsCharacterDTO) {
        mgsCharacterService.addUpdate(mgsCharacterDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    @Operation(summary = "Get all characters")
    @Override
    public ResponseEntity<List<MGSCharacterDTO>> getAll() {
        return ResponseEntity.ok(mgsCharacterService.getAll());
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get character by ID")
    public ResponseEntity<MGSCharacterDTO> getById(int id) {
        return ResponseEntity.ok(mgsCharacterService.getById(id));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete character")
    public ResponseEntity delete(int id) {
        mgsCharacterService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
