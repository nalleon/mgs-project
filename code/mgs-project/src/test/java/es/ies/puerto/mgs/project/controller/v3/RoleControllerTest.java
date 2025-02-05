package es.ies.puerto.mgs.project.controller.v3;

import es.ies.puerto.mgs.project.controller.v3.RoleController;

import es.ies.puerto.mgs.project.dto.outputs.RoleDTO;
import es.ies.puerto.mgs.project.model.entities.Role;
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
        List<Role> list = new ArrayList<>();
        list.add(new Role(1, "Admin"));
        list.add(new Role(2, "User"));
        list.add(new Role(3, "Guest"));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getAll(), MESSAGE_ERROR);
    }


    @Test
    void getOneTest() {
        when(serviceMock.getById(1)).thenReturn(new Role(1, "Admin"));
        List<Role> list = new ArrayList<>();
        list.add(new Role(1, "Admin"));
        list.add(new Role(2, "User"));
        list.add(new Role(3, "Guest"));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getById(1), MESSAGE_ERROR);
    }

    @Test
    void addTest() {
        when(serviceMock.add(any(Role.class))).thenReturn(true);
        RoleDTO aux = new RoleDTO(1, "Admin");
        ResponseEntity responseEntity = controller.add(aux);
        Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }


    @Test
    void deleteTest() {
        ResponseEntity responseEntity = controller.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }


    @Test
    void updateTest() {
        Role aux = new Role(1, "Admin");
        when(serviceMock.add(aux)).thenReturn(true);
        ResponseEntity responseEntity = controller.update(1, new RoleDTO(aux.getId(), aux.getName()));
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }

    @Test
    void updateExceptionTest() throws Exception {
        Role aux = new Role(1, "Admin");
        when(serviceMock.update(1, aux)).thenThrow(new RuntimeException("Database error"));
        Assertions.assertThrows(RuntimeException.class, () -> controller.update(1, new RoleDTO(aux.getId(), aux.getName())), MESSAGE_ERROR);
    }


}
