package es.ies.puerto.mgs.project.controller;

import es.ies.puerto.mgs.project.controller.impl.UserController;
import es.ies.puerto.mgs.project.dto.UserDTO;
import es.ies.puerto.mgs.project.service.rest.UserService;
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
import static org.mockito.Mockito.when;

public class UserControllerTest extends TestUtilities {
    @Mock
    UserService serviceMock;

    @InjectMocks
    UserController controller;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        controller = new UserController();
        controller.setUserService(serviceMock);
    }
    @Test
    void getAllTest() {
        List<UserDTO> list = new ArrayList<>();
        list.add(new UserDTO(1, "example@email.com"));
        list.add(new UserDTO(2, "example2@email.com"));
        list.add(new UserDTO(3, "example3@email.com"));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getAll(), MESSAGE_ERROR);
    }


    @Test
    void getOneTest() {
        when(serviceMock.getById(1)).thenReturn(new UserDTO(1, "example@email.com"));
        List<UserDTO> list = new ArrayList<>();
        list.add(new UserDTO(1, "example@email.com"));
        list.add(new UserDTO(2, "example2@email.com"));
        list.add(new UserDTO(3, "example3@email.com"));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getById(1), MESSAGE_ERROR);
    }

    @Test
    void addTest() {
        when(serviceMock.add(any(UserDTO.class))).thenReturn(true);
        UserDTO dto = new UserDTO(1, "example@email.com");
        ResponseEntity responseEntity = controller.add(dto);
        Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }


    @Test
    void deleteTest() {
        ResponseEntity responseEntity = controller.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }


    @Test
    void updateTest() {
        UserDTO dto = new UserDTO(1, "example@email.com");
        when(serviceMock.add(dto)).thenReturn(true);
        ResponseEntity responseEntity = controller.update(1, dto);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }

}
