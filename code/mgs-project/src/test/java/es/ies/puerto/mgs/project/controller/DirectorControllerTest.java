package es.ies.puerto.mgs.project.controller;

import es.ies.puerto.mgs.project.controller.impl.DirectorController;
import es.ies.puerto.mgs.project.controller.impl.MGSCharacterController;
import es.ies.puerto.mgs.project.dto.DirectorDTO;
import es.ies.puerto.mgs.project.service.impl.DirectorService;
import es.ies.puerto.mgs.project.service.impl.MGSCharacterService;
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
        List<DirectorDTO> list = new ArrayList<>();
        list.add(new DirectorDTO(1));
        list.add(new DirectorDTO(2));
        list.add(new DirectorDTO(3));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getAll(), MESSAGE_ERROR);
    }


    @Test
    void getOneTest() {
        when(serviceMock.getById(1)).thenReturn(new DirectorDTO(1));
        List<DirectorDTO> list = new ArrayList<>();
        list.add(new DirectorDTO(1));
        list.add(new DirectorDTO(2));
        list.add(new DirectorDTO(3));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getById(1), MESSAGE_ERROR);
    }

    @Test
    void addTest() {
        when(serviceMock.addUpdate(any(DirectorDTO.class))).thenReturn(true);
        DirectorDTO dto = new DirectorDTO(1);
        ResponseEntity responseEntity = controller.add(dto);
        Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }


    @Test
    void deleteTest() {
        ResponseEntity responseEntity = controller.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }


    @Test
    void updateTest() {
        DirectorDTO dto = new DirectorDTO(1);
        when(serviceMock.addUpdate(dto)).thenReturn(true);
        ResponseEntity responseEntity = controller.update(dto);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }

}
