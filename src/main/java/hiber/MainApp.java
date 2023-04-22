package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      userService.add(new User("Elon", "Tusk", "dontmailme@gmail.com"));
      userService.add(new User("Jeff", "Bozo", "dontmailme@gmail.com"));
      userService.add(new User("Mark", "Zukrobert", "dontmailme@gmail.com"));


      carService.add(new Car(userService.get(1L),"Ford",1));
      carService.add(new Car(userService.get(2L),"Nissan",1));
      carService.add(new Car(userService.get(3L),"Lada",1));


      System.out.println(userService.getByCar("Lada", 1).getFirstName());


      context.close();
   }
}
