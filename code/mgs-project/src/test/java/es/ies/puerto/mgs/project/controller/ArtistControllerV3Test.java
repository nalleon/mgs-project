package es.ies.puerto.mgs.project.controller;

import es.ies.puerto.mgs.project.controller.v3.ArtistControllerV3;
import es.ies.puerto.mgs.project.dto.outputs.ArtistDTO;
import es.ies.puerto.mgs.project.exception.InvalidResourceException;
import es.ies.puerto.mgs.project.exception.NotFoundException;
import es.ies.puerto.mgs.project.model.entities.Artist;
import es.ies.puerto.mgs.project.service.rest.impl.ArtistService;
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

public class ArtistControllerV3Test extends TestUtilities {
    @Mock
    ArtistService serviceMock;

    @InjectMocks
    ArtistControllerV3 controller;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        controller = new ArtistControllerV3();
        controller.setArtistService(serviceMock);
    }
    @Test
    void getAllTest() {
        List<Artist> list = new ArrayList<>();
        list.add(new Artist(1));
        list.add(new Artist(2));
        list.add(new Artist(3));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getAll(), MESSAGE_ERROR);
    }


    @Test
    void getOneTest() {
        when(serviceMock.getById(1)).thenReturn(new Artist(1));
        List<Artist> list = new ArrayList<>();
        list.add(new Artist(1));
        list.add(new Artist(2));
        list.add(new Artist(3));
        when(serviceMock.getAll()).thenReturn(list);
        Assertions.assertNotNull(controller.getById(1), MESSAGE_ERROR);
    }

    @Test
    void addTest() throws InvalidResourceException, NotFoundException {
        when(serviceMock.add(any(Artist.class))).thenReturn(true);
        Artist aux = new Artist(1);
        ResponseEntity responseEntity = controller.add(new ArtistDTO(aux.getArtistId()));
        Assertions.assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }


    @Test
    void deleteTest() {
        ResponseEntity responseEntity = controller.delete(1);
        Assertions.assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }


    @Test
    void updateTest() throws InvalidResourceException, NotFoundException {
        Artist aux = new Artist(1);
        when(serviceMock.add(aux)).thenReturn(true);
        ResponseEntity responseEntity = controller.update(1, new ArtistDTO(aux.getArtistId()));
        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode(), MESSAGE_ERROR);
    }


    @Test
    void updateExceptionTest() throws Exception {
        Artist aux = new Artist(1);
        when(serviceMock.update(1, new Artist(1))).thenThrow(new RuntimeException("Database error"));
        Assertions.assertThrows(RuntimeException.class, () -> controller.update(1, new ArtistDTO(aux.getArtistId())), MESSAGE_ERROR);
    }

}
