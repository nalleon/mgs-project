package es.ies.puerto.mgs.project.controller;

import es.ies.puerto.mgs.project.controller.impl.DirectorController;

import es.ies.puerto.mgs.project.dto.DirectorDTO;
import es.ies.puerto.mgs.project.model.entities.Director;
import es.ies.puerto.mgs.project.service.rest.impl.DirectorService;
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

public class DirectorControllerTest extends TestUtilities {
    @Mock
    DirectorService serviceMock;

    @InjectMocks
    DirectorController controller;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        controller = new DirectorController();
        controller.setDirectorService(serviceMock);
    }
    @Test
    void getAllTest() {
        List<Director> list = new ArrayList<>();
        list.add(new Director(1));
        list.add(new Director(2));
        list.add(new Director(3));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getAll(), MESSAGE_ERROR);
    }


    @Test
    void getOneTest() {
        when(serviceMock.getById(1)).thenReturn(new Director(1));
        List<Director> list = new ArrayList<>();
        list.add(new Director(1));
        list.add(new Director(2));
        list.add(new Director(3));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getById(1), MESSAGE_ERROR);
    }

    @Test
    void addTest() {
        when(serviceMock.add(any(Director.class))).thenReturn(true);
        Director aux = new Director(1);
        ResponseEntity responseEntity = controller.add(new DirectorDTO(aux.getDirectorId()));
        Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }


    @Test
    void deleteTest() {
        ResponseEntity responseEntity = controller.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }


    @Test
    void updateTest() {
        Director aux = new Director(1);
        when(serviceMock.add(aux)).thenReturn(true);
        ResponseEntity responseEntity = controller.update(1, new DirectorDTO(aux.getDirectorId()));
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }

    @Test
    void updateExceptionTest() throws Exception {
        Director aux = new Director(1);
        when(serviceMock.update(1, new Director(1))).thenThrow(new RuntimeException("Database error"));
        Assertions.assertThrows(RuntimeException.class, () -> controller.update(1, new DirectorDTO(aux.getDirectorId())), MESSAGE_ERROR);
    }
}
