package es.ies.puerto.mgs.project.controller.v3;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
import es.ies.puerto.mgs.project.mapper.struct.IMGSCharacterMapper;
import es.ies.puerto.mgs.project.service.rest.impl.MGSCharacterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v3/characters")
@CrossOrigin
@Tag(name="v3", description = "For users with role admin")
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
     * Setter of the service
     * @param service of the character
     */
    @Autowired
    public void setMgsCharacterService(MGSCharacterService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    @Operation(summary = "Insert character")
    public ResponseEntity <?>add(@RequestBody MGSCharacterDTO mgsCharacterDTO) {
        service.add(IMGSCharacterMapper.INSTANCE.toEntity(mgsCharacterDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update character")
    @Override
    public ResponseEntity <?>update(@PathVariable(value = "id") int id, @RequestBody MGSCharacterDTO mgsCharacterDTO) {
        try {
            service.update(id, IMGSCharacterMapper.INSTANCE.toEntity(mgsCharacterDTO));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    @Operation(summary = "Get all characters")
    @Override
    public ResponseEntity<List<?>> getAll() {
        List<MGSCharacterDTO> filteredList = service.getAll().stream()
                .map(item -> new MGSCharacterDTO(
                        item.getId(), item.getName(), item.getCodename(),
                        item.getAge(), item.isStatus(),
                        IArtistMapper.INSTANCE.toDTO(item.getArtist()))).
                collect(Collectors.toList());

        return ResponseEntity.ok(filteredList);
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get character by ID")
    public ResponseEntity<MGSCharacterDTO> getById(@PathVariable(value = "id") int id) {

        return ResponseEntity.ok(IMGSCharacterMapper.INSTANCE.toDTO(service.getById(id)));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete character")
    public ResponseEntity <?>delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
