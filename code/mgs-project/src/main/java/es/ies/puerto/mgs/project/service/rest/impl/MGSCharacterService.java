package es.ies.puerto.mgs.project.service.rest.impl;

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

import org.springframework.stereotype.Component;

/**
 * @author nalleon
 */
@Component
public class MGSCharacterService implements IService<MGSCharacterDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(MGSCharacterService.class);

    private IDaoMGSCharacter repository;

    /**
     * Default constructor of the class
     */
    public MGSCharacterService(){}

    /**
     * Setter of the dao
     * @param repository
     */
    @Autowired
    public void setiDaoMGSCharacter(IDaoMGSCharacter repository) {
        this.repository = repository;
    }

    @Override
    public boolean add(MGSCharacterDTO mgsCharacterDTO) {
        if (mgsCharacterDTO == null){
            return false;
        }
        repository.save(IMGSCharacterMapper.INSTANCE.toEntity(mgsCharacterDTO));
        return true;
    }

    @Override
    public boolean update(int id, MGSCharacterDTO mgsCharacterDTO) throws Exception {
        try {
            MGSCharacter toUpdate = repository.findById(id).orElseThrow(() ->
                    new Exception("Element not found for this id :: " + id));

            MGSCharacter aux = IMGSCharacterMapper.INSTANCE.toEntity(mgsCharacterDTO);
            toUpdate.setCodename(aux.getCodename());
            toUpdate.setName(aux.getName());
            toUpdate.setAge(aux.getAge());
            toUpdate.setArtist(aux.getArtist());
            toUpdate.setStatus(aux.isStatus());
            repository.save(toUpdate);
            return true;

        } catch (Exception e){
            return false;
        }
    }


    @Override
    public List<MGSCharacterDTO> getAll() {
        List<MGSCharacter> mgsCharacters = repository.findAll();
        List<MGSCharacterDTO> mgsCharacterDTOS = new ArrayList<>();
        for (MGSCharacter mgsCharacter : mgsCharacters){
            mgsCharacterDTOS.add(IMGSCharacterMapper.INSTANCE.toDTO(mgsCharacter));
        }
        return mgsCharacterDTOS;
    }

    @Override
    public MGSCharacterDTO getById(int id) {
        if (!repository.existsById(id)) {
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
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;

    }
}
