package es.ies.puerto.mgs.project.mapper.struc;

import es.ies.puerto.mgs.project.dto.CodenameDTO;
import es.ies.puerto.mgs.project.model.entities.Codename;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
/**
 * @author nalleon
 */
@Mapper
public interface ICodenameMapper {
    ICodenameMapper INSTANCE = Mappers.getMapper(ICodenameMapper.class);
    Codename toEntity(CodenameDTO codenameDTO);
    CodenameDTO toDTO(Codename codename);
}
