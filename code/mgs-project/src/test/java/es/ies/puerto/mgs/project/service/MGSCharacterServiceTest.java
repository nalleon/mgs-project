package es.ies.puerto.mgs.project.service;

import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoMGSCharacter;
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

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MGSCharacterServiceTest extends MapperHelper {
    @Mock
    private IDaoMGSCharacter daoMock;

    @InjectMocks
    private MGSCharacterService service;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllObjects() {
        when(daoMock.findAll()).thenReturn(new ArrayList<>(List.of(mgsCharacter)));

        List<MGSCharacterDTO> result = service.getAll();

        Assertions.assertEquals(1, result.size(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacterDTO.getId(), result.get(0).getId(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacterDTO.getName(), result.get(0).getName(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacterDTO.getCodename(), result.get(0).getCodename(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacterDTO.getAge(), result.get(0).getAge(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacterDTO.isStatus(), result.get(0).isStatus(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacterDTO.getArtist(), result.get(0).getArtist(), MESSAGE_ERROR);

        verify(daoMock, times(1)).findAll();
    }

    @Test
    void testSaveGetOneObject() {
        when(daoMock.save(mgsCharacter)).thenReturn(mgsCharacter);

        MGSCharacterDTO mgsCharacterDTOAdd = mgsCharacterDTO;
        Assertions.assertTrue(service.add(mgsCharacterDTOAdd), MESSAGE_ERROR);
    }

    //@Test
    void testUpdateObjectExists() {
        when(daoMock.existsById(mgsCharacter.getId())).thenReturn(true);
        when(daoMock.save(mgsCharacter)).thenReturn(mgsCharacter);

        MGSCharacterDTO mgsCharacterDTOUpdate = mgsCharacterDTO;
        service.update(mgsCharacterDTOUpdate);

        mgsCharacterDTOUpdate = service.getById(mgsCharacterDTOUpdate.getId());

        Assertions.assertNotNull(mgsCharacterDTOUpdate, MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacterDTO.getId(), mgsCharacterDTOUpdate.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacterDTO.getName(), mgsCharacterDTOUpdate.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacterDTO.getCodename(), mgsCharacterDTOUpdate.getCodename(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacterDTO.getAge(), mgsCharacterDTOUpdate.getAge(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacterDTO.isStatus(), mgsCharacterDTOUpdate.isStatus(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacterDTO.getArtist(), mgsCharacterDTOUpdate.getArtist(), MESSAGE_ERROR);


        verify(daoMock, times(1)).existsById(mgsCharacter.getId());
        verify(daoMock, times(1)).save(mgsCharacter);
    }

    //@Test
    void testUpdateObjectNotExists() {
        when(daoMock.existsById(mgsCharacter.getId())).thenReturn(false);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.update(mgsCharacterDTO);
        });
        Assertions.assertEquals("Character not found with id 1", exception.getMessage());

        verify(daoMock, times(1)).existsById(mgsCharacter.getId());
        verify(daoMock, times(0)).save(mgsCharacter);
    }

   // @Test
    void testDeleteObjectExists() {
        when(daoMock.existsById(mgsCharacter.getId())).thenReturn(true);

        service.delete(mgsCharacter.getId());

        verify(daoMock, times(1)).existsById(mgsCharacter.getId());
        verify(daoMock, times(1)).deleteById(mgsCharacter.getId());
    }

   // @Test
    void testDeleteObjectNotExists() {
        when(daoMock.existsById(mgsCharacter.getId())).thenReturn(false);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.delete(mgsCharacterDTO.getId());
        });
        assertEquals("Character not found with id 1", exception.getMessage());

        verify(daoMock, times(1)).existsById(mgsCharacter.getId());
        verify(daoMock, times(0)).deleteById(mgsCharacter.getId());
    }
}
