package es.ies.puerto.mgs.project.controller.v2;

import es.ies.puerto.mgs.project.dto.DirectorDTO;
import es.ies.puerto.mgs.project.mapper.struct.IDirectorMapper;
import es.ies.puerto.mgs.project.service.rest.impl.DirectorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController("DirectorControllerV2")
@RequestMapping("/api/v2/directors")
@CrossOrigin
@Tag(name="v2", description = "For authenticated users")
public class DirectorController {
    /**
     * Properties
     */

    private DirectorService service;

    /**
     * Default constructor of the class
     */
    public DirectorController() {
    }

    /**
     * Setter of the service
     * @param service of the director
     */
    @Autowired
    public void setDirectorService(DirectorService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all directors")
    public ResponseEntity<List<?>> getAll() {
        List<DirectorDTO> filteredList = service.getAll().stream()
                .map(item -> new DirectorDTO(item.getDirectorId(), item.getFullName()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(filteredList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get director by ID")
    public ResponseEntity<DirectorDTO> getById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(IDirectorMapper.INSTANCE.toDTO(service.getById(id)));
    }

    
}
