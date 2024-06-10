package es.ies.puerto.mgs.project.mapper.struct;

import es.ies.puerto.mgs.project.dto.GameDTO;
import es.ies.puerto.mgs.project.model.entities.Game;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
/**
 * @author nalleon
 */
@Mapper(uses = {IMGSCharacterMapper.class, IDirectorMapper.class})
public interface IGameMapper {
    IGameMapper INSTANCE = Mappers.getMapper(IGameMapper.class);
    Game toEntity(GameDTO gameDTO);
    GameDTO toDTO(Game game);
}
