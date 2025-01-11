package es.ies.puerto.mgs.project.service;

import es.ies.puerto.mgs.project.dto.UserDTO;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoUser;
import es.ies.puerto.mgs.project.model.entities.User;
import es.ies.puerto.mgs.project.service.rest.impl.UserService;
import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceTest extends TestUtilities {
    @Mock
    IDaoUser daoMock;

    @InjectMocks
    UserService service;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        service = new UserService();
        service.setIDaoUser(daoMock);
    }
    @Test
    void getAllTest() {
        List<User> list = new ArrayList<>();
        list.add(new User(1, "example@email.com"));
        list.add(new User(2, "example2@email.com"));
        list.add(new User(3, "example3@email.com"));
        when(daoMock.findAll()).thenReturn(list);
        Assertions.assertNotNull(service.getAll(), MESSAGE_ERROR);
    }

    @Test
    void getByIdNullTest() {
        when(daoMock.existsById(1)).thenReturn(false);
        Assertions.assertNull(service.getById(1), MESSAGE_ERROR);
    }

    @Test
    void getByIdEmptyListTest() {
        when(daoMock.existsById(1)).thenReturn(true);
        when(daoMock.findAll()).thenReturn(new ArrayList<>());

        Assertions.assertNull(service.getById(1), MESSAGE_ERROR);
    }

    @Test
    void getByIdListWithoutObjectTest() {
        when(daoMock.existsById(1)).thenReturn(true);
        when(daoMock.findAll()).thenReturn(new ArrayList<>(Arrays.asList(new User(2, "example2@email.com"), new User(3, "example3@email.com"))));
        Assertions.assertNull(service.getById(1), MESSAGE_ERROR);
    }

    @Test
    void getOneTest() {
        when(daoMock.existsById(1)).thenReturn(true);
        List<User> list = new ArrayList<>();
        list.add(new User(1, "example@email.com"));
        list.add(new User(2, "example2@email.com"));
        list.add(new User(3, "example3@email.com"));
        when(daoMock.findAll()).thenReturn(list);
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
    void deleteTest() {
        when(daoMock.existsById(1)).thenReturn(true);
        Assertions.assertTrue(service.delete(1), MESSAGE_ERROR);
    }

    @Test
    void deleteNonExistentTest() {
        when(daoMock.existsById(1)).thenReturn(false);
        Assertions.assertFalse(service.delete(1), MESSAGE_ERROR);
    }
}
