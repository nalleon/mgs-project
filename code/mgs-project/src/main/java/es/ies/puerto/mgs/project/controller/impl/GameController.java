package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.GameDTO;
import es.ies.puerto.mgs.project.service.impl.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/game")
public class GameController implements IController<GameDTO> {
    /**
     * Properties
     */

    private GameService gameService;

    /**
     * Default constructor of the class
     */
    public GameController() {
    }

    /**
     * Constructor of the class
     * @param gameService
     */
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    /**
     * Setter of the service
     * @param gameService
     */
    @Autowired
    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    @Override
    @PostMapping("/")
    public ResponseEntity add(GameDTO gameDTO) {
        gameService.add(gameDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/")
    @Override
    public ResponseEntity update(GameDTO gameDTO) {
        gameService.update(gameDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<List<GameDTO>> getAll() {
        return ResponseEntity.ok(gameService.getAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<GameDTO> getById(int id) {
        return ResponseEntity.ok(gameService.getById(id));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(int id) {
        gameService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
