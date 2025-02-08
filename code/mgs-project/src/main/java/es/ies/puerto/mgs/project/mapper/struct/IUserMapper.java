package es.ies.puerto.mgs.project.mapper.struct;

import es.ies.puerto.mgs.project.dto.user.UserDTO;
import es.ies.puerto.mgs.project.model.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
/**
 * @author nalleon
 */
@Mapper(uses = {IRoleMapper.class})
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    User toEntity(UserDTO userDTO);
    @Mapping(target = "password", ignore = true)
    UserDTO toDTO(User user);
}
