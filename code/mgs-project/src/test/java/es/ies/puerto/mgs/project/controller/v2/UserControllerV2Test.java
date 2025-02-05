package es.ies.puerto.mgs.project.controller.v2;

import es.ies.puerto.mgs.project.controller.v3.UserController;
import es.ies.puerto.mgs.project.dto.outputs.UserDTO;
import es.ies.puerto.mgs.project.dto.user.UserV3InputDTO;
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

public class UserControllerV2Test extends TestUtilities {
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

}
