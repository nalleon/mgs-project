package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.ArtistDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

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
