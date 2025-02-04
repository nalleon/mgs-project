package es.ies.puerto.mgs.project.mapper.struct;

import es.ies.puerto.mgs.project.dto.outputs.MGSCharacterDTO;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
/**
 * @author nalleon
 */
@Mapper
public interface IMGSCharacterMapper {
    IMGSCharacterMapper INSTANCE = Mappers.getMapper(IMGSCharacterMapper.class);
    MGSCharacter toEntity(MGSCharacterDTO mgsCharacterDTO);
    MGSCharacterDTO toDTO(MGSCharacter mgsCharacter);
}
