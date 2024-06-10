package es.ies.puerto.mgs.project.service.interfaces;
import java.util.List;
/**
 * @author nalleon
 */
public interface IServiceJPA<T> {
    public boolean add(T t);
    public boolean update(T t);
    public List<T> getAll();
    public T getById(int id);
    public boolean delete(int id);
}