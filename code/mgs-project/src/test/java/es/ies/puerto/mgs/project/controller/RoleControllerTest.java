package es.ies.puerto.mgs.project.controller;

import es.ies.puerto.mgs.project.controller.impl.RoleController;
import es.ies.puerto.mgs.project.dto.RoleDTO;
import es.ies.puerto.mgs.project.dto.UserDTO;
import es.ies.puerto.mgs.project.service.rest.impl.RoleService;
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

public class RoleControllerTest extends TestUtilities {
    @Mock
    RoleService serviceMock;

    @InjectMocks
    RoleController controller;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        controller = new RoleController();
        controller.setRoleService(serviceMock);
    }
    @Test
    void getAllTest() {
        List<RoleDTO> list = new ArrayList<>();
        list.add(new RoleDTO(1, "Admin"));
        list.add(new RoleDTO(2, "User"));
        list.add(new RoleDTO(3, "Guest"));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getAll(), MESSAGE_ERROR);
    }


    @Test
    void getOneTest() {
        when(serviceMock.getById(1)).thenReturn(new RoleDTO(1, "Admin"));
        List<RoleDTO> list = new ArrayList<>();
        list.add(new RoleDTO(1, "Admin"));
        list.add(new RoleDTO(2, "User"));
        list.add(new RoleDTO(3, "Guest"));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getById(1), MESSAGE_ERROR);
    }

    @Test
    void addTest() {
        when(serviceMock.add(any(RoleDTO.class))).thenReturn(true);
        RoleDTO dto = new RoleDTO(1, "Admin");
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
        RoleDTO dto = new RoleDTO(1, "Admin");
        when(serviceMock.add(dto)).thenReturn(true);
        ResponseEntity responseEntity = controller.update(1, dto);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }

    @Test
    void updateExceptionTest() throws Exception {
        RoleDTO dto = new RoleDTO(1, "Admin");
        when(serviceMock.update(1, dto)).thenThrow(new RuntimeException("Database error"));
        Assertions.assertThrows(RuntimeException.class, () -> controller.update(1, dto), MESSAGE_ERROR);
    }


}
