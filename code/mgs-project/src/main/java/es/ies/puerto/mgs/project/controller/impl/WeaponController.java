package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.WeaponDTO;
import es.ies.puerto.mgs.project.service.impl.WeaponService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/v1/weapons")
@CrossOrigin(origins = "http://localhost:63342")
public class WeaponController implements IController<WeaponDTO> {
    /**
     * Properties
     */
    private WeaponService weaponService;

    /**
     * Default constructor of the class
     */
    public WeaponController() {
    }

    /**
     * Constructor of the class
     * @param weaponService
     */
    public WeaponController(WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    /**
     * Setter of the service
     * @param weaponService
     */
    @Autowired
    public void setWeaponService(WeaponService weaponService) {
        this.weaponService = weaponService;
    }

    @Override
    @PostMapping("/")
    @Operation(summary = "Insert weapon")
    public ResponseEntity add(WeaponDTO weaponDTO) {
        weaponService.add(weaponDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/")
    @Operation(summary = "Update weapon")
    @Override
    public ResponseEntity update(WeaponDTO weaponDTO) {
        weaponService.update(weaponDTO);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    @Operation(summary = "Get all weapons")
    @Override
    public ResponseEntity<List<WeaponDTO>> getAll() {
        return ResponseEntity.ok(weaponService.getAll());
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get weapon by ID")
    public ResponseEntity<WeaponDTO> getById(int id) {
        return ResponseEntity.ok(weaponService.getById(id));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete weapon")
    public ResponseEntity delete(int id) {
        weaponService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
