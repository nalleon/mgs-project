package es.ies.puerto.mgs.project.mapper.struct;

import es.ies.puerto.mgs.project.dto.DirectorDTO;
import es.ies.puerto.mgs.project.model.entities.Director;
import es.ies.puerto.mgs.project.utilities.MapperHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IDirectorMapperTest extends MapperHelper {
    Director directorEntityMapper;
    DirectorDTO directorDTOMapper;

    @Test
    public void toDTOTest(){
        directorDTOMapper = IDirectorMapper.INSTANCE.toDTO(director);

        Assertions.assertEquals(directorDTO.getDirectorId(), directorDTOMapper.getDirectorId(), MESSAGE_ERROR);
        Assertions.assertEquals(directorDTO.getFullName(), directorDTOMapper.getFullName(), MESSAGE_ERROR);
        //Assertions.assertEquals(directorDTO.getGamesDirected(), directorDTOMapper.getGamesDirected(), MESSAGE_ERROR);

        director.setGamesDirected(null);
        directorDTOMapper = IDirectorMapper.INSTANCE.toDTO(director);
        //  Assertions.assertNull(directorDTOMapper.getGamesDirected(), MESSAGE_ERROR);

        director = null;
        directorDTOMapper = IDirectorMapper.INSTANCE.toDTO(director);
        Assertions.assertNull(directorDTOMapper, MESSAGE_ERROR);
    }

    @Test
    public void toEntityTest(){
        directorEntityMapper = IDirectorMapper.INSTANCE.toEntity(directorDTO);

        Assertions.assertEquals(director.getDirectorId(), directorEntityMapper.getDirectorId(), MESSAGE_ERROR);
        Assertions.assertEquals(director.getFullName(), directorEntityMapper.getFullName(), MESSAGE_ERROR);
//        Assertions.assertEquals(director.getGamesDirected(), directorEntityMapper.getGamesDirected(), MESSAGE_ERROR);

        // directorDTO.setGamesDirected(null);
        directorEntityMapper = IDirectorMapper.INSTANCE.toEntity(directorDTO);
        Assertions.assertNull(directorEntityMapper.getGamesDirected(), MESSAGE_ERROR);

        directorDTO = null;
        directorEntityMapper = IDirectorMapper.INSTANCE.toEntity(directorDTO);
        Assertions.assertNull(directorEntityMapper, MESSAGE_ERROR);
    }
}
