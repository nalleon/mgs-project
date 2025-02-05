package es.ies.puerto.mgs.project.controller.v3;

import es.ies.puerto.mgs.project.dto.outputs.WeaponDTO;
import es.ies.puerto.mgs.project.model.documents.Weapon;
import es.ies.puerto.mgs.project.service.rest.impl.WeaponService;
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

public class WeaponControllerTest extends TestUtilities {

    @Mock
    WeaponService serviceMock;

    @InjectMocks
    WeaponController controller;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        controller = new WeaponController();
        controller.setWeaponService(serviceMock);
    }
    @Test
    void getAllTest() {
        List<Weapon> list = new ArrayList<>();
        list.add(new Weapon(1));
        list.add(new Weapon(2));
        list.add(new Weapon(3));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getAll(), MESSAGE_ERROR);
    }


    @Test
    void getOneTest() {
        when(serviceMock.getById(1)).thenReturn(new Weapon(1));
        List<Weapon> list = new ArrayList<>();
        list.add(new Weapon(1));
        list.add(new Weapon(2));
        list.add(new Weapon(3));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getById(1), MESSAGE_ERROR);
    }

    @Test
    void addTest() {
        when(serviceMock.add(any(Weapon.class))).thenReturn(true);
        Weapon aux = new Weapon(1);
        ResponseEntity responseEntity = controller.add(new WeaponDTO(aux.getId()));
        Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }


    @Test
    void deleteTest() {
        ResponseEntity responseEntity = controller.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }


    @Test
    void updateTest() {
        Weapon aux = new Weapon(1);
        when(serviceMock.update(1, aux)).thenReturn(true);
        ResponseEntity responseEntity = controller.update(1, new WeaponDTO(aux.getId()));
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }

    @Test
    void updateExceptionTest() throws Exception {
        Weapon aux = new Weapon(1);
        when(serviceMock.update(1, new Weapon(1))).thenThrow(new RuntimeException("Database error"));
        Assertions.assertThrows(RuntimeException.class, () -> controller.update(1, new WeaponDTO(aux.getId())), MESSAGE_ERROR);
    }
}
