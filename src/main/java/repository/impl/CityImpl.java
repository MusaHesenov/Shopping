package repository.impl;

import entity.City;
import repository.inter.CityInter;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CityImpl implements CityInter {

    String url = "jdbc:postgresql://localhost:5432/Shop";
    String username = "postgres";
    String password = "musa2003";

    @Override
    public void delete(Integer id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();

            statement.execute("delete from city " +
                    "where city_id = " + id + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insert(City city) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            statement.execute(" insert into city(city_id,city_name) \n" +
                    " values(" + city.getCityId() + ",'" + city.getCityName() + "');");//insert into (city_id,city_name) values (1,'Baku');
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(City city) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
                PreparedStatement preparedStatement = connection.prepareStatement("update city set city_name = ? where city_id = ?");
                preparedStatement.setString(1,city.getCityName());
                preparedStatement.setInt(2,city.getCityId());
                preparedStatement.execute();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
    

    @Override
    public List<City> findAll() {
        List<City> List = new ArrayList<>();
        java.util.List<City> list;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from city");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                City city = new City(id, name);
                List.add(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return List;
    }

    @Override
    public City findByid(Integer id) {
        //SUAL 1
        City city = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from city "+" where city_id = "+id);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {

                    Integer id1 = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    city = new City(id1, name);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }

    @Override
    public City findByName(String name) {
        City city = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from city " + "where city_name = " + name);
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {

                    Integer id = resultSet.getInt(1);
                    String name1 = resultSet.getString(2);
                    city = new City(id, name1);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return city;
    }
}
