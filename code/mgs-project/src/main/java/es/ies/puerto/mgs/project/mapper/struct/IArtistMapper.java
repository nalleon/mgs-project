package es.ies.puerto.mgs.project.mapper.struct;

import es.ies.puerto.mgs.project.dto.outputs.ArtistDTO;
import es.ies.puerto.mgs.project.model.entities.Artist;
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
