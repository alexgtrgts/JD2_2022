package alekseev;

import entity.Car;
import service.CarDAOImpl;
import util.Util;

import java.sql.*;

import static util.Util.*;
/*
Есть сущность Car, у нее есть индификатор, название, цвет, цена. Задание создать проект.
Добавление таблицы в базу сделать через liquibase,сделать тесты используя H2.
Покрыть функционал тестами и сделать отчет используя плагин jacoco.Подключить checkstyle
к проекту.Для сущности Car сделать DAO над каждым полем написать анотацию свою
MyColumn(name - название колонки) с названием колонки над классом Car написать анатацию
MyTable(name - название таблицы). Реализовать crud операции с Car используя jdbc
-select
-update
-delete
-insert
причем эти операции должны составлять запрос в базу используя анатации MyColumn и MyTable
(через рефлексию)т.е. если я создам другую сущность то
-select
-update
-delete
-insert должны работать без изменения внутреней логики
*/


public class App {
    public static void main(String[] args) {
        // добаление в базу
//        Car car = new Car("Volvo","green",8000);
//        CarDAOImpl cdi = new CarDAOImpl();
//        try {
//            cdi.create(car);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        // получение из базы
//        CarDAOImpl cdi = new CarDAOImpl();
//        try {
//            cdi.get(3);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

        // обновление в базе
//        Car car = new Car("Zaporozhets","white",500);
//        CarDAOImpl cdi = new CarDAOImpl();
//        try {
//            cdi.update(car, 3);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


//        CarDAOImpl cdi = new CarDAOImpl();
//        try {
//            cdi.delete(3);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }


    }
}
