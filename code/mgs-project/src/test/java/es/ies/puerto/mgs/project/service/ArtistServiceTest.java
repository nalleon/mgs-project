package es.ies.puerto.mgs.project.service;

import es.ies.puerto.mgs.project.dto.ArtistDTO;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoArtist;
import es.ies.puerto.mgs.project.model.entities.Artist;
import es.ies.puerto.mgs.project.service.impl.ArtistService;
import es.ies.puerto.mgs.project.utilities.TestUtilities;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class ArtistServiceTest extends TestUtilities {
    @Mock
    IDaoArtist daoMock;

    @InjectMocks
    ArtistService service;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        service = new ArtistService();
        service.setiDaoArtist(daoMock);
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
        when(daoMock.existsById(1)).thenReturn(false);
        Assertions.assertNull(service.getById(1), MESSAGE_ERROR);
    }

    @Test
    void getByIdEmptyListTest() {
        when(daoMock.existsById(1)).thenReturn(true);
        when(daoMock.findAll()).thenReturn(new ArrayList<>());

        Assertions.assertNull(service.getById(1), MESSAGE_ERROR);
    }

    @Test
    void getByIdListWithoutObjectTest() {
        when(daoMock.existsById(1)).thenReturn(true);
        when(daoMock.findAll()).thenReturn(new ArrayList<>(Arrays.asList(new Artist(2), new Artist(3))));

        Assertions.assertNull(service.getById(1), MESSAGE_ERROR);
    }

    @Test
    void getOneTest() {
        when(daoMock.existsById(1)).thenReturn(true);
        List<Artist> list = new ArrayList<>();
        list.add(new Artist(1));
        list.add(new Artist(2));
        list.add(new Artist(3));
        when(daoMock.findAll()).thenReturn(list);
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
    void updateTest() throws Exception {
        when(daoMock.save(any(Artist.class))).thenReturn(new Artist());
        when(daoMock.findById(1)).thenReturn(Optional.of(new Artist()));
        Assertions.assertTrue(service.update(1,new ArtistDTO(1)), MESSAGE_ERROR);
    }

    @Test
    void updateFalseTest() throws Exception {
        Assertions.assertFalse(service.update(0, null), MESSAGE_ERROR);
    }


    @Test
    void deleteTest() {
        when(daoMock.existsById(1)).thenReturn(true);
        Assertions.assertTrue(service.delete(1), MESSAGE_ERROR);
    }

    @Test
    void deleteNonExistentTest() {
        when(daoMock.existsById(1)).thenReturn(false);
        Assertions.assertFalse(service.delete(1), MESSAGE_ERROR);
    }
}
