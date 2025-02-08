package es.ies.puerto.mgs.project.service.soap;

import es.ies.puerto.mgs.project.dto.RoleDTO;
import es.ies.puerto.mgs.project.dto.user.UserDTO;
import es.ies.puerto.mgs.project.repository.jpa.dao.IDaoUser;
import es.ies.puerto.mgs.project.model.entities.User;
import es.ies.puerto.mgs.project.service.rest.impl.UserService;
import es.ies.puerto.mgs.project.service.soap.impl.UserServiceSoap;
import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceSoapTest extends TestUtilities {
    @Mock
    UserService restServiceMock;
    @Mock
    IDaoUser daoMock;
    @Mock
    PasswordEncoder passwordEncoder;

    @InjectMocks
    UserServiceSoap service;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);

        service = new UserServiceSoap();
        restServiceMock = new UserService();
        restServiceMock.setDao(daoMock);
        restServiceMock.setPasswordEncoder(passwordEncoder);
        service.setService(restServiceMock);
    }
    @Test
    void getAllTest() {
        List<User> list = new ArrayList<>();
        when(daoMock.findAll()).thenReturn(list);
        Assertions.assertNotNull(service.getAll(), MESSAGE_ERROR);
    }

    @Test
    void getByIdNullTest() {
        Assertions.assertNull(service.getById(1), MESSAGE_ERROR);
    }


    @Test
    void getOneTest() {
        when(daoMock.findById(1)).thenReturn(Optional.of(new User()));
        Assertions.assertNotNull(service.getById(1), MESSAGE_ERROR);
    }

    @Test
    void addUpdateTest() {
        when(daoMock.save(any(User.class))).thenReturn(new User());
        Assertions.assertTrue(service.add(new UserDTO(1, "example@email.com")), MESSAGE_ERROR);
    }

    @Test
    void addUpdateFalseTest() {
        Assertions.assertFalse(service.add(null), MESSAGE_ERROR);
    }
    @Test
    void updateExceptionTest() throws Exception {
        when(daoMock.findById(1)).thenThrow(new RuntimeException("Database error"));
        Assertions.assertFalse(service.update(new UserDTO(1, "example@email.com")), MESSAGE_ERROR);
    }
    @Test
    void updateTest() throws Exception {
        when(daoMock.findById(1)).thenReturn(Optional.of(new User()));
        UserDTO user = new UserDTO();
        user.setId(1);
        user.setRole(new RoleDTO(1, "ROLE_ADMIN"));
        user.setEmail("example@email.com");
        user.setPassword("1q2w3e4r");
        user.setName("nameTest");
        Assertions.assertTrue(service.update(user), MESSAGE_ERROR);
    }

    @Test
    void updateFalseTest() throws Exception {
        Assertions.assertFalse(service.update(new UserDTO()), MESSAGE_ERROR);
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
}
