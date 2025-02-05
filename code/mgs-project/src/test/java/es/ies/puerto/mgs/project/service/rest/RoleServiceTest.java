package es.ies.puerto.mgs.project.service.rest;

import es.ies.puerto.mgs.project.repository.jpa.dao.IDaoRole;
import es.ies.puerto.mgs.project.model.entities.Role;
import es.ies.puerto.mgs.project.service.rest.impl.RoleService;
import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class RoleServiceTest extends TestUtilities {
    @Mock
    IDaoRole daoMock;

    @InjectMocks
    RoleService service;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        service = new RoleService();
        service.setDao(daoMock);
    }
    @Test
    void getAllTest() {
        List<Role> list = new ArrayList<>();
        list.add(new Role(1, "Admin"));
        list.add(new Role(2, "User"));
        list.add(new Role(3, "Guest"));
        when(daoMock.findAll()).thenReturn(list);
        Assertions.assertNotNull(service.getAll(), MESSAGE_ERROR);
    }

    @Test
    void getByIdNullTest() {
        Assertions.assertNull(service.getById(1), MESSAGE_ERROR);
    }


    @Test
    void getOneTest() {
        when(daoMock.findById(1)).thenReturn(Optional.of(new Role()));
        Assertions.assertNotNull(service.getById(1), MESSAGE_ERROR);
    }


    @Test
    void addTest() {
        when(daoMock.existsById(1)).thenReturn(false);
        when(daoMock.save(any(Role.class))).thenReturn(new Role());
        Assertions.assertTrue(service.add(new Role(1, "Admin")), MESSAGE_ERROR);
    }

    @Test
    void addNullTest() {
        Assertions.assertFalse(service.add(null), MESSAGE_ERROR);
    }

    @Test
    void addDupeTest() {
        when(daoMock.existsById(1)).thenReturn(true);
        Assertions.assertFalse(service.add(new Role(1, "Admin")), MESSAGE_ERROR);
    }

    @Test
    void updateExceptionTest() throws Exception {
        when(daoMock.findById(1)).thenThrow(new RuntimeException("Database error"));
        Assertions.assertFalse(service.update(1, new Role(1, "Admin")), MESSAGE_ERROR);
    }
    @Test
    void updateTest() throws Exception {
        when(daoMock.findById(1)).thenReturn(Optional.of(new Role()));
        Assertions.assertTrue(service.update(1,new Role(1, "admin")), MESSAGE_ERROR);
    }

    @Test
    void updateFalseTest() throws Exception {
        Assertions.assertFalse(service.update(0, null), MESSAGE_ERROR);
    }

    @Test
    void deleteTest() {
        when(daoMock.deleteItemById(2)).thenReturn(2);
        Assertions.assertTrue(service.delete(2), MESSAGE_ERROR);
    }
    @Test
    void deleteAdminTest() {
        when(daoMock.deleteItemById(1)).thenReturn(1);
        Assertions.assertFalse(service.delete(1), MESSAGE_ERROR);
    }

    @Test
    void deleteNonExistentTest() {
        when(daoMock.deleteItemById(1)).thenReturn(0);
        Assertions.assertFalse(service.delete(1), MESSAGE_ERROR);
    }

    @Test
    void deleteFailTest() {
        when(daoMock.deleteItemById(2)).thenReturn(0);
        Assertions.assertFalse(service.delete(2), MESSAGE_ERROR);
    }

}
