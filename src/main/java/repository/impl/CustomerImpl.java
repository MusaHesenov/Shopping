package repository.impl;

import entity.City;
import entity.Customer;
import entity.TypeShop;
import exception.ExceptionCustomerNotFound;
import repository.inter.CityInter;
import repository.inter.CustomerInter;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerImpl implements CustomerInter {

    String url = "jdbc:postgresql://localhost:5432/Shop";
    String username = "postgres";
    String password = "musa2003";

    @Override
    public void insert(Customer customer) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String sql = "insert into costumer(cost_id,username,email,cost_password,cost_name,cost_surname,cost_birthday,cost_money,adress,fk_city_id) \n" +
                    "values ("+customer.getCostId()+",'"+customer.getUsername()+"','"+customer.getEmail()+"',"+customer.getCostPassword()+",'"
                    +customer.getCostName()+"','"+customer.getCostSurname()+"','"+customer.getCostBirthday()+"',"+customer.getCostMoney()+",'"
                    +customer.getAdress()+"',"+customer.getFkCityId().getCityId()
                    +");";
            System.out.println(sql);
            statement.execute(sql);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Customer findById(Integer id) {
        Customer customer = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from costumer "+" where cost_id = "+id);
            ResultSet resultSet = statement.getResultSet();
            CityInter cityInter = new CityImpl();
            while (resultSet.next()) {

                Integer id1 = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String email = resultSet.getString(3);
                String costPassword = resultSet.getString(4);
                String costName = resultSet.getString(5);
                String costSurname = resultSet.getString(6);
                LocalDate costBirthday = resultSet.getDate(7).toLocalDate();
                Double costMoney = resultSet.getDouble(8);
                String adress = resultSet.getString(9);
                Integer fkCityId = resultSet.getInt(10);

                City city = cityInter.findByid(fkCityId);

                customer = new Customer(id1,username,email,costPassword,costName,costSurname,costBirthday,costMoney,adress,city);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer findByUserName(String name) throws ExceptionCustomerNotFound {
        Customer customer = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from costumer " + "where username = "+"'" + name +"'");
            ResultSet resultSet = statement.getResultSet();
            CityInter cityInter = new CityImpl();
            while (resultSet.next()) {

                Integer id1 = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String email = resultSet.getString(3);
                String costPassword = resultSet.getString(4);
                String costName = resultSet.getString(5);
                String costSurname = resultSet.getString(6);
                LocalDate costBirthday = resultSet.getDate(7).toLocalDate();
                Double costMoney = resultSet.getDouble(8);
                String adress = resultSet.getString(9);
                Integer fkCityId = resultSet.getInt(10);

                City city = cityInter.findByid(fkCityId);

                customer = new Customer(id1,username,email,costPassword,costName,costSurname,costBirthday,costMoney,adress,city);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(customer==null){
            throw new ExceptionCustomerNotFound("Customer not found");
        }
        return customer;
    }

    @Override
    public List<Customer> findByCity(City city) {
        List<Customer> customers = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from costumer "+" where fk_city_id = "+city.getCityId());
            ResultSet resultSet = statement.getResultSet();
            CityInter cityInter = new CityImpl();
            while (resultSet.next()) {

                Integer id1 = resultSet.getInt(1);
                String username = resultSet.getString(2);
                String email = resultSet.getString(3);
                String costPassword = resultSet.getString(4);
                String costName = resultSet.getString(5);
                String costSurname = resultSet.getString(6);
                LocalDate costBirthday = resultSet.getDate(7).toLocalDate();
                Double costMoney = resultSet.getDouble(8);
                String adress = resultSet.getString(9);
                Integer fkCityId = resultSet.getInt(10);

                City city1 = cityInter.findByid(fkCityId);

                customers.add(new Customer(id1,username,email,costPassword,costName,costSurname,costBirthday,costMoney,adress,city1));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }

    @Override
    public void update(Customer customer) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement("update costumer set cost_name = ? where cost_id = ?");
            preparedStatement.setString(1,customer.getCostName());
            preparedStatement.setInt(2,customer.getCostId());

            preparedStatement.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
