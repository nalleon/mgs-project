package es.ies.puerto.mgs.project.mapper.struc;

import es.ies.puerto.mgs.project.dto.ArtistDTO;
import es.ies.puerto.mgs.project.dto.DirectorDTO;
import es.ies.puerto.mgs.project.model.entities.Artist;
import es.ies.puerto.mgs.project.model.entities.Director;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
/**
 * @author nalleon
 */
@Mapper(uses = IMGSCharacterMapper.class)
public interface IArtistMapper {
    IArtistMapper INSTANCE = Mappers.getMapper(IArtistMapper.class);
    Artist toEntity(ArtistDTO artistDTO);
    ArtistDTO toDTO(Artist artist);
}
