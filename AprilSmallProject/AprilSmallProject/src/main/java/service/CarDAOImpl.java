package service;

import dao.CarDAO;
import dao.DAO;
import entity.Car;
import util.Util;

import java.io.Serializable;
import java.sql.*;

import static util.Util.*;

public class CarDAOImpl implements DAO<Car> {

    @Override
    public void create(Car car) throws SQLException {

        try (Connection conn = DriverManager.getConnection(Util.getValue(URL_KEY),
                Util.getValue(USER_KEY), Util.getValue(PASSWORD_KEY))) {
            String query = "insert into car(id,carname,color,price) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1,car.getId());
            ps.setString(2, car.getCarname());
            ps.setString(3, car.getColor());
            ps.setInt(4, car.getPrice());
            ps.executeUpdate();
            System.out.println("Запись добавлена!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void get(Integer id) throws SQLException {
        try (Connection conn = DriverManager.getConnection(Util.getValue(URL_KEY),
                Util.getValue(USER_KEY), Util.getValue(PASSWORD_KEY))) {
            String query = "select id,car_name, color, price from car where id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, 3);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println(" " + rs.getInt(1) + "  " + rs.getString(2)
                        + "  " + rs.getString(3) + "  " + rs.getString(4));
            }
            System.out.println("Выведена запись с номером " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(Car car, Integer id) throws SQLException {
        try (Connection conn = DriverManager.getConnection(Util.getValue(URL_KEY),
                Util.getValue(USER_KEY), Util.getValue(PASSWORD_KEY))) {
            String query = "update car set car_name = ? ,color = ?,price = ? where id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, car.getCarname());
            ps.setString(2, car.getColor());
            ps.setInt(3, car.getPrice());
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("Запись обновлена!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Connection conn = DriverManager.getConnection(Util.getValue(URL_KEY),
                Util.getValue(USER_KEY), Util.getValue(PASSWORD_KEY))) {
            String query = "delete from car where id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Запись удалена!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
