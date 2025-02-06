package es.ies.puerto.mgs.project.controller.v2;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.outputs.MGSCharacterDTO;
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

@RestController("MGSCharacterControllerV2")
@RequestMapping("/api/v2/characters")
@CrossOrigin
@Tag(name="v2", description = "For authenticated users")
public class MGSCharacterController {
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

    @GetMapping
    @Operation(summary = "Get all characters")
    public ResponseEntity<List<?>> getAll() {
        List<MGSCharacterDTO> filteredList = service.getAll().stream()
                .map(item -> new MGSCharacterDTO(
                        item.getId(), item.getName(), item.getCodename(),
                        item.getAge(), item.isStatus(),
                        IArtistMapper.INSTANCE.toDTO(item.getArtist()))).
                collect(Collectors.toList());

        return ResponseEntity.ok(filteredList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get character by ID")
    public ResponseEntity<MGSCharacterDTO> getById(@PathVariable(value = "id") int id) {

        return ResponseEntity.ok(IMGSCharacterMapper.INSTANCE.toDTO(service.getById(id)));
    }

}
