package repository.impl;

import entity.City;
import entity.Customer;
import entity.OrderShopping;
import entity.Product;
import repository.inter.CityInter;
import repository.inter.CustomerInter;
import repository.inter.OrderedInter;
import repository.inter.ProductInter;

import java.sql.*;
import java.time.LocalDate;
import java.util.List;

public class OrderedImpl implements OrderedInter {
    private static CustomerInter customerInter = new CustomerImpl();
    private static ProductInter productInter = new ProductImpl();
    String url = "jdbc:postgresql://localhost:5432/Shop";
    String username = "postgres";
    String password = "musa2003";
    @Override
    public void insert(OrderShopping orderShopping) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String sql = "insert into order(basket_id,total_price,fk_costumer_id,fk_product_id,order_date) \n" +
                    "values (" + orderShopping.getOrderId()+"," +orderShopping.getTotalPrice()+"," +orderShopping.getFkCustomerId()+"," + orderShopping.getFkProductId()
                    + ",'" + orderShopping.getOrderDate() + "')";
            System.out.println(sql);
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<OrderShopping> findByCustomerId(Customer customer) {
        List<OrderShopping> orderShoppings = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from order "+" where basket_id = "+customer.getCostId());
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {

                Integer id1 = resultSet.getInt(1);
                Double price = resultSet.getDouble(2);
                Integer customerId = resultSet.getInt(3);
                Customer customer1 =customerInter.findById(customerId);
                Integer productId = resultSet.getInt(4);
                Product product1 = productInter.findByid(productId);
                LocalDate localDate = resultSet.getDate(5).toLocalDate();

                orderShoppings.add(new OrderShopping(id1,price,customer1,product1,localDate));


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderShoppings;
    }

    @Override
    public OrderShopping findById(Integer id) {
        OrderShopping orderShopping = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from order "+" where basket_id = "+id);
            ResultSet resultSet = statement.getResultSet();

            while (resultSet.next()) {

                Integer id1 = resultSet.getInt(1);
                Double price = resultSet.getDouble(2);
                Integer customerId = resultSet.getInt(3);
                Customer customer1 =customerInter.findById(customerId);
                Integer productId = resultSet.getInt(4);
                Product product1 = productInter.findByid(productId);
                LocalDate localDate = resultSet.getDate(5).toLocalDate();

                orderShopping = new OrderShopping(id1,price,customer1,product1,localDate);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderShopping;
    }
}
