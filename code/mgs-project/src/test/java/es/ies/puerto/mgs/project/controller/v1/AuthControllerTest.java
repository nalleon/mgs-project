package es.ies.puerto.mgs.project.controller.v1;

import es.ies.puerto.mgs.project.controller.v3.UserController;
import es.ies.puerto.mgs.project.dto.user.UserLoginDTO;
import es.ies.puerto.mgs.project.dto.user.UserRegisterDTO;
import es.ies.puerto.mgs.project.dto.user.UserV3InputDTO;
import es.ies.puerto.mgs.project.model.entities.Role;
import es.ies.puerto.mgs.project.model.entities.User;
import es.ies.puerto.mgs.project.security.jwt.AuthService;
import es.ies.puerto.mgs.project.security.jwt.JwtService;
import es.ies.puerto.mgs.project.service.rest.impl.RoleService;
import es.ies.puerto.mgs.project.service.rest.impl.UserService;
import es.ies.puerto.mgs.project.utilities.TestUtilities;
import es.ies.puerto.mgs.project.utils.CustomApiResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class AuthControllerTest extends TestUtilities {
    @Mock
    UserService serviceMock;
    @Mock
    JwtService jwtServiceMock;

    @Mock
    AuthService authServiceMock;

    @InjectMocks
    AuthController controller;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        controller = new AuthController();
        controller.setService(serviceMock);
        controller.setJwtService(jwtServiceMock);
        controller.setAuthService(authServiceMock);
    }
    @Test
    void testLoginSuccess() {
        String username = "testUser";
        String password = "testPass";
        UserLoginDTO loginDTO = new UserLoginDTO(username, password);
        String token = "valid.jwt.token";

        when(authServiceMock.authenticate(username, password)).thenReturn(token);

        String result = controller.login(loginDTO);

        Assertions.assertEquals(token, result, "The token should match the mocked value.");
    }

    @Test
    void testLoginFailure() {
        String username = "testUser";
        String password = "wrongPass";
        UserLoginDTO loginDTO = new UserLoginDTO(username, password);

        when(authServiceMock.authenticate(username, password)).thenReturn(null);

        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            controller.login(loginDTO);
        });

        Assertions.assertEquals("Credenciales inválidas", exception.getMessage(), "The exception message should match.");
    }

    @Test
    void testRegisterSuccess() {
        String username = "newUser";
        String password = "newPass";
        String email = "newuser@example.com";
        UserRegisterDTO registerDTO = new UserRegisterDTO(username, password, email);
        User newUser = new User();
        newUser.setName(username);
        newUser.setPassword(password);
        newUser.setEmail(email);
        newUser.setRole(new Role(1, "ROLE_USER"));
        newUser.setId(3);

        when(authServiceMock.register(username, password, email)).thenReturn(newUser);

        ResponseEntity<?> response = controller.register(registerDTO);

        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode(), "Status code should be CREATED.");
        Assertions.assertTrue(response.getBody() instanceof CustomApiResponse, "Response body should be CustomApiResponse.");
    }

    @Test
    void testRegisterFailure() {
        String username = "existingUser";
        String password = "existingPass";
        String email = "existing@example.com";
        UserRegisterDTO registerDTO = new UserRegisterDTO(username, password, email);

        when(authServiceMock.register(username, password, email)).thenReturn(null);

        ResponseEntity<?> response = controller.register(registerDTO);

        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode(), "Status code should be BAD_REQUEST.");
        Assertions.assertTrue(response.getBody() instanceof CustomApiResponse, "Response body should be CustomApiResponse.");
    }
}
