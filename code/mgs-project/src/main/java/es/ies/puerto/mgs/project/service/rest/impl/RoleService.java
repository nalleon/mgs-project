package es.ies.puerto.mgs.project.service.rest.impl;

import es.ies.puerto.mgs.project.dto.RoleDTO;
import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
import es.ies.puerto.mgs.project.mapper.struct.IMGSCharacterMapper;
import es.ies.puerto.mgs.project.mapper.struct.IRoleMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoRole;
import es.ies.puerto.mgs.project.model.entities.Artist;
import es.ies.puerto.mgs.project.model.entities.Role;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author nalleon
 */
@Component
@Transactional
public class RoleService implements IService<RoleDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(RoleService.class);

    private IDaoRole repository;

    /**
     * Default constructor of the class
     */
    public RoleService(){}

    /**
     * Setter of the dao
     * @param repository
     */
    @Autowired
    public void setDao(IDaoRole repository) {
        this.repository = repository;
    }

    @Override
    public boolean add(RoleDTO roleDTO) {
        if (roleDTO == null){
            return false;
        }
        if(repository.existsById(roleDTO.getId())){
            return false;
        }

        repository.save(IRoleMapper.INSTANCE.toEntity(roleDTO));
        return true;
    }

    @Override
    public boolean update(int id, RoleDTO roleDTO) throws Exception {
        try {
            Role toUpdate = repository.findById(id).orElse(null);

            if(toUpdate!= null){
                toUpdate.setName(roleDTO.getName());
                repository.save(toUpdate);
                return true;
            } else {
                return false;
            }

        } catch (RuntimeException e){
            return false;
        }
    }


    @Override
    public List<RoleDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(IRoleMapper.INSTANCE::toDTO)
                .toList();
    }

    @Override
    public RoleDTO getById(int id) {
        Role result = repository.findById(id).orElse(null);;

        if(result != null) {
            return IRoleMapper.INSTANCE.toDTO(result);
        }

        return null;
    }

    @Override
    public boolean delete(int id) {
        int quantity = repository.deleteItemById(id);
        return quantity > 0;
    }
}
