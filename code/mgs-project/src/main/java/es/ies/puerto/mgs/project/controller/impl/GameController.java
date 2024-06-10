package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.GameDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/game")
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
