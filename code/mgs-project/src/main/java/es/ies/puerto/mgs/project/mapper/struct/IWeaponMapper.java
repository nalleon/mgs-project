package es.ies.puerto.mgs.project.mapper.struct;

import es.ies.puerto.mgs.project.dto.outputs.WeaponDTO;
import es.ies.puerto.mgs.project.model.entities.Weapon;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IWeaponMapper {
    IWeaponMapper INSTANCE = Mappers.getMapper(IWeaponMapper.class);
    Weapon toEntity(WeaponDTO weaponDTO);
    WeaponDTO toDTO(Weapon weapon);
}
