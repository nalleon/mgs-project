package es.ies.puerto.mgs.project.controller.v2;

import es.ies.puerto.mgs.project.dto.outputs.GameDTO;
import es.ies.puerto.mgs.project.mapper.struct.IGameMapper;
import es.ies.puerto.mgs.project.service.rest.impl.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController("GameControllerV2")
@RequestMapping("/api/v2/games")
@CrossOrigin
@Tag(name="v2", description = "For authenticated users")
public class GameController {
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
     * @param service of the weapon
     */
    @Autowired
    public void setGameService(GameService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all games")
    public ResponseEntity<List<GameDTO>> getAll() {
        List<GameDTO> filteredList = service.getAll().stream()
                .map(IGameMapper.INSTANCE::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredList);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get game by ID")
    public ResponseEntity<GameDTO> getById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(IGameMapper.INSTANCE.toDTO(service.getById(id)));
    }


}
