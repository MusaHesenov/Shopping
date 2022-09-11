package repository.impl;

import entity.City;
import entity.TypeShop;
import repository.inter.TypeShopInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TypeShopImpl implements TypeShopInter {

    String url = "jdbc:postgresql://localhost:5432/Shop";
    String username = "postgres";
    String password = "musa2003";

    @Override
    public void insert(TypeShop typeShop) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            statement.execute(" insert into type_shop(type_id,type_name) \n" +
                    " values(" + typeShop.getTypeId() + ",'" + typeShop.getTypeName() + "');");//insert into (city_id,city_name) values (1,'Baku');
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<TypeShop> findAll() {
        List<TypeShop> List = new ArrayList<>();
        java.util.List<City> list;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from type_shop");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                TypeShop typeShop = new TypeShop(id,name);
                List.add(typeShop);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List;
    }

    @Override
    public TypeShop findById(Integer id) {
        TypeShop typeShop = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from type_shop "+" where type_id = "+id);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {

                Integer id1 = resultSet.getInt(1);
                String name = resultSet.getString(2);
                typeShop = new TypeShop(id1, name);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeShop;
    }

    @Override
    public TypeShop findByName(String name) {
        TypeShop typeShop = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from type_shop " + "where type_name = " + name);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {

                Integer id = resultSet.getInt(1);
                String name1 = resultSet.getString(2);
                typeShop = new TypeShop(id, name1);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typeShop;
    }
}
