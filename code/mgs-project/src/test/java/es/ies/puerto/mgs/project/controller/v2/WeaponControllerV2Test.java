package es.ies.puerto.mgs.project.controller.v2;


import es.ies.puerto.mgs.project.model.documents.Weapon;
import es.ies.puerto.mgs.project.service.rest.impl.WeaponService;
import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class WeaponControllerV2Test extends TestUtilities {

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


}
