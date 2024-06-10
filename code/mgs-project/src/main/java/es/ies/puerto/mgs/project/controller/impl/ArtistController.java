package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.ArtistDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/artist")
public class ArtistController implements IController<ArtistDTO> {
    @Override
    public ResponseEntity add(ArtistDTO artistDTO) {
        return null;
    }

    @Override
    public ResponseEntity update(ArtistDTO artistDTO) {
        return null;
    }

    @Override
    public ResponseEntity<List<ArtistDTO>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<ArtistDTO> getById(int id) {
        return null;
    }

    @Override
    public ResponseEntity delete(int id) {
        return null;
    }
}
