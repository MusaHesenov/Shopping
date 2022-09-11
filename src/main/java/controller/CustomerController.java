package controller;

import entity.City;
import entity.Customer;
import exception.ExceptionCustomerNotFound;
import repository.impl.CustomerImpl;
import service.impl.CityServiceImpl;
import service.impl.CustomerServiceImpl;
import service.inter.CityServiceInter;
import service.inter.CustomerServiceInter;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import repository.inter.CustomerInter;

public class CustomerController {
    private static Scanner scanner = new Scanner(System.in);
    private static CityServiceInter cityServiceInter = new CityServiceImpl();
    private static CustomerServiceInter customerServiceInter = new CustomerServiceImpl();
    CustomerInter customerInter = new CustomerImpl();

    public void signUp() {
        System.out.println("Enter id");
        Integer id = scanner.nextInt();
        System.out.println("Enter username");
        String username = scanner.next();
        System.out.println("Enter password");
        String password = scanner.next();
        System.out.println("Enter name");
        String name = scanner.next();
        System.out.println("Enter surname");
        String surname = scanner.next();
        System.out.println("Enter birthday");
        String birthdayString = scanner.next();
        LocalDate birthday = LocalDate.parse(birthdayString);
        System.out.println("Enter email");
        String email = scanner.next();
        System.out.println("Enter money");
        Double money = scanner.nextDouble();
        System.out.println("Enter address");
        String address = scanner.next();
        System.out.println("Select city");
        List<City> cities = cityServiceInter.showAll();

        for (int i = 0; i < cities.size(); i++) {
            System.out.println("     " + cities.get(i));
        }

        int operation = scanner.nextInt();
        City city = cityServiceInter.findByIdCity(operation);
        System.out.println(city.getCityId());
        Customer customer = new Customer(id, username,email, password, name, surname, birthday,  money, address, city);
        System.out.println(customer.getFkCityId().getCityId());
        customerServiceInter.registration(customer);
        System.out.println("----------Succesfully registered----------");

    }

    public boolean login() throws ExceptionCustomerNotFound {
        boolean result = false;
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password: ");
        String password = scanner.nextLine();

        Customer customer = customerInter.findByUserName(username);

        if (username.equals(customer.getUsername()) && password.equals(customer.getCostPassword())) {
            System.out.println("Succesfully login");
            result = true;
        } else System.out.println("wrong password");
        return result;
    }







}

