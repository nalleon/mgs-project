package es.ies.puerto.mgs.project.mapper.struct;

import es.ies.puerto.mgs.project.dto.outputs.RoleDTO;
import es.ies.puerto.mgs.project.model.entities.Role;
import es.ies.puerto.mgs.project.utilities.MapperHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IRoleMapperTest extends MapperHelper {
    Role artistEntityMapper;
    RoleDTO artistDTOMapper;

    @Test
    public void toDTOTest(){
        artistDTOMapper = IRoleMapper.INSTANCE.toDTO(role);

        Assertions.assertEquals(roleDTO.getId(), artistDTOMapper.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(roleDTO.getName(), artistDTOMapper.getName(), MESSAGE_ERROR);

        artistDTOMapper = IRoleMapper.INSTANCE.toDTO(role);

        role = null;
        artistDTOMapper = IRoleMapper.INSTANCE.toDTO(role);
        Assertions.assertNull(artistDTOMapper, MESSAGE_ERROR);
    }

    @Test
    public void toEntityTest(){
        artistEntityMapper = IRoleMapper.INSTANCE.toEntity(roleDTO);

        Assertions.assertEquals(role.getId(), artistEntityMapper.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(role.getName(), artistEntityMapper.getName(), MESSAGE_ERROR);


        roleDTO = null;
        artistEntityMapper = IRoleMapper.INSTANCE.toEntity(roleDTO);
        Assertions.assertNull(artistEntityMapper, MESSAGE_ERROR);
    }
}
