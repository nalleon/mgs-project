package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.GameDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class GameController implements IController<GameDTO> {
    @Override
    public ResponseEntity add(GameDTO gameDTO) {
        return null;
    }

    @Override
    public ResponseEntity update(GameDTO gameDTO) {
        return null;
    }

    @Override
    public ResponseEntity<List<GameDTO>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<GameDTO> getById(int id) {
        return null;
    }

    @Override
    public ResponseEntity delete(int id) {
        return null;
    }
}
