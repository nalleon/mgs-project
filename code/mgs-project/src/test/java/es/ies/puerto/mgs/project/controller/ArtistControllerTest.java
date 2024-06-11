package es.ies.puerto.mgs.project.controller;

import es.ies.puerto.mgs.project.controller.impl.ArtistController;
import es.ies.puerto.mgs.project.controller.impl.MGSCharacterController;
import es.ies.puerto.mgs.project.dto.ArtistDTO;
import es.ies.puerto.mgs.project.service.impl.ArtistService;
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

public class ArtistControllerTest extends TestUtilities {
    @Mock
    ArtistService serviceMock;

    @InjectMocks
    ArtistController controller;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        controller = new ArtistController();
        controller.setArtistService(serviceMock);
    }
    @Test
    void getAllTest() {
        List<ArtistDTO> list = new ArrayList<>();
        list.add(new ArtistDTO(1));
        list.add(new ArtistDTO(2));
        list.add(new ArtistDTO(3));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getAll(), MESSAGE_ERROR);
    }


    @Test
    void getOneTest() {
        when(serviceMock.getById(1)).thenReturn(new ArtistDTO(1));
        List<ArtistDTO> list = new ArrayList<>();
        list.add(new ArtistDTO(1));
        list.add(new ArtistDTO(2));
        list.add(new ArtistDTO(3));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getById(1), MESSAGE_ERROR);
    }

    @Test
    void addTest() {
        when(serviceMock.addUpdate(any(ArtistDTO.class))).thenReturn(true);
        ArtistDTO dto = new ArtistDTO(1);
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
        ArtistDTO dto = new ArtistDTO(1);
        when(serviceMock.addUpdate(dto)).thenReturn(true);
        ResponseEntity responseEntity = controller.update(dto);
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }

}
