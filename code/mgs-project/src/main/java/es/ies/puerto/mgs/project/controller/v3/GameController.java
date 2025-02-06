package es.ies.puerto.mgs.project.controller.v3;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.outputs.DirectorDTO;
import es.ies.puerto.mgs.project.dto.outputs.GameDTO;
import es.ies.puerto.mgs.project.dto.outputs.MGSCharacterDTO;
import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
import es.ies.puerto.mgs.project.mapper.struct.IGameMapper;
import es.ies.puerto.mgs.project.service.rest.impl.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v3/games")
@CrossOrigin
@Tag(name="v3", description = "For users with role admin")
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
     * @param service of the game
     */
    @Autowired
    public void setGameService(GameService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    @Operation(summary = "Insert game")
    public ResponseEntity <?>add(@RequestBody GameDTO gameDTO) {
        service.add(IGameMapper.INSTANCE.toEntity(gameDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update game")
    @Override
    public ResponseEntity <?>update(@PathVariable(value = "id") int id, @RequestBody GameDTO gameDTO) {
        try {
            service.update(id, IGameMapper.INSTANCE.toEntity(gameDTO));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping
    @Operation(summary = "Get all games")
    @Override
    public ResponseEntity<List<?>> getAll() {
        List<GameDTO> filteredList = service.getAll().stream()
                .map(IGameMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredList);
    }


    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get game by ID")
    public ResponseEntity<GameDTO> getById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(IGameMapper.INSTANCE.toDTO(service.getById(id)));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete game")
    public ResponseEntity <?>delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
