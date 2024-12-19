package es.ies.puerto.mgs.project.service.interfaces;


import java.util.List;

public interface IServiceMongoDb <T> {
    public boolean add(T t);
    public boolean update(int id, T t);
    public List<T> getAll();
    public T getById(int id);
    public boolean delete(int id);
}
