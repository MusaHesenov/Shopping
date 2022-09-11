package controller;

import entity.Product;

import java.util.*;

public class LoginController {
    private static List<Product> basket = new ArrayList<>();
    private static ProductController productController = new ProductController();
    private static Scanner scanner = new Scanner(System.in);
    public void loginThen(){
        System.out.println("1.Buy product: \n" +
                           "2.Show basket: \n"+
                           "3.Log out: ");
        int k = scanner.nextInt();
        if (k==1){
            productController.productList();

        } else if (k==2) {
            productController.showBasket();
            System.out.println("1.Buy: \n"+
                    "2.Clear: \n"+
                    "3.Back: ");
        }
    }


}
