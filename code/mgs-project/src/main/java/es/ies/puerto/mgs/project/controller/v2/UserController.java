package es.ies.puerto.mgs.project.controller.v2;

import es.ies.puerto.mgs.project.dto.outputs.UserDTO;
import es.ies.puerto.mgs.project.dto.outputs.UserOutputDTO;
import es.ies.puerto.mgs.project.dto.user.UserV3InputDTO;
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

@RestController("UserControllerV2")
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


}
