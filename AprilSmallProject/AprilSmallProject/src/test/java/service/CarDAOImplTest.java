package service;

import entity.Car;
import junit.framework.TestCase;

import java.sql.*;

public class CarDAOImplTest {

    public void testCreate() {
        try {
            Connection conn = DriverManager.getConnection("" +
                    "jdbc:h2:mem:smallAprilProject");
            Car car = new Car(1, "Kia", "black", 3600);
            Statement statement = conn.createStatement();
            statement.execute("create schema lesson_8");
            statement.execute("create table car (id int not null primary key," +
                    "carname char(50),color char(50), price int)");
            String query = "insert into car(id,carname,color,price) values (?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, car.getId());
            ps.setString(2, car.getCarname());
            ps.setString(3, car.getColor());
            ps.setInt(4, car.getPrice());
            ps.executeUpdate();
            System.out.println("Запись добавлена!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void testGet() {
    }

    public void testUpdate() {
    }

    public void testDelete() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:h2:mem:smallAprilProject");
            Statement statement = conn.createStatement();
            statement.execute("create table car (id int not null primary key," +
                    "carname char(50),color char(50), price int)");
            String query = "delete from car where id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, 1);
            ps.executeUpdate();
            System.out.println("Запись удалена!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}