package es.ies.puerto.mgs.project.service.impl;

import es.ies.puerto.mgs.project.dto.WeaponDTO;
import es.ies.puerto.mgs.project.mapper.struct.IDirectorMapper;
import es.ies.puerto.mgs.project.mapper.struct.IWeaponMapper;
import es.ies.puerto.mgs.project.model.db.mongo.dao.IDaoWeapon;
import es.ies.puerto.mgs.project.model.entities.Weapon;
import es.ies.puerto.mgs.project.service.interfaces.IServiceJPA;
import es.ies.puerto.mgs.project.service.interfaces.IServiceMongoDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;

@Component
public class WeaponService implements IServiceMongoDb<WeaponDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(WeaponService.class);

    private IDaoWeapon iDaoWeapon;

    /**
     * Default constructor of the class
     */
    public WeaponService(){}

    /**
     * Setter of the dao
     * @param iDaoWeapon
     */

    @Autowired
    public void setiDaoWeapon(IDaoWeapon iDaoWeapon) {
        this.iDaoWeapon = iDaoWeapon;
    }

    @Override
    public boolean add(WeaponDTO weaponDTO) {
        if (!iDaoWeapon.existsById(weaponDTO.getId())){
            iDaoWeapon.insert(IWeaponMapper.INSTANCE.toEntity(weaponDTO));
        } else{
            iDaoWeapon.save(IWeaponMapper.INSTANCE.toEntity(weaponDTO));
        }
        return true;
    }

    @Override
    public boolean update(WeaponDTO weaponDTO) {
        if (!iDaoWeapon.existsById(weaponDTO.getId())) {
            iDaoWeapon.insert(IWeaponMapper.INSTANCE.toEntity(weaponDTO));
        }

        iDaoWeapon.save(IWeaponMapper.INSTANCE.toEntity(weaponDTO));
        return true;
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
        if (!iDaoWeapon.existsById(id)) {
            return null;
        }

        WeaponDTO result = null;

        List<WeaponDTO> list = getAll();

        for (WeaponDTO weaponDTO: list){
            if (weaponDTO.getId() == id){
                result = weaponDTO;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        if (!iDaoWeapon.existsById(id)) {
            return false;
        }
        iDaoWeapon.deleteById(id);
        return true;
    }
}
