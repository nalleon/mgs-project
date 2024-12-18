package es.ies.puerto.mgs.project.service.impl;

import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
import es.ies.puerto.mgs.project.dto.WeaponDTO;
import es.ies.puerto.mgs.project.mapper.struct.IDirectorMapper;
import es.ies.puerto.mgs.project.mapper.struct.IMGSCharacterMapper;
import es.ies.puerto.mgs.project.mapper.struct.IWeaponMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoMGSCharacter;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;
import es.ies.puerto.mgs.project.service.interfaces.IServiceJPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author nalleon
 */
@Component
public class MGSCharacterService implements IServiceJPA<MGSCharacterDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(MGSCharacterService.class);

    private IDaoMGSCharacter iDaoMGSCharacter;

    /**
     * Default constructor of the class
     */
    public MGSCharacterService(){}

    /**
     * Setter of the dao
     * @param iDaoMGSCharacter
     */
    @Autowired
    public void setiDaoMGSCharacter(IDaoMGSCharacter iDaoMGSCharacter) {
        this.iDaoMGSCharacter = iDaoMGSCharacter;
    }

    @Override
    public boolean addUpdate(MGSCharacterDTO mgsCharacterDTO) {
        if (mgsCharacterDTO == null){
            return false;
        }
        iDaoMGSCharacter.save(IMGSCharacterMapper.INSTANCE.toEntity(mgsCharacterDTO));
        return true;
    }


    @Override
    public List<MGSCharacterDTO> getAll() {
        List<MGSCharacter> mgsCharacters = iDaoMGSCharacter.findAll();
        List<MGSCharacterDTO> mgsCharacterDTOS = new ArrayList<>();
        for (MGSCharacter mgsCharacter : mgsCharacters){
            mgsCharacterDTOS.add(IMGSCharacterMapper.INSTANCE.toDTO(mgsCharacter));
        }
        return mgsCharacterDTOS;
    }

    @Override
    public MGSCharacterDTO getById(int id) {
        if (!iDaoMGSCharacter.existsById(id)) {
            return null;
        }

        MGSCharacterDTO result = null;

        List<MGSCharacterDTO> list = getAll();

        for (MGSCharacterDTO mgsCharacterDTO: list){
            if (mgsCharacterDTO.getId() == id){
                result = mgsCharacterDTO;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        if (!iDaoMGSCharacter.existsById(id)) {
            return false;
        }
        iDaoMGSCharacter.deleteById(id);
        return true;

    }
}
