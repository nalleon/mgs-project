package es.ies.puerto.mgs.project.mapper.struct;

import es.ies.puerto.mgs.project.dto.outputs.GameDTO;
import es.ies.puerto.mgs.project.model.entities.Game;
import es.ies.puerto.mgs.project.utilities.MapperHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IGameMapperTest extends MapperHelper {
    Game gameEntityMapper;
    GameDTO gameDTOMapper;

    @Test
    public void toDTOTest(){
        gameDTOMapper = IGameMapper.INSTANCE.toDTO(game);

        Assertions.assertEquals(gameDTO.getId(), gameDTOMapper.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(gameDTO.getName(), gameDTOMapper.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(gameDTO.getGameCharacters(), gameDTOMapper.getGameCharacters(), MESSAGE_ERROR);

        game.setGameCharacters(null);
        gameDTOMapper = IGameMapper.INSTANCE.toDTO(game);
        Assertions.assertNull(gameDTOMapper.getGameCharacters(), MESSAGE_ERROR);

        game = null;
        gameDTOMapper = IGameMapper.INSTANCE.toDTO(game);
        Assertions.assertNull(gameDTOMapper, MESSAGE_ERROR);
    }

    @Test
    public void toEntityTest(){
        gameEntityMapper = IGameMapper.INSTANCE.toEntity(gameDTO);

        Assertions.assertEquals(game.getId(), gameEntityMapper.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(game.getName(), gameEntityMapper.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(game.getGameCharacters(), gameEntityMapper.getGameCharacters(), MESSAGE_ERROR);

        gameDTO.setGameCharacters(null);
        gameEntityMapper = IGameMapper.INSTANCE.toEntity(gameDTO);
        Assertions.assertNull(gameEntityMapper.getGameCharacters(), MESSAGE_ERROR);

        gameDTO = null;
        gameEntityMapper = IGameMapper.INSTANCE.toEntity(gameDTO);
        Assertions.assertNull(gameEntityMapper, MESSAGE_ERROR);
    }
}
