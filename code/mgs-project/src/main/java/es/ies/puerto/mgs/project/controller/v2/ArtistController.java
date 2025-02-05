package es.ies.puerto.mgs.project.controller.v2;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.outputs.ArtistDTO;
import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
import es.ies.puerto.mgs.project.service.rest.impl.ArtistService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController("ArtistControllerV2")
@RequestMapping("/api/v3/artists")
@CrossOrigin
public class ArtistController {
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
     * @param service of the artist
     */
    @Autowired
    public void setArtistService(@RequestBody ArtistService service) {
        this.service = service;
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update artist")
    public ResponseEntity <?> update(@PathVariable(value = "id") int id, @RequestBody ArtistDTO artistDTO) {
        try {
            service.update(id, IArtistMapper.INSTANCE.toEntity(artistDTO));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    @Operation(summary = "Get all artist")
    public ResponseEntity<List<?>> getAll() {
        List<ArtistDTO> filteredList = service.getAll().stream()
                .map(item -> new ArtistDTO(item.getArtistId(), item.getFullName()))
                .collect(Collectors.toList());


        return ResponseEntity.ok(filteredList);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get artist by ID")
    public ResponseEntity<ArtistDTO> getById(@PathVariable(value = "id") int id) {

        return ResponseEntity.ok(IArtistMapper.INSTANCE.toDTO(service.getById(id)));
    }


}
