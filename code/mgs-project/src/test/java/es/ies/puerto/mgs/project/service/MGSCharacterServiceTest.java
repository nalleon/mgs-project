package es.ies.puerto.mgs.project.service;

import es.ies.puerto.mgs.project.dto.GameDTO;
import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoMGSCharacter;
import es.ies.puerto.mgs.project.model.entities.Game;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;
import es.ies.puerto.mgs.project.service.impl.MGSCharacterService;
import es.ies.puerto.mgs.project.utilities.MapperHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MGSCharacterServiceTest extends MapperHelper {

    @Mock
    IDaoMGSCharacter daoMock;

    @InjectMocks
    MGSCharacterService service;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        service = new MGSCharacterService();
        service.setiDaoMGSCharacter(daoMock);
    }
    @Test
    void getAllTest() {
        List<MGSCharacter> list = new ArrayList<>();
        list.add(new MGSCharacter(1));
        list.add(new MGSCharacter(2));
        list.add(new MGSCharacter(3));
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
        when(daoMock.findAll()).thenReturn(new ArrayList<>(Arrays.asList(new MGSCharacter(2), new MGSCharacter(3))));

        Assertions.assertNull(service.getById(1), MESSAGE_ERROR);
    }

    @Test
    void getOneTest() {
        when(daoMock.existsById(1)).thenReturn(true);
        List<MGSCharacter> list = new ArrayList<>();
        list.add(new MGSCharacter(1));
        list.add(new MGSCharacter(2));
        list.add(new MGSCharacter(3));
        when(daoMock.findAll()).thenReturn(list);
        Assertions.assertNotNull(service.getById(1), MESSAGE_ERROR);
    }

    @Test
    void addUpdateTest() {
        when(daoMock.save(any(MGSCharacter.class))).thenReturn(new MGSCharacter());
        Assertions.assertTrue(service.add(new MGSCharacterDTO(1)), MESSAGE_ERROR);
    }

    @Test
    void addUpdateFalseTest() {
        Assertions.assertFalse(service.add(null), MESSAGE_ERROR);
    }

    @Test
    void updateTest() throws Exception {
        when(daoMock.save(any(MGSCharacter.class))).thenReturn(new MGSCharacter());
        when(daoMock.findById(1)).thenReturn(Optional.of(new MGSCharacter()));
        Assertions.assertTrue(service.update(1,new MGSCharacterDTO(1)), MESSAGE_ERROR);
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
