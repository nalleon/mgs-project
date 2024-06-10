package es.ies.puerto.mgs.project.mapper.struct;

import es.ies.puerto.mgs.project.dto.ArtistDTO;
import es.ies.puerto.mgs.project.model.entities.Artist;
import es.ies.puerto.mgs.project.utilities.MapperHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IArtistMapperTest extends MapperHelper {
    Artist artistEntityMapper;
    ArtistDTO artistDTOMapper;

    @Test
    public void toDTOTest(){
        artistDTOMapper = IArtistMapper.INSTANCE.toDTO(artist);

        Assertions.assertEquals(artistDTO.getArtistId(), artistDTOMapper.getArtistId(), MESSAGE_ERROR);
        Assertions.assertEquals(artistDTO.getFullName(), artistDTOMapper.getFullName(), MESSAGE_ERROR);
        Assertions.assertEquals(artistDTO.getCharactersDesigned(), artistDTOMapper.getCharactersDesigned(), MESSAGE_ERROR);

        artist.setCharactersDesigned(null);
        artistDTOMapper = IArtistMapper.INSTANCE.toDTO(artist);
        Assertions.assertNull(artistDTOMapper.getCharactersDesigned(), MESSAGE_ERROR);

        artist = null;
        artistDTOMapper = IArtistMapper.INSTANCE.toDTO(artist);
        Assertions.assertNull(artistDTOMapper, MESSAGE_ERROR);
    }

    @Test
    public void toEntityTest(){
        artistEntityMapper = IArtistMapper.INSTANCE.toEntity(artistDTO);

        Assertions.assertEquals(artist.getArtistId(), artistEntityMapper.getArtistId(), MESSAGE_ERROR);
        Assertions.assertEquals(artist.getFullName(), artistEntityMapper.getFullName(), MESSAGE_ERROR);
        Assertions.assertEquals(artist.getCharactersDesigned(), artistEntityMapper.getCharactersDesigned(), MESSAGE_ERROR);

        artistDTO.setCharactersDesigned(null);
        artistEntityMapper = IArtistMapper.INSTANCE.toEntity(artistDTO);
        Assertions.assertNull(artistEntityMapper.getCharactersDesigned(), MESSAGE_ERROR);

        artistDTO = null;
        artistEntityMapper = IArtistMapper.INSTANCE.toEntity(artistDTO);
        Assertions.assertNull(artistEntityMapper, MESSAGE_ERROR);
    }
}
