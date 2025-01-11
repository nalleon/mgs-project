package es.ies.puerto.mgs.project.service;
import es.ies.puerto.mgs.project.dto.WeaponDTO;
import es.ies.puerto.mgs.project.model.db.mongo.dao.IDaoWeapon;
import es.ies.puerto.mgs.project.model.entities.Weapon;
import es.ies.puerto.mgs.project.service.rest.impl.WeaponService;
import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

public class WeaponServiceTest extends TestUtilities {

    @Mock
    IDaoWeapon daoMock;

    @InjectMocks
    WeaponService service;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        service = new WeaponService();
        service.setiDaoWeapon(daoMock);
    }
    @Test
    void getAllTest() {
        List<Weapon> list = new ArrayList<>();
        list.add(new Weapon(1));
        list.add(new Weapon(2));
        list.add(new Weapon(3));
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
        when(daoMock.findAll()).thenReturn(new ArrayList<>(Arrays.asList(new Weapon(2), new Weapon(3))));

        Assertions.assertNull(service.getById(1), MESSAGE_ERROR);
    }

    @Test
    void getOneTest() {
        when(daoMock.existsById(1)).thenReturn(true);
        List<Weapon> list = new ArrayList<>();
        list.add(new Weapon(1));
        list.add(new Weapon(2));
        list.add(new Weapon(3));
        when(daoMock.findAll()).thenReturn(list);
        Assertions.assertNotNull(service.getById(1), MESSAGE_ERROR);
    }

    @Test
    void addTest() {
        when(daoMock.insert(any(Weapon.class))).thenReturn(new Weapon());
        Assertions.assertTrue(service.add(new WeaponDTO(1)), MESSAGE_ERROR);
    }

    @Test
    void addDupeTest() {
        when(daoMock.save(any(Weapon.class))).thenReturn(new Weapon());
        when(daoMock.existsById(1)).thenReturn(true);

        Assertions.assertTrue(service.add(new WeaponDTO(1, "test", "testing")), MESSAGE_ERROR);

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

    @Test
    void updateTest() throws Exception {
        when(daoMock.save(any(Weapon.class))).thenReturn(new Weapon());
        when(daoMock.findById(1)).thenReturn(Optional.of(new Weapon()));
        Assertions.assertTrue(service.update(1,new WeaponDTO(1)), MESSAGE_ERROR);
    }

    @Test
    void updateFalseTest() throws Exception {
        Assertions.assertFalse(service.update(0, null), MESSAGE_ERROR);
    }


}
