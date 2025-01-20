package es.ies.puerto.mgs.project.service.rest.impl;

import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
import es.ies.puerto.mgs.project.mapper.struct.IGameMapper;
import es.ies.puerto.mgs.project.mapper.struct.IMGSCharacterMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoMGSCharacter;
import es.ies.puerto.mgs.project.model.entities.Artist;
import es.ies.puerto.mgs.project.model.entities.MGSCharacter;
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
     * @param repository of the service
     */
    @Autowired
    public void setDao(IDaoMGSCharacter repository) {
        this.repository = repository;
    }

    @Override
    public boolean add(MGSCharacterDTO mgsCharacterDTO) {
        if (mgsCharacterDTO == null){
            return false;
        }
        if(repository.existsById(mgsCharacterDTO.getId())){
            return false;
        }

        repository.save(IMGSCharacterMapper.INSTANCE.toEntity(mgsCharacterDTO));
        return true;
    }

    @Override
    public boolean update(int id, MGSCharacterDTO mgsCharacterDTO) throws Exception {
        try {
            MGSCharacter toUpdate = repository.findById(id).orElse(null);

            if(toUpdate!= null){
                MGSCharacter aux = IMGSCharacterMapper.INSTANCE.toEntity(mgsCharacterDTO);
                toUpdate.setCodename(aux.getCodename());
                toUpdate.setName(aux.getName());
                toUpdate.setAge(aux.getAge());
                toUpdate.setArtist(aux.getArtist());
                toUpdate.setStatus(aux.isStatus());
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
    public List<MGSCharacterDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(IMGSCharacterMapper.INSTANCE::toDTO)
                .toList();
    }

    @Override
    public MGSCharacterDTO getById(int id) {
        MGSCharacter result = repository.findById(id).orElse(null);;

        if(result != null) {
            return IMGSCharacterMapper.INSTANCE.toDTO(result);
        }

        return null;
    }

    @Override
    public boolean delete(int id) {
        int quantity = repository.deleteItemById(id);
        return quantity > 0;
    }
}
