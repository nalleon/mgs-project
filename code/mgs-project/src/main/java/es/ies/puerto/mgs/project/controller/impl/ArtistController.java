package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.ArtistDTO;
import es.ies.puerto.mgs.project.service.impl.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/artist")
public class ArtistController implements IController<ArtistDTO> {
    /**
     * Properties
     */

    private ArtistService artistService;

    /**
     * Default constructor of the class
     */
    public ArtistController() {
    }

    /**
     * Constructor of the class
     *
     * @param artistService
     */
    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    /**
     * Setter of the service
     *
     * @param artistService
     */
    @Autowired
    public void setArtistService(ArtistService artistService) {
        this.artistService = artistService;
    }

    @Override
    @PostMapping("/")
    public ResponseEntity add(ArtistDTO artistDTO) {
        artistService.addUpdate(artistDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/")
    @Override
    public ResponseEntity update(ArtistDTO artistDTO) {
        artistService.addUpdate(artistDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<List<ArtistDTO>> getAll() {
        return ResponseEntity.ok(artistService.getAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<ArtistDTO> getById(int id) {
        return ResponseEntity.ok(artistService.getById(id));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(int id) {
        artistService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
