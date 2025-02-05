package es.ies.puerto.mgs.project.mapper.struct;

import es.ies.puerto.mgs.project.dto.outputs.WeaponDTO;
import es.ies.puerto.mgs.project.model.documents.Weapon;
import es.ies.puerto.mgs.project.utilities.MapperHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class IWeaponMapperTest extends MapperHelper {
    Weapon weaponEntityMapper;
    WeaponDTO weaponDTOMapper;

    @Test
    public void toDTOTest(){
        weaponDTOMapper = IWeaponMapper.INSTANCE.toDTO(weapon);

        Assertions.assertEquals(weaponDTO.getId(), weaponDTOMapper.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(weaponDTO.getName(), weaponDTOMapper.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(weaponDTO.getType(), weaponDTOMapper.getType(), MESSAGE_ERROR);

        weapon = null;
        weaponDTOMapper = IWeaponMapper.INSTANCE.toDTO(weapon);
        Assertions.assertNull(weaponDTOMapper, MESSAGE_ERROR);
    }

    @Test
    public void toEntityTest(){
        weaponEntityMapper = IWeaponMapper.INSTANCE.toEntity(weaponDTO);

        Assertions.assertEquals(weapon.getId(), weaponEntityMapper.getId(), MESSAGE_ERROR);
        Assertions.assertEquals(weapon.getName(), weaponEntityMapper.getName(), MESSAGE_ERROR);
        Assertions.assertEquals(weapon.getType(), weaponEntityMapper.getType(), MESSAGE_ERROR);

        weaponDTO = null;
        weaponEntityMapper = IWeaponMapper.INSTANCE.toEntity(weaponDTO);
        Assertions.assertNull(weaponEntityMapper, MESSAGE_ERROR);
    }
}
