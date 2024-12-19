package es.ies.puerto.mgs.project.controller;

import es.ies.puerto.mgs.project.controller.impl.MGSCharacterController;
import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
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
        List<MGSCharacterDTO> list = new ArrayList<>();
        list.add(new MGSCharacterDTO(1));
        list.add(new MGSCharacterDTO(2));
        list.add(new MGSCharacterDTO(3));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getAll(), MESSAGE_ERROR);
    }


    @Test
    void getOneTest() {
        when(serviceMock.getById(1)).thenReturn(new MGSCharacterDTO(1));
        List<MGSCharacterDTO> list = new ArrayList<>();
        list.add(new MGSCharacterDTO(1));
        list.add(new MGSCharacterDTO(2));
        list.add(new MGSCharacterDTO(3));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getById(1), MESSAGE_ERROR);
    }

    @Test
    void addTest() {
        when(serviceMock.add(any(MGSCharacterDTO.class))).thenReturn(true);
        MGSCharacterDTO dto = new MGSCharacterDTO(1);
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
        MGSCharacterDTO dto = new MGSCharacterDTO(1);
        when(serviceMock.add(dto)).thenReturn(true);
        ResponseEntity responseEntity = controller.update(1, dto);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }

}
