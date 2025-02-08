package es.ies.puerto.mgs.project.controller.v3;

import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;
import es.ies.puerto.mgs.project.service.rest.impl.MGSCharacterService;
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

public class MGSCharacterControllerTest extends TestUtilities {

    @Mock
    MGSCharacterService serviceMock;

    @InjectMocks
    MGSCharacterController controller;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        controller = new MGSCharacterController();
        controller.setMgsCharacterService(serviceMock);
    }
    @Test
    void getAllTest() {
        List<MGSCharacter> list = new ArrayList<>();
        list.add(new MGSCharacter(1));
        list.add(new MGSCharacter(2));
        list.add(new MGSCharacter(3));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getAll(), MESSAGE_ERROR);
    }


    @Test
    void getOneTest() {
        when(serviceMock.getById(1)).thenReturn(new MGSCharacter(1));
        List<MGSCharacter> list = new ArrayList<>();
        list.add(new MGSCharacter(1));
        list.add(new MGSCharacter(2));
        list.add(new MGSCharacter(3));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getById(1), MESSAGE_ERROR);
    }

    @Test
    void addTest() {
        when(serviceMock.add(any(MGSCharacter.class))).thenReturn(true);
        MGSCharacter aux = new MGSCharacter(1);
        ResponseEntity responseEntity = controller.add(new MGSCharacterDTO(aux.getId()));
        Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }


    @Test
    void deleteTest() {
        ResponseEntity responseEntity = controller.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }


    @Test
    void updateTest() {
        MGSCharacter aux = new MGSCharacter(1);
        when(serviceMock.add(aux)).thenReturn(true);
        ResponseEntity responseEntity = controller.update(1, new MGSCharacterDTO(aux.getId()));
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }

    @Test
    void updateExceptionTest() throws Exception {
        MGSCharacter aux = new MGSCharacter(1);
        when(serviceMock.update(1, new MGSCharacter(1))).thenThrow(new RuntimeException("Database error"));
        Assertions.assertThrows(RuntimeException.class, () -> controller.update(1, new MGSCharacterDTO(aux.getId())), MESSAGE_ERROR);
    }

}
