package DAO;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

    public void create(T t) throws SQLException, ClassNotFoundException;

    public T read(Serializable id) throws SQLException, ClassNotFoundException;

    public List<T> listAll() throws SQLException, ClassNotFoundException;

    public T update(T t) throws SQLException, ClassNotFoundException;

    public void delete(T t) throws SQLException, ClassNotFoundException;
}
