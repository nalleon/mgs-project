package es.ies.puerto.mgs.project.service.impl;

import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
import es.ies.puerto.mgs.project.mapper.struct.IMGSCharacterMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoMGSCharacter;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;
import es.ies.puerto.mgs.project.service.interfaces.IService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author nalleon
 */
@Service
public class MGSCharacterService implements IService<MGSCharacterDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(MGSCharacterService.class);

    private IDaoMGSCharacter iDaoMGSCharacter;

    /**
     * Default constructor of the class
     */
    public MGSCharacterService (){}

    /**
     * Setter of the dao
     * @param iDaoMGSCharacter
     */
    @Autowired
    public void setiDaoMGSCharacter(IDaoMGSCharacter iDaoMGSCharacter) {
        this.iDaoMGSCharacter = iDaoMGSCharacter;
    }

    @Override
    public void add(MGSCharacterDTO mgsCharacterDTO) {
        iDaoMGSCharacter.save(IMGSCharacterMapper.INSTANCE.toEntity(mgsCharacterDTO));
    }

    @Override
    public void update(MGSCharacterDTO mgsCharacterDTO) {
        MGSCharacter mgsCharacter = iDaoMGSCharacter.findById(mgsCharacterDTO.getId()).orElseThrow(
                () -> new RuntimeException("Can not find by ID (name)")
        );
        iDaoMGSCharacter.save(mgsCharacter);
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
        MGSCharacter mgsCharacter = iDaoMGSCharacter.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find by ID")
        );
        return IMGSCharacterMapper.INSTANCE.toDTO(mgsCharacter);

    }

    @Override
    public void delete(int id) {
        MGSCharacter mgsCharacter = iDaoMGSCharacter.findById(id).orElseThrow(
                () -> new RuntimeException("Cannot find by ID"));
        iDaoMGSCharacter.delete(mgsCharacter);
    }
}
