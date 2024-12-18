package es.ies.puerto.mgs.project.service.impl;
import es.ies.puerto.mgs.project.dto.ArtistDTO;
import es.ies.puerto.mgs.project.dto.MGSCharacterDTO;
import es.ies.puerto.mgs.project.mapper.struct.IArtistMapper;
import es.ies.puerto.mgs.project.model.db.jpa.dao.IDaoArtist;
import es.ies.puerto.mgs.project.model.entities.Artist;
import es.ies.puerto.mgs.project.service.interfaces.IServiceJPA;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nalleon
 */
@Component
public class ArtistService implements IServiceJPA<ArtistDTO> {
    /**
     * Properties
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(ArtistService.class);

    private IDaoArtist iDaoArtist;

    /**
     * Default constructor of the class
     */
    public ArtistService(){}

    /**
     * Setter of the dao
     * @param iDaoArtist
     */
    @Autowired
    public void setiDaoArtist(IDaoArtist iDaoArtist) {
        this.iDaoArtist = iDaoArtist;
    }

    @Override
    public boolean addUpdate(ArtistDTO artistDTO) {
        if (artistDTO == null){
            return false;
        }
        iDaoArtist.save(IArtistMapper.INSTANCE.toEntity(artistDTO));
        return true;
    }


    @Override
    public List<ArtistDTO> getAll() {
        List<Artist> artists = iDaoArtist.findAll();
        List<ArtistDTO> artistDTOS = new ArrayList<>();
        for (Artist artist : artists){
            artistDTOS.add(IArtistMapper.INSTANCE.toDTO(artist));
        }
        return artistDTOS;
    }

    @Override
    public ArtistDTO getById(int id) {
        if (!iDaoArtist.existsById(id)) {
            return null;
        }

        ArtistDTO result = null;

        List<ArtistDTO> list = getAll();

        for (ArtistDTO artistDTO: list){
            if (artistDTO.getArtistId() == id){
                result = artistDTO;
                break;
            }
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        if (!iDaoArtist.existsById(id)) {
            return false;
        }
        iDaoArtist.deleteById(id);
        return true;
    }
}
