package es.ies.puerto.mgs.project.controller.v3;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.outputs.DirectorDTO;
import es.ies.puerto.mgs.project.mapper.struct.IDirectorMapper;
import es.ies.puerto.mgs.project.service.rest.impl.DirectorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v3/directors")
@CrossOrigin
public class DirectorControllerV3 implements IController<DirectorDTO> {
    /**
     * Properties
     */

    private DirectorService service;

    /**
     * Default constructor of the class
     */
    public DirectorControllerV3() {
    }

    /**
     * Setter of the service
     * @param service of the director
     */
    @Autowired
    public void setDirectorService(DirectorService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    @Operation(summary = "Insert director")
    public ResponseEntity <?>add(@RequestBody DirectorDTO directorDTO) {
        service.add(IDirectorMapper.INSTANCE.toEntity(directorDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update director")
    @Override
    public ResponseEntity <?>update(@PathVariable(value = "id") int id, @RequestBody DirectorDTO directorDTO) {
        try {
            service.update(id, IDirectorMapper.INSTANCE.toEntity(directorDTO));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    @Operation(summary = "Get all directors")
    @Override
    public ResponseEntity<List<DirectorDTO>> getAll() {
        List<DirectorDTO> filteredList = service.getAll().stream()
                .map(item -> new DirectorDTO(item.getDirectorId(), item.getFullName()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(filteredList);
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get director by ID")
    public ResponseEntity<DirectorDTO> getById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(IDirectorMapper.INSTANCE.toDTO(service.getById(id)));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete director")
    public ResponseEntity <?>delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
