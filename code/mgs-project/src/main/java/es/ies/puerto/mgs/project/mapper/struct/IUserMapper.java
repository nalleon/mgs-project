package es.ies.puerto.mgs.project.mapper.struct;

import es.ies.puerto.mgs.project.dto.UserDTO;
import es.ies.puerto.mgs.project.model.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface IUserMapper {
    IUserMapper INSTANCE = Mappers.getMapper(IUserMapper.class);

    User toEntity(UserDTO userDTO);
    UserDTO toDTO(User user);
}