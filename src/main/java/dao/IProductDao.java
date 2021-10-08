package dao;

import java.util.List;

public interface IProductDao<T> {
    List<T> getAll();

    boolean delete (int id);

    boolean update (int id , T t);

    boolean add (T t);

    T findById (int id);

    List<T> findByName(String searchName);
}
