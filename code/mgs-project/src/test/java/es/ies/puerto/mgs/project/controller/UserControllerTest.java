package es.ies.puerto.mgs.project.controller;

import es.ies.puerto.mgs.project.controller.v3.UserController;
import es.ies.puerto.mgs.project.dto.user.UserV3InputDTO;
import es.ies.puerto.mgs.project.dto.outputs.UserDTO;
import es.ies.puerto.mgs.project.model.entities.Role;
import es.ies.puerto.mgs.project.model.entities.User;
import es.ies.puerto.mgs.project.service.rest.impl.RoleService;
import es.ies.puerto.mgs.project.service.rest.impl.UserService;
import es.ies.puerto.mgs.project.utilities.TestUtilities;
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class UserControllerTest extends TestUtilities {
    @Mock
    UserService serviceMock;
    @Mock
    RoleService serviceRoleMock;

    @InjectMocks
    UserController controller;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        controller = new UserController();
        controller.setUserService(serviceMock);
        controller.setRoleService(serviceRoleMock);
    }
    @Test
    void getAllTest() {
        List<User> list = new ArrayList<>();
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getAll(), MESSAGE_ERROR);
    }


    @Test
    void getOneTest() {
        when(serviceMock.getById(1)).thenReturn(new User(1, "example@email.com"));
        List<User> list = new ArrayList<>();
        list.add(new User(1, "example@email.com"));
        list.add(new User(2, "example2@email.com"));
        list.add(new User(3, "example3@email.com"));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getById(1), MESSAGE_ERROR);
    }

    @Test
    void addTest() {
        when(serviceMock.add(any(User.class))).thenReturn(true);
        when(serviceRoleMock.getById(1)).thenReturn(new Role(1, "ROLE_ADMIN"));

        User aux = new User(1, "example@email.com");
        ResponseEntity responseEntity = controller.add(new UserV3InputDTO("name", "pass", "mail", 1));
        Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }


    @Test
    void deleteTest() {
        ResponseEntity responseEntity = controller.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }


    @Test
    void updateTest() {
        User aux = new User(1, "example@email.com");
        when(serviceMock.add(aux)).thenReturn(true);
        ResponseEntity responseEntity = controller.update(1, new UserDTO(aux.getId(), aux.getName()));
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }

    @Test
    void updateExceptionTest() throws Exception {
        User aux = new User(1, "example@email.com");
        when(serviceMock.update(eq(1), any(User.class)))
                .thenThrow(new RuntimeException("Database error"));
        Assertions.assertThrows(RuntimeException.class,
                () -> controller.update(1, new UserDTO(aux.getId(), aux.getName())), MESSAGE_ERROR);
    }

}
