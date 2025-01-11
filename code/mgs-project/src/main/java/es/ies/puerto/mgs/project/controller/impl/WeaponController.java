package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.WeaponDTO;
import es.ies.puerto.mgs.project.service.rest.impl.WeaponService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
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
    private WeaponService service;

    /**
     * Default constructor of the class
     */
    public WeaponController() {
    }

    /**
     * Constructor of the class
     * @param service
     */
    public WeaponController(WeaponService service) {
        this.service = service;
    }

    /**
     * Setter of the service
     * @param service
     */
    @Autowired
    public void setWeaponService(WeaponService service) {
        this.service = service;
    }

    @Override
    @PostMapping("/")
    @Operation(summary = "Insert weapon")
    public ResponseEntity add(WeaponDTO weaponDTO) {
        service.add(weaponDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update weapon")
    @Override
    public ResponseEntity update(@PathVariable(value = "id") int id, @Valid @RequestBody WeaponDTO weaponDTO) {
        try {
            service.update(id, weaponDTO);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/")
    @Operation(summary = "Get all weapons")
    @Override
    public ResponseEntity<List<WeaponDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get weapon by ID")
    public ResponseEntity<WeaponDTO> getById(int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete weapon")
    public ResponseEntity delete(int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
