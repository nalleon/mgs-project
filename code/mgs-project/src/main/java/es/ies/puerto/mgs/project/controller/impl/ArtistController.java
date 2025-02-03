package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.ArtistDTO;
import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
import es.ies.puerto.mgs.project.service.rest.impl.ArtistService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/v1/artists")
public class ArtistController implements IController<ArtistDTO> {
    /**
     * Properties
     */

    private ArtistService service;

    /**
     * Default constructor of the class
     */
    public ArtistController() {
    }

    /**
     * Setter of the service
     *
     * @param service
     */
    @Autowired
    public void setArtistService(@RequestBody ArtistService service) {
        this.service = service;
    }

    @Override
    @Operation(summary = "Insert artist")
    @PostMapping("/")
    public ResponseEntity add(@RequestBody ArtistDTO artistDTO) {
        service.add(IArtistMapper.INSTANCE.toEntity(artistDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update artist")
    @Override
    public ResponseEntity update(@PathVariable(value = "id") int id, @RequestBody ArtistDTO artistDTO) {
        try {
            service.update(id, IArtistMapper.INSTANCE.toEntity(artistDTO));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/")
    @Operation(summary = "Get all artist")
    @Override
    public ResponseEntity<List<ArtistDTO>> getAll() {
        List<ArtistDTO> filteredList = service.getAll().stream()
                .map(item -> new ArtistDTO(item.getArtistId(), item.getFullName()))
                .collect(Collectors.toList());


        return ResponseEntity.ok(filteredList);
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get artist by ID")
    public ResponseEntity<ArtistDTO> getById(@PathVariable(value = "id") int id) {

        return ResponseEntity.ok(IArtistMapper.INSTANCE.toDTO(service.getById(id)));
    }

    @Override
    @Operation(summary = "Delete artist")
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
