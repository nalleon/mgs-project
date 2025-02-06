package es.ies.puerto.mgs.project.service.security;

import es.ies.puerto.mgs.project.dto.user.UserLoginDTO;
import es.ies.puerto.mgs.project.dto.user.UserRegisterDTO;
import es.ies.puerto.mgs.project.model.entities.Role;
import es.ies.puerto.mgs.project.model.entities.User;
import es.ies.puerto.mgs.project.repository.jpa.dao.IDaoRole;
import es.ies.puerto.mgs.project.repository.jpa.dao.IDaoUser;
import es.ies.puerto.mgs.project.security.jwt.AuthService;
import es.ies.puerto.mgs.project.security.jwt.JwtService;
import es.ies.puerto.mgs.project.service.rest.RoleServiceTest;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.mockito.Mockito.when;

public class AuthServiceTest extends TestUtilities {


    @InjectMocks
    AuthService service;

    @Mock
    UserService serviceUserMock;

    @Mock
    RoleService serviceRoleMock;

    @Mock
    JwtService jwtServiceMock;

    @Mock
    PasswordEncoder passwordEncoder;

    @Mock
    IDaoRole daoMock;


    @Mock
    IDaoUser daoUserMock;



    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        service = new AuthService();

        serviceUserMock = new UserService();
        serviceUserMock.setDao(daoUserMock);
        serviceRoleMock = new RoleService();
        serviceRoleMock.setDao(daoMock);
        jwtServiceMock = new JwtService();

        service.setService(serviceUserMock);
        service.setRoleService(serviceRoleMock);
        service.setJwtService(jwtServiceMock);
        service.setPasswordEncoder(passwordEncoder);
    }

//    @Test
//    void testLoginSuccess() {
//        String username = "testUser";
//        String password = "testPass";
//        UserLoginDTO loginDTO = new UserLoginDTO(username, password);
//        String token = "valid.jwt.token";
//
//        when(service.authenticate(username, password)).thenReturn(token);
//
//        String result = service.authenticate(loginDTO.username(), loginDTO.password());
//
//        Assertions.assertEquals(token, result, MESSAGE_ERROR);
//    }
//
//    @Test
//    void testLoginFailure() {
//        String username = "testUser";
//        String password = "wrongPass";
//        UserLoginDTO loginDTO = new UserLoginDTO(username, password);
//
//        when(service.authenticate(username, password)).thenReturn(null);
//
//        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
//            service.authenticate(loginDTO.username(), loginDTO.password());
//        });
//
//        Assertions.assertEquals("Credenciales inválidas", exception.getMessage(), MESSAGE_ERROR);
//
//    }
//
//    @Test
//    void testRegisterSuccess() {
//        String username = "newUser";
//        String password = "newPass";
//        String email = "newuser@example.com";
//        UserRegisterDTO registerDTO = new UserRegisterDTO(username, password, email);
//        User newUser = new User();
//        newUser.setName(username);
//        newUser.setPassword(password);
//        newUser.setEmail(email);
//        newUser.setRole(new Role(1, "ROLE_USER"));
//        newUser.setId(3);
//
//        when(service.register(username, password, email)).thenReturn(newUser);
//
//        User response = service.register(registerDTO.username(), registerDTO.password(), registerDTO.email());
//
//
//        Assertions.assertNotNull(response, MESSAGE_ERROR);
//    }
//
//    @Test
//    void testRegisterFailure() {
//        String username = "existingUser";
//        String password = "existingPass";
//        String email = "existing@example.com";
//        UserRegisterDTO registerDTO = new UserRegisterDTO(username, password, email);
//
//        when(service.register(username, password, email)).thenReturn(null);
//
//        User response = service.register(registerDTO.username(), registerDTO.password(), registerDTO.email());
//
//        Assertions.assertNotNull(response, MESSAGE_ERROR);
//    }

}
