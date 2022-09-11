package controller;

import entity.Product;
import exception.ExceptionCustomerNotFound;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuController {
    private static Scanner scanner = new Scanner(System.in);
    private static CustomerController customerController = new CustomerController();

    private static LoginController loginController = new LoginController();
    public void Menu() throws ExceptionCustomerNotFound {
        System.out.println("Enter function\n" +
                "1-Registration\n" +
                "2-Login");
        int n = scanner.nextInt();
        if (n == 1) {
            customerController.signUp();
        } else if (n == 2) {
            boolean k = customerController.login();
            if (k==true){
                List<Product> basket = new ArrayList<>();
                loginController.loginThen();
            }
        } else {
            System.out.println("wrong function");
        }


    }
}

