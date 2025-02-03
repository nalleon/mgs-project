package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.DirectorDTO;
import es.ies.puerto.mgs.project.dto.RoleDTO;
import es.ies.puerto.mgs.project.mapper.struct.IRoleMapper;
import es.ies.puerto.mgs.project.service.rest.impl.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
     * Setter of the service
     * @param service
     */
    @Autowired
    public void setRoleService(RoleService service) {
        this.service = service;
    }

    @Override
    @PostMapping("/")
    @Operation(summary = "Insert role")
    public ResponseEntity add(@RequestBody RoleDTO dto) {
        service.add(IRoleMapper.INSTANCE.toEntity(dto));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update role")
    @Override
    public ResponseEntity update(@PathVariable(value = "id") int id, @RequestBody RoleDTO dto) {
        try {
            service.update(id, IRoleMapper.INSTANCE.toEntity(dto));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/")
    @Operation(summary = "Get all roles")
    @Override
    public ResponseEntity<List<RoleDTO>> getAll() {
        List<RoleDTO> filteredList = service.getAll().stream()
                .map(item -> new RoleDTO(item.getId(), item.getName()))
                .collect(Collectors.toList());
        return ResponseEntity.ok(filteredList);
    }

    @Override
    @GetMapping("/{id}")
    @Operation(summary = "Get role by ID")
    public ResponseEntity<RoleDTO> getById(@PathVariable(value = "id")int id) {
        return ResponseEntity.ok(IRoleMapper.INSTANCE.toDTO(service.getById(id)));
    }

    @Override
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete role")
    public ResponseEntity delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
