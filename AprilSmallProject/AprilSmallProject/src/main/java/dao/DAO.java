package dao;


import java.sql.SQLException;

public interface DAO <T> {

    void create(T t) throws SQLException;

    void get(Integer id) throws SQLException;

    void update(T t, Integer id) throws SQLException;

    void delete(Integer id) throws SQLException;
}
