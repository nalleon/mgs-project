package es.ies.puerto.mgs.project.mapper.struct;

import es.ies.puerto.mgs.project.dto.UserDTO;
import es.ies.puerto.mgs.project.model.entities.User;
import es.ies.puerto.mgs.project.utilities.MapperHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IUserMapperTest extends MapperHelper {
    User userEntityMapper;
    UserDTO userDTOMapper;

    @Test
    public void toDTOTest(){
        userDTOMapper = IUserMapper.INSTANCE.toDTO(user);

        Assertions.assertEquals(userDTO.getId(), userDTOMapper.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(userDTO.getName(), userDTOMapper.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(userDTO.getEmail(), userDTOMapper.getEmail(), MESSAGE_ERROR);
        Assertions.assertNull(userDTOMapper.getPassword(), MESSAGE_ERROR);
        Assertions.assertEquals(userDTO.getRole(), userDTOMapper.getRole(), MESSAGE_ERROR);


        //user.setRole(null);
        //userDTOMapper = IUserMapper.INSTANCE.toDTO(user);
        //Assertions.assertNull(userDTOMapper.getRole(), MESSAGE_ERROR);

        user = null;
        userDTOMapper = IUserMapper.INSTANCE.toDTO(user);
        Assertions.assertNull(userDTOMapper, MESSAGE_ERROR);
    }

    @Test
    public void toEntityTest(){
        userEntityMapper = IUserMapper.INSTANCE.toEntity(userDTO);

        Assertions.assertEquals(user.getId(), userEntityMapper.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(user.getName(), userEntityMapper.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(user.getEmail(), userEntityMapper.getEmail(), MESSAGE_ERROR);
        Assertions.assertEquals(user.getPassword(), userEntityMapper.getPassword(), MESSAGE_ERROR);
        Assertions.assertEquals(user.getRole(), userEntityMapper.getRole(), MESSAGE_ERROR);

        // userDTO.setCharactersDesigned(null);
        //userEntityMapper = IUserMapper.INSTANCE.toEntity(userDTO);
        //Assertions.assertNull(userEntityMapper.getCharactersDesigned(), MESSAGE_ERROR);

        userDTO = null;
        userEntityMapper = IUserMapper.INSTANCE.toEntity(userDTO);
        Assertions.assertNull(userEntityMapper, MESSAGE_ERROR);
    }
}
