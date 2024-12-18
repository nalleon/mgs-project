package es.ies.puerto.mgs.project.mapper.struct;

import es.ies.puerto.mgs.project.dto.RoleDTO;
import es.ies.puerto.mgs.project.model.entities.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface IRoleMapper {
    IRoleMapper INSTANCE = Mappers.getMapper(IRoleMapper.class);

    Role toEntity(RoleDTO roleDTO);
    RoleDTO toDTO(Role role);
}
