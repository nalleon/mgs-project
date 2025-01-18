package es.ies.puerto.mgs.project.service.soap;
import es.ies.puerto.mgs.project.dto.WeaponDTO;

import es.ies.puerto.mgs.project.mapper.struct.IWeaponMapper;
import es.ies.puerto.mgs.project.model.db.mongo.dao.IDaoWeapon;
import es.ies.puerto.mgs.project.model.entities.Weapon;
import es.ies.puerto.mgs.project.service.rest.impl.WeaponService;
import es.ies.puerto.mgs.project.service.soap.impl.WeaponServiceSoap;
import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

public class WeaponServiceSoapTest extends TestUtilities {

    @Mock
    WeaponService restServiceMock;
    @Mock
    IDaoWeapon daoMock;

    @InjectMocks
    WeaponServiceSoap service;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);

        service = new WeaponServiceSoap();
        restServiceMock = new WeaponService();
        restServiceMock.setDao(daoMock);
        service.setService(restServiceMock);
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
        Assertions.assertNull(service.getById(1), MESSAGE_ERROR);
    }

    @Test
    void getOneTest() {
        when(daoMock.findById(1)).thenReturn(Optional.of(new Weapon()));
        Assertions.assertNotNull(service.getById(1), MESSAGE_ERROR);
    }

    @Test
    void addTest() {
        when(daoMock.insert(any(Weapon.class))).thenReturn(new Weapon());
        Assertions.assertTrue(service.add(new WeaponDTO(1)), MESSAGE_ERROR);
    }

    @Test
    void addDupeTest() {
        when(daoMock.existsById(1)).thenReturn(true);
        Assertions.assertFalse(service.add(new WeaponDTO(1)), MESSAGE_ERROR);
    }

    @Test
    void deleteTest() {
        when(daoMock.deleteItemById(1)).thenReturn(1);
        Assertions.assertTrue(service.delete(1), MESSAGE_ERROR);
    }

    @Test
    void deleteNonExistentTest() {
        when(daoMock.deleteItemById(1)).thenReturn(0);
        Assertions.assertFalse(service.delete(1), MESSAGE_ERROR);
    }

    @Test
    void updateTest() throws Exception {
        when(daoMock.findById(1)).thenReturn(Optional.of(new Weapon()));
        Assertions.assertTrue(service.update(new WeaponDTO(1)), MESSAGE_ERROR);
    }

    @Test
    void updateExceptionTest() throws Exception {
        when(daoMock.findById(1)).thenThrow(new RuntimeException("Database error"));
        Assertions.assertFalse(service.update( new WeaponDTO(1)), MESSAGE_ERROR);
    }
    @Test
    void updateFalseTest() throws Exception {
        Assertions.assertFalse(service.update(new WeaponDTO()), MESSAGE_ERROR);
    }




}
