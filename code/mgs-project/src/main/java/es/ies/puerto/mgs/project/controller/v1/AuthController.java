package es.ies.puerto.mgs.project.controller.v1;

import es.ies.puerto.mgs.project.dto.user.UserLoginDTO;
import es.ies.puerto.mgs.project.dto.user.UserRegisterDTO;
import es.ies.puerto.mgs.project.dto.outputs.UserOutputDTO;
import es.ies.puerto.mgs.project.model.entities.User;
import es.ies.puerto.mgs.project.security.jwt.AuthService;
import es.ies.puerto.mgs.project.security.jwt.JwtService;
import es.ies.puerto.mgs.project.service.rest.impl.UserService;
import es.ies.puerto.mgs.project.utils.CustomApiResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author nalleon
 */
@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin
public class AuthController {

    /**
     * Properties
     */
    @Autowired
    private UserService service;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthService authService;


    @PostMapping("/login")
    public String login(@RequestBody UserLoginDTO loginDTO ) {
        String token = authService.authenticate(loginDTO.username(), loginDTO.password());

        if (token == null) {
            throw new RuntimeException("Credenciales inválidas");
        }

        return token;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterDTO registerDTO ) {
        User register = authService.register(registerDTO.username(), registerDTO.password(), registerDTO.email());


        if (register != null) {

            UserOutputDTO dto = new UserOutputDTO(register.getName(), register.getEmail(), register.getRole().getId());
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new CustomApiResponse<>(201, "User succesfully created", dto));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body(new CustomApiResponse<>(400, "Error while creating the new user", null));
    }
}
