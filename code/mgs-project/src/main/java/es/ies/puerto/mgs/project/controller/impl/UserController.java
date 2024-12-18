package es.ies.puerto.mgs.project.controller.impl;

import es.ies.puerto.mgs.project.controller.interfaces.IController;
import es.ies.puerto.mgs.project.dto.UserDTO;
import es.ies.puerto.mgs.project.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/v1/users")
public class UserController implements IController<UserDTO> {
    /**
     * Properties
     */

    private UserService service;

    /**
     * Default constructor of the class
     */
    public UserController() {
    }

    /**
     * Constructor of the class
     * @param service
     */
    public UserController(UserService service) {
        this.service = service;
    }

    /**
     * Setter of the service
     * @param service
     */
    @Autowired
    public void setUserService(UserService service) {
        this.service = service;
    }

    @Override
    @PostMapping("/")
    public ResponseEntity add(UserDTO dto) {
        service.addUpdate(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/")
    @Override
    public ResponseEntity update(UserDTO dto) {
        service.addUpdate(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(int id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity delete(int id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
