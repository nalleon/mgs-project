package es.ies.puerto.mgs.project.service.soap;

import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
import es.ies.puerto.mgs.project.repository.jpa.dao.IDaoMGSCharacter;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;
import es.ies.puerto.mgs.project.service.rest.impl.MGSCharacterService;
import es.ies.puerto.mgs.project.service.soap.impl.MGSCharacterServiceSoap;
import es.ies.puerto.mgs.project.utilities.MapperHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MGSCharacterServiceSoapTest extends MapperHelper {

    @Mock
    IDaoMGSCharacter daoMock;

    @Mock
    MGSCharacterService restServiceMock;

    @InjectMocks
    MGSCharacterServiceSoap service;


    @BeforeEach
    public void beforeEach (){
        MockitoAnnotations.openMocks(this);
        service = new MGSCharacterServiceSoap();
        restServiceMock = new MGSCharacterService();
        restServiceMock.setDao(daoMock);
        service.setService(restServiceMock);
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
        Assertions.assertNull(service.getById(1), MESSAGE_ERROR);
    }

    @Test
    void getOneTest() {
        when(daoMock.findById(1)).thenReturn(Optional.of(new MGSCharacter()));
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
    void updateExceptionTest() throws Exception {
        when(daoMock.findById(1)).thenThrow(new RuntimeException("Database error"));
        Assertions.assertFalse(service.update(new MGSCharacterDTO(1)), MESSAGE_ERROR);
    }
    @Test
    void updateTest() throws Exception {
        when(daoMock.findById(1)).thenReturn(Optional.of(new MGSCharacter()));
        Assertions.assertTrue(service.update(new MGSCharacterDTO(1)), MESSAGE_ERROR);
    }

    @Test
    void updateFalseTest() throws Exception {
        Assertions.assertFalse(service.update(new MGSCharacterDTO()), MESSAGE_ERROR);
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
