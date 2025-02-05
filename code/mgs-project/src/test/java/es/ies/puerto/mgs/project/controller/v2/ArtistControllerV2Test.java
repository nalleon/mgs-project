package es.ies.puerto.mgs.project.controller.v2;

import es.ies.puerto.mgs.project.controller.v2.ArtistController;
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

public class ArtistControllerV2Test extends TestUtilities {
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

}
