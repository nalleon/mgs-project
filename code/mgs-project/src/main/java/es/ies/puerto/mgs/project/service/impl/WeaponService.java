package es.ies.puerto.mgs.project.service.impl;

import es.ies.puerto.mgs.project.dto.WeaponDTO;
import es.ies.puerto.mgs.project.mapper.struc.IWeaponMapper;
import es.ies.puerto.mgs.project.model.db.mongo.dao.IDaoWeapon;
import es.ies.puerto.mgs.project.model.entities.Weapon;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

@Service
public class WeaponService implements IService<WeaponDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(WeaponService.class);

    private IDaoWeapon iDaoWeapon;

    /**
     * Default constructor of the class
     */
    public WeaponService (){}

    /**
     * Setter of the dao
     * @param iDaoWeapon
     */

    public void setiDaoWeapon(IDaoWeapon iDaoWeapon) {
        this.iDaoWeapon = iDaoWeapon;
    }

    @Override
    public void add(WeaponDTO weaponDTO) {
        iDaoWeapon.insert(IWeaponMapper.INSTANCE.toEntity(weaponDTO));
    }

    @Override
    public void update(WeaponDTO weaponDTO) {
        Weapon weapon = iDaoWeapon.findById(weaponDTO.getId()).orElseThrow(
                () -> new RuntimeException("Can not find by ID (name)")
        );
        iDaoWeapon.save(weapon);
    }

    @Override
    public List<WeaponDTO> getAll() {
        List<Weapon> weapons = iDaoWeapon.findAll();
        List<WeaponDTO> weaponDTOS = new ArrayList<>();
        for (Weapon weapon : weapons){
            weaponDTOS.add(IWeaponMapper.INSTANCE.toDTO(weapon));
        }
        return weaponDTOS;
    }

    @Override
    public WeaponDTO getById(int id) {
        Weapon weapon = iDaoWeapon.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find by ID")
        );
        return IWeaponMapper.INSTANCE.toDTO(weapon);
    }

    @Override
    public void delete(int id) {
        Weapon weapon = iDaoWeapon.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find by ID"));
        iDaoWeapon.delete(weapon);
    }
}
