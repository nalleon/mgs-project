package es.ies.puerto.mgs.project.service.impl;

import es.ies.puerto.mgs.project.dto.RoleDTO;
import es.ies.puerto.mgs.project.mapper.struct.IRoleMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoRole;
import es.ies.puerto.mgs.project.model.entities.Role;
import es.ies.puerto.mgs.project.service.interfaces.IServiceJPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author nalleon
 */
@Component
public class RoleService implements IServiceJPA<RoleDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(RoleService.class);

    private IDaoRole iDaoRole;

    /**
     * Default constructor of the class
     */
    public RoleService(){}

    /**
     * Setter of the dao
     * @param iDaoRole
     */
    @Autowired
    public void setIDaoRole(IDaoRole iDaoRole) {
        this.iDaoRole = iDaoRole;
    }

    @Override
    public boolean addUpdate(RoleDTO roleDTO) {
        if (roleDTO == null){
            return false;
        }
        iDaoRole.save(IRoleMapper.INSTANCE.toEntity(roleDTO));
        return true;
    }


    @Override
    public List<RoleDTO> getAll() {
        List<Role> roles = iDaoRole.findAll();
        List<RoleDTO> roleDTOS = new ArrayList<>();
        for (Role role : roles){
            roleDTOS.add(IRoleMapper.INSTANCE.toDTO(role));
        }
        return roleDTOS;
    }

    @Override
    public RoleDTO getById(int id) {
        if (!iDaoRole.existsById(id)) {
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
        if (!iDaoRole.existsById(id)) {
            return false;
        }
        iDaoRole.deleteById(id);
        return true;
    }
}
