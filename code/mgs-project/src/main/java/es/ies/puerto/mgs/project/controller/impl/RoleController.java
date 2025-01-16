package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.RoleDTO;
import es.ies.puerto.mgs.project.service.rest.impl.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/roles")
public class RoleController implements IController<RoleDTO> {
    /**
     * Properties
     */

    private RoleService service;


    /**
     * Default constructor of the class
     */
    public RoleController() {
    }

    /**
     * Constructor of the class
     * @param service
     */
    public RoleController(RoleService service) {
        this.service = service;
    }

    /**
     * Setter of the service
     * @param service
     */
    @Autowired
    public void setRoleService(RoleService service) {
        this.service = service;
    }

    @Override
    @PostMapping("/{id}")
    @Operation(summary = "Insert role")
    public ResponseEntity add(RoleDTO dto) {
        service.add(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/")
    @Operation(summary = "Update role")
    @Override
    public ResponseEntity update(@PathVariable(value = "id") int id, @Valid @RequestBody RoleDTO dto) {
        try {
            service.update(id, dto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/")
    @Operation(summary = "Get all roles")
    @Override
    public ResponseEntity<List<RoleDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get role by ID")
    public ResponseEntity<RoleDTO> getById(int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete role")
    public ResponseEntity delete(int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
