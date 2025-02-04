package es.ies.puerto.mgs.project.controller.v2;

import es.ies.puerto.mgs.project.dto.outputs.DirectorDTO;
import es.ies.puerto.mgs.project.dto.outputs.GameDTO;
import es.ies.puerto.mgs.project.dto.outputs.MGSCharacterDTO;
import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
import es.ies.puerto.mgs.project.mapper.struct.IGameMapper;
import es.ies.puerto.mgs.project.service.rest.impl.GameService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v2/games")
@CrossOrigin
public class GameControllerV2 {
    /**
     * Properties
     */

    private GameService service;

    /**
     * Default constructor of the class
     */
    public GameControllerV2() {
    }


    /**
     * Setter of the service
     * @param service
     */
    @Autowired
    public void setGameService(GameService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all games")
    public ResponseEntity<List<GameDTO>> getAll() {
        List<GameDTO> filteredList = service.getAll().stream()
                .map(item -> new GameDTO(
                        item.getId(),
                        item.getName(),
                        item.getGameCharacters().stream()
                                .map(ch -> new MGSCharacterDTO(
                                        ch.getId(),
                                        ch.getName(),
                                        ch.getCodename(),
                                        ch.getAge(),
                                        ch.isStatus(),
                                        IArtistMapper.INSTANCE.toDTO(ch.getArtist())
                                ))
                                .collect(Collectors.toSet()),
                        new DirectorDTO(item.getDirector().getDirectorId(), item.getDirector().getFullName())
                ))
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredList);
    }


    @GetMapping("/{id}")
    @Operation(summary = "Get game by ID")
    public ResponseEntity<GameDTO> getById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(IGameMapper.INSTANCE.toDTO(service.getById(id)));
    }


}
