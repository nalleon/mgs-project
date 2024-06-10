package es.ies.puerto.mgs.project.mapper.struct;

import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;
import es.ies.puerto.mgs.project.utilities.MapperHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IMGSCharacterMapperTest extends MapperHelper {
    MGSCharacter mgsCharacterEntityMapper;
    MGSCharacterDTO mgsCharacterDTOMapper;

    @Test
    public void toDTOTest(){
        mgsCharacterDTOMapper = IMGSCharacterMapper.INSTANCE.toDTO(mgsCharacter);

        Assertions.assertEquals(mgsCharacterDTO.getId(), mgsCharacterDTOMapper.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacterDTO.getName(), mgsCharacterDTOMapper.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacterDTO.getCodename(), mgsCharacterDTOMapper.getCodename(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacterDTO.getAge(), mgsCharacterDTOMapper.getAge(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacterDTO.isStatus(), mgsCharacterDTOMapper.isStatus(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacterDTO.getArtist(), mgsCharacterDTOMapper.getArtist(), MESSAGE_ERROR);

        mgsCharacter = null;
        mgsCharacterDTOMapper = IMGSCharacterMapper.INSTANCE.toDTO(mgsCharacter);
        Assertions.assertNull(mgsCharacterDTOMapper, MESSAGE_ERROR);
    }

    @Test
    public void toEntityTest(){
        mgsCharacterEntityMapper = IMGSCharacterMapper.INSTANCE.toEntity(mgsCharacterDTO);

        Assertions.assertEquals(mgsCharacter.getId(), mgsCharacterEntityMapper.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacter.getName(), mgsCharacterEntityMapper.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacter.getCodename(), mgsCharacterEntityMapper.getCodename(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacter.getAge(), mgsCharacterEntityMapper.getAge(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacter.isStatus(), mgsCharacterEntityMapper.isStatus(), MESSAGE_ERROR);
        Assertions.assertEquals(mgsCharacter.getArtist(), mgsCharacterEntityMapper.getArtist(), MESSAGE_ERROR);

        mgsCharacterDTO = null;
        mgsCharacterEntityMapper = IMGSCharacterMapper.INSTANCE.toEntity(mgsCharacterDTO);
        Assertions.assertNull(mgsCharacterEntityMapper, MESSAGE_ERROR);


    }
}
