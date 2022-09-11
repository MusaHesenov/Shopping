package repository.impl;

import entity.City;
import entity.Customer;
import entity.Product;
import entity.TypeShop;
import repository.inter.CityInter;
import repository.inter.ProductInter;
import repository.inter.TypeShopInter;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductImpl implements ProductInter {

    String url = "jdbc:postgresql://localhost:5432/Shop";
    String username = "postgres";
    String password = "musa2003";

    @Override
    public void insert(Product product) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            String sql = "insert into product(product_id,product_name,product_count,expired_date,price,fk_product_type_id) \n" +
                    "values (" + product.getProductId() + ",'" + product.getProductName() + "'," + product.getProductCount() + ",'" + product.getExpiredDate() + "'," + product.getPrice() + "," +
                    product.getFkProductTypeId() + ")";
            System.out.println(sql);
            statement.execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product findByid(Integer id) {
        Product product = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from product " + " where product_id = " + id);
            ResultSet resultSet = statement.getResultSet();
            TypeShopInter typeShopInter = new TypeShopImpl();
            while (resultSet.next()) {
                Integer id1 = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                Integer productCount = resultSet.getInt(3);
                LocalDate expiredDate = resultSet.getDate(4).toLocalDate();
                Double price = resultSet.getDouble(5);
                Integer fkProductTypeId = resultSet.getInt(6);

                TypeShop typeShop = typeShopInter.findById(fkProductTypeId);

                product = new Product(id1, productName, productCount, expiredDate, price, typeShop);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }


    @Override
    public Product findByName(String name) {
        Product product = null;
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from product " + "where product_name = " + name);
            ResultSet resultSet = statement.getResultSet();
            TypeShopInter typeShopInter = null;
            while (resultSet.next()) {

                Integer id1 = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                Integer productCount = resultSet.getInt(3);
                LocalDate expiredDate = resultSet.getDate(4).toLocalDate();
                Double price = resultSet.getDouble(5);
                Integer fkProductTypeId = resultSet.getInt(6);

                TypeShop typeShop = typeShopInter.findById(fkProductTypeId);

                product = new Product(id1, productName, productCount, expiredDate, price, typeShop);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> list = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from product");
            ResultSet resultSet = statement.getResultSet();
            TypeShopInter typeShopInter = null;
            while (resultSet.next()) {
                Integer id1 = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                Integer productCount = resultSet.getInt(3);
                LocalDate expiredDate = resultSet.getDate(4).toLocalDate();
                Double price = resultSet.getDouble(5);
                Integer fkProductTypeId = resultSet.getInt(6);

                TypeShop typeShop = typeShopInter.findById(fkProductTypeId);

                Product product = new Product(id1, productName, productCount, expiredDate, price, typeShop);
                list.add(product);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public List<Product> findTypeShop(TypeShop typeShop) {
        List<Product> list = new ArrayList<>();
        try(Connection connection= DriverManager.getConnection(url,username,password)) {
            Statement statement = connection.createStatement();
            statement.execute("select * from product where fk_product_type_id ="+typeShop.getTypeId()+"; ");
            ResultSet resultSet = statement.getResultSet();
            TypeShopInter typeShopInter = new TypeShopImpl();
            while (resultSet.next()){
                Integer id1 = resultSet.getInt(1);
                String productName = resultSet.getString(2);
                Integer productCount = resultSet.getInt(3);
                LocalDate expiredDate = resultSet.getDate(4).toLocalDate();
                Double price = resultSet.getDouble(5);
                Integer fkProductTypeId = resultSet.getInt(6);

                TypeShop typeShop1 = typeShopInter.findById(fkProductTypeId);

                Product product = new Product(id1, productName, productCount, expiredDate, price, typeShop1 );
                list.add(product);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public void update(Product product) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement("update product set product_name = ? where product_id = ?");
            preparedStatement.setString(1, product.getProductName());
            preparedStatement.setInt(2, product.getProductId());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            Statement statement = connection.createStatement();
            statement.execute("delete from product " +
                    "where product_id = " + id + ";");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
