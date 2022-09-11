package controller;

import repository.impl.TypeShopImpl;
import repository.inter.TypeShopInter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entity.Product;
import entity.TypeShop;
import repository.impl.ProductImpl;
import repository.impl.TypeShopImpl;
import repository.inter.ProductInter;
import repository.inter.TypeShopInter;
import service.inter.ProductServiceInter;
import service.impl.ProductServiceImpl;

public class ProductController {
    private static Scanner scanner = new Scanner(System.in);
    private static TypeShopInter typeShopInter = new TypeShopImpl();
    private static ProductInter productInter = new ProductImpl();
    private static ProductServiceInter productServiceInter = new ProductServiceImpl();

    private static LoginController loginController = new LoginController();
    private List<Product> basket = new ArrayList<>();

    public void productList() {
        System.out.println("Enter your want product type: ");
        List<TypeShop> list = typeShopInter.findAll();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println((list.size() + 1) + ". All product type");

        int k = scanner.nextInt();

        TypeShop typeShop = typeShopInter.findById(k);

        if (typeShop == null) {
            productServiceInter.selectAll();
        } else {
            List<Product> productList = productInter.findTypeShop(typeShop);
            for (int i = 0; i < productList.size(); i++) {
                System.out.println(productList.get(i));
            }
        }
        System.out.println("Choose your product: ");
        int n = scanner.nextInt();
        Product product = productInter.findByid(n);
        System.out.println("Count: ");
        int count = scanner.nextInt();
        product.setProductCount(count);
        if (product == null) {
            System.out.println("Wrong product");
            loginController.loginThen();
        } else {
            basket.add(product);
            loginController.loginThen();
        }

    }

    public void showBasket() {
        for (int i = 0; i < basket.size(); i++) {
            System.out.println(basket.get(i));
        }
    }
}
