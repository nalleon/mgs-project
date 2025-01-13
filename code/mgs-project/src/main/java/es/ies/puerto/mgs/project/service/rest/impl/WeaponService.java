package es.ies.puerto.mgs.project.service.rest.impl;

import es.ies.puerto.mgs.project.dto.WeaponDTO;
import es.ies.puerto.mgs.project.mapper.struct.IWeaponMapper;
import es.ies.puerto.mgs.project.model.db.mongo.dao.IDaoWeapon;
import es.ies.puerto.mgs.project.model.entities.Weapon;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
@Transactional()
public class WeaponService implements IService<WeaponDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(WeaponService.class);

    private IDaoWeapon repository;

    /**
     * Default constructor of the class
     */
    public WeaponService(){}

    /**
     * Setter of the dao
     * @param repository
     */

    @Autowired
    public void setDao(IDaoWeapon repository) {
        this.repository = repository;
    }

    @Override
    public boolean add(WeaponDTO weaponDTO) {
        if (!repository.existsById(weaponDTO.getId())){
            repository.insert(IWeaponMapper.INSTANCE.toEntity(weaponDTO));
        } else {
            repository.save(IWeaponMapper.INSTANCE.toEntity(weaponDTO));
        }
        return true;
    }

    @Override
    public boolean update(int id, WeaponDTO weaponDTO) {
        try {
            Weapon toUpdate = repository.findById(id).orElseThrow(() ->
                    new Exception("Element not found for this id :: " + id));

            Weapon aux = IWeaponMapper.INSTANCE.toEntity(weaponDTO);
            toUpdate.setName(aux.getName());
            toUpdate.setType(aux.getType());
            repository.save(toUpdate);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    @Override
    public List<WeaponDTO> getAll() {
        List<Weapon> weapons = repository.findAll();
        List<WeaponDTO> weaponDTOS = new ArrayList<>();
        for (Weapon weapon : weapons){
            weaponDTOS.add(IWeaponMapper.INSTANCE.toDTO(weapon));
        }
        return weaponDTOS;
    }

    @Override
    public WeaponDTO getById(int id) {
        if (!repository.existsById(id)) {
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
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}
