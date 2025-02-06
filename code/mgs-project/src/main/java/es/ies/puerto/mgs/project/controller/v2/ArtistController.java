package es.ies.puerto.mgs.project.controller.v2;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.outputs.ArtistDTO;
import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
import es.ies.puerto.mgs.project.service.rest.impl.ArtistService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController("ArtistControllerV2")
@RequestMapping("/api/v2/artists")
@CrossOrigin
@Tag(name="v2", description = "For authenticated users")
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
