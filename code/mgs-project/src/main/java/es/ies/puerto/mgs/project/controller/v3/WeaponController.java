package es.ies.puerto.mgs.project.controller.v3;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.outputs.WeaponDTO;
import es.ies.puerto.mgs.project.mapper.struct.IWeaponMapper;
import es.ies.puerto.mgs.project.service.rest.impl.WeaponService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v3/weapons")
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
     * Setter of the service
     * @param service  of the weapon
     */
    @Autowired
    public void setWeaponService(@RequestBody WeaponService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    @Operation(summary = "Insert weapon")
    public ResponseEntity <?>add(@RequestBody WeaponDTO weaponDTO) {
        service.add(IWeaponMapper.INSTANCE.toEntity(weaponDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update weapon")
    @Override
    public ResponseEntity <?>update(@PathVariable(value = "id") int id, @RequestBody WeaponDTO weaponDTO) {
        try {
            service.update(id, IWeaponMapper.INSTANCE.toEntity(weaponDTO));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    @Operation(summary = "Get all weapons")
    @Override
    public ResponseEntity<List<?>> getAll() {
        List<WeaponDTO> filteredList = service.getAll().stream()
                .map(item -> new WeaponDTO(item.getId(), item.getType(), item.getName()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredList);
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get weapon by ID")
    public ResponseEntity<WeaponDTO> getById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(IWeaponMapper.INSTANCE.toDTO(service.getById(id)));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete weapon")
    public ResponseEntity <?>delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
