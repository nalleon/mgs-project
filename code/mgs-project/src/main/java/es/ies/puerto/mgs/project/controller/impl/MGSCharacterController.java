package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class MGSCharacterController implements IController<MGSCharacterDTO> {
    @Override
    public ResponseEntity add(MGSCharacterDTO mgsCharacterDTO) {
        return null;
    }

    @Override
    public ResponseEntity update(MGSCharacterDTO mgsCharacterDTO) {
        return null;
    }

    @Override
    public ResponseEntity<List<MGSCharacterDTO>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<MGSCharacterDTO> getById(int id) {
        return null;
    }

    @Override
    public ResponseEntity delete(int id) {
        return null;
    }
}
