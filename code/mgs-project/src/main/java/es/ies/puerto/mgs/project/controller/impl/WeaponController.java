package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.WeaponDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/weapon")
public class WeaponController implements IController<WeaponDTO> {
    @Override
    public ResponseEntity add(WeaponDTO weaponDTO) {
        return null;
    }

    @Override
    public ResponseEntity update(WeaponDTO weaponDTO) {
        return null;
    }

    @Override
    public ResponseEntity<List<WeaponDTO>> getAll() {
        return null;
    }

    @Override
    public ResponseEntity<WeaponDTO> getById(int id) {
        return null;
    }

    @Override
    public ResponseEntity delete(int id) {
        return null;
    }
}
