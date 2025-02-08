package es.ies.puerto.mgs.project.controller.v2;

import es.ies.puerto.mgs.project.dto.WeaponDTO;
import es.ies.puerto.mgs.project.mapper.struct.IWeaponMapper;
import es.ies.puerto.mgs.project.service.rest.impl.WeaponService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController("WeaponControllerV2")
@RequestMapping("/api/v2/weapons")
@CrossOrigin(origins = "http://localhost:63342")
@Tag(name="v2", description = "For authenticated users")
public class WeaponController {
    /**
     * Properties
     */
    private WeaponService service;

    /**
     * Default constructor of the class
     */
    public WeaponController() {}

    /**
     * Setter of the service
     * @param service of the weapon
     */
    @Autowired
    public void setWeaponService(@RequestBody WeaponService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "Get all weapons")
    public ResponseEntity<List<WeaponDTO>> getAll() {
        List<WeaponDTO> filteredList = service.getAll().stream()
                .map(item -> new WeaponDTO(item.getId(), item.getType(), item.getName()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(filteredList);
    }

    
    @GetMapping("/{id}")
    @Operation(summary = "Get weapon by ID")
    public ResponseEntity<WeaponDTO> getById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(IWeaponMapper.INSTANCE.toDTO(service.getById(id)));
    }
}
