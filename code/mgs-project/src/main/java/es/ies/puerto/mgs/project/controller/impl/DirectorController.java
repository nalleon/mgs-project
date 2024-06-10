package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.DirectorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/director")
public class DirectorController implements IController<DirectorDTO> {
    @Override
    public ResponseEntity add(DirectorDTO directorDTO) {
        return null;
    }

    @Override
    public ResponseEntity update(DirectorDTO directorDTO) {
        return null;
    }

    @Override
    public ResponseEntity<List<DirectorDTO>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<DirectorDTO> getById(int id) {
        return null;
    }

    @Override
    public ResponseEntity delete(int id) {
        return null;
    }
}
