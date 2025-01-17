package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.GameDTO;
import es.ies.puerto.mgs.project.service.rest.impl.GameService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/games")
public class GameController implements IController<GameDTO> {
    /**
     * Properties
     */

    private GameService service;

    /**
     * Default constructor of the class
     */
    public GameController() {
    }


    /**
     * Setter of the service
     * @param service
     */
    @Autowired
    public void setGameService(GameService service) {
        this.service = service;
    }

    @Override
    @PostMapping("/")
    @Operation(summary = "Insert game")
    public ResponseEntity add(@RequestBody GameDTO gameDTO) {
        service.add(gameDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update game")
    @Override
    public ResponseEntity update(@PathVariable(value = "id") int id, @RequestBody GameDTO gameDTO) {
        try {
            service.update(id, gameDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/")
    @Operation(summary = "Get all games")
    @Override
    public ResponseEntity<List<GameDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get game by ID")
    public ResponseEntity<GameDTO> getById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete game")
    public ResponseEntity delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
