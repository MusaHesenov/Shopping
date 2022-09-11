import controller.MenuController;
import entity.City;
import entity.Customer;
import entity.TypeShop;
import exception.ExceptionCustomerNotFound;
import repository.impl.CityImpl;
import repository.impl.CustomerImpl;
import repository.impl.TypeShopImpl;
import repository.inter.CityInter;
import repository.inter.CustomerInter;
import repository.inter.TypeShopInter;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws ExceptionCustomerNotFound {

        MenuController menuController = new MenuController();
        menuController.Menu();


       // CityInter cityInter = new CityImpl();

//        City city = cityInter.findByid(2);
//        city.setCityName("Gence");
//        cityInter.update(city);

//        TypeShopInter typeShopInter = new TypeShopImpl();
//        TypeShop typeShop = new TypeShop(1,"drink");
//        typeShopInter.insert(typeShop);

//        CustomerInter customerInter = new CustomerImpl();
//        CityInter cityInter = new CityImpl();
//        LocalDate localDate = LocalDate.of(2003,7,8);
//        City city = new City(1,"Baku");
//        Customer customer = new Customer(2,"Musa","musa123@gmail.com","2003","Musa_2003","Hesenov",localDate,2000.0,"Qarachuxur",city);
//        //customerInter.insert(customer);
//
//        customerInter.update(customer);



    }
}
