package es.ies.puerto.mgs.project.service.soap;

import es.ies.puerto.mgs.project.dto.ArtistDTO;
import es.ies.puerto.mgs.project.repository.jpa.dao.IDaoArtist;
import es.ies.puerto.mgs.project.model.entities.Artist;
import es.ies.puerto.mgs.project.service.rest.impl.ArtistService;
import es.ies.puerto.mgs.project.service.soap.impl.ArtistServiceSoap;
import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ArtistServiceSoapTest extends TestUtilities {
    @Mock
    IDaoArtist daoMock;

    @Mock
    ArtistService restServiceMock;
    @InjectMocks
    ArtistServiceSoap service;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        service = new ArtistServiceSoap();
        restServiceMock = new ArtistService();
        restServiceMock.setDao(daoMock);
        service.setService(restServiceMock);
    }
    @Test
    void getAllTest() {
        List<Artist> list = new ArrayList<>();
        list.add(new Artist(1));
        list.add(new Artist(2));
        list.add(new Artist(3));
        when(daoMock.findAll()).thenReturn(list);
        Assertions.assertNotNull(service.getAll(), MESSAGE_ERROR);
    }

    @Test
    void getByIdNullTest() {
        Assertions.assertNull(service.getById(1), MESSAGE_ERROR);
    }

    @Test
    void getByIdListWithoutObjectTest() {
        Assertions.assertNull(service.getById(1), MESSAGE_ERROR);
    }

    @Test
    void getOneTest() {
        when(daoMock.findById(1)).thenReturn(Optional.of(new Artist()));
        Assertions.assertNotNull(service.getById(1), MESSAGE_ERROR);
    }

    @Test
    void addUpdateTest() {
        when(daoMock.save(any(Artist.class))).thenReturn(new Artist());
        Assertions.assertTrue(service.add(new ArtistDTO(1)), MESSAGE_ERROR);
    }

    @Test
    void addUpdateFalseTest() {
        Assertions.assertFalse(service.add(null), MESSAGE_ERROR);
    }

    @Test
    void updateExceptionTest() throws Exception {
        when(daoMock.findById(1)).thenThrow(new RuntimeException("Database error"));
        Assertions.assertFalse(service.update(new ArtistDTO(1)), MESSAGE_ERROR);
    }
    @Test
    void updateTest() throws Exception {
        when(daoMock.findById(1)).thenReturn(Optional.of(new Artist()));
        Assertions.assertTrue(service.update(new ArtistDTO(1)), MESSAGE_ERROR);
    }

    @Test
    void updateFalseTest() throws Exception {
        Assertions.assertFalse(service.update(new ArtistDTO()), MESSAGE_ERROR);
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
}
