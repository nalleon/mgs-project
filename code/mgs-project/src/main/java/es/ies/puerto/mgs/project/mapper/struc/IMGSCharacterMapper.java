package es.ies.puerto.mgs.project.mapper.struc;

import es.ies.puerto.mgs.project.dto.CodenameDTO;
import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
import es.ies.puerto.mgs.project.model.entities.Codename;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
/**
 * @author nalleon
 */
@Mapper(uses = ICodenameMapper.class)
public interface IMGSCharacterMapper {
    IMGSCharacterMapper INSTANCE = Mappers.getMapper(IMGSCharacterMapper.class);
    MGSCharacter toEntity(MGSCharacterDTO mgsCharacterDTO);
    MGSCharacterDTO toDTO(MGSCharacter mgsCharacter);
}
