package es.ies.puerto.mgs.project.service.rest.impl;

import es.ies.puerto.mgs.project.dto.RoleDTO;
import es.ies.puerto.mgs.project.mapper.struct.IRoleMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoRole;
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
@Transactional()
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
        repository.save(IRoleMapper.INSTANCE.toEntity(roleDTO));
        return true;
    }

    @Override
    public boolean update(int id, RoleDTO roleDTO) throws Exception {
        try {
            Role toUpdate = repository.findById(id).orElseThrow(() ->
                    new Exception("Element not found for this id :: " + id));

            Role aux = IRoleMapper.INSTANCE.toEntity(roleDTO);
            toUpdate.setName(aux.getName());
            repository.save(toUpdate);
            return true;

        } catch (Exception e){
            return false;
        }
    }


    @Override
    public List<RoleDTO> getAll() {
        List<Role> roles = repository.findAll();
        List<RoleDTO> roleDTOS = new ArrayList<>();
        for (Role role : roles){
            roleDTOS.add(IRoleMapper.INSTANCE.toDTO(role));
        }
        return roleDTOS;
    }

    @Override
    public RoleDTO getById(int id) {
        if (!repository.existsById(id)) {
            return null;
        }

        RoleDTO result = null;

        List<RoleDTO> list = getAll();

        for (RoleDTO roleDTO: list){
            if (roleDTO.getId() == id){
                result = roleDTO;
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
