package es.ies.puerto.mgs.project.mapper.struc;

import es.ies.puerto.mgs.project.dto.DirectorDTO;
import es.ies.puerto.mgs.project.dto.GameDTO;
import es.ies.puerto.mgs.project.model.entities.Director;
import es.ies.puerto.mgs.project.model.entities.Game;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
/**
 * @author nalleon
 */
@Mapper(uses = IGameMapper.class)
public interface IDirectorMapper {
    IDirectorMapper INSTANCE = Mappers.getMapper(IDirectorMapper.class);
    Director toEntity(DirectorDTO directorDTO);
    DirectorDTO toDTO(Director director);
}
