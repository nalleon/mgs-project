package es.ies.puerto.mgs.project.controller.v3;
import es.ies.puerto.mgs.project.dto.user.UserV3InputDTO;
import es.ies.puerto.mgs.project.dto.outputs.UserDTO;
import es.ies.puerto.mgs.project.dto.outputs.UserOutputDTO;
import es.ies.puerto.mgs.project.mapper.struct.IUserMapper;
import es.ies.puerto.mgs.project.model.entities.User;
import es.ies.puerto.mgs.project.service.rest.impl.RoleService;
import es.ies.puerto.mgs.project.service.rest.impl.UserService;
import es.ies.puerto.mgs.project.utils.CustomApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v3/users")
@CrossOrigin
public class UserController {

    /**
     * Properties
     */
    private UserService service;
    private RoleService roleService;
    /**
     * Default constructor of the class
     */
    public UserController() {
    }


    /**
     * Setter of the service
     * @param service  of the user
     */
    @Autowired
    public void setUserService(UserService service) {
        this.service = service;
    }
    /**
     * Setter of the service
     * @param roleService  of the role
     */
    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    @Operation(summary = "Insert user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request")
    })
    public ResponseEntity <?>add(@RequestBody UserV3InputDTO dto) {
        if(dto == null){
            return ResponseEntity.badRequest()
                    .body(new CustomApiResponse<>(400, "User can not be null", null));
        }

        User dbItemByName = service.getByName(dto.name());

        if (dbItemByName != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new CustomApiResponse<>(409, "Name already in use", null));
        }

        User dbItemByEmail = service.getByEmail(dto.email());

        if (dbItemByEmail != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(new CustomApiResponse<>(409, "Email already in use", null));
        }


        User aux = new User();
        aux.setName(dto.name());
        aux.setEmail(dto.email());
        aux.setPassword(dto.password());
        aux.setRole(roleService.getById(dto.role()));

        service.add(aux);

        UserDTO result = IUserMapper.INSTANCE.toDTO(service.getByName(dto.name()));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CustomApiResponse<>(201, "Successfully created", result));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User updated successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity <?> update(@PathVariable(value = "id") int id, @RequestBody UserDTO dto) {
        try {
            service.update(id, IUserMapper.INSTANCE.toEntity(dto));
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    @Operation(summary = "Get all users")
    public ResponseEntity<List<UserOutputDTO>> getAll() {
        List<UserOutputDTO> filteredList = service.getAll().stream()
                .map(item -> new UserOutputDTO(item.getName(), item.getEmail(), item.getRole().getId()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(filteredList);
    }

    @Operation(summary = "Get user by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable(value = "id") int id) {
        return ResponseEntity.ok(IUserMapper.INSTANCE.toDTO(service.getById(id)));
    }

    @Operation(summary = "Delete user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted successfully"),
            @ApiResponse(responseCode = "404", description = "User not found")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity <?>delete(@PathVariable(value = "id") int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
