import configuration.AppConfig;
import entity.Car;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("ClassPathXmlApplicationContext");
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");

        Car car = context.getBean("car", Car.class);
        car.drive();



        System.out.println("AnnotationConfigApplicationContext");
        ApplicationContext context2 =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Car car2 = context2.getBean(Car.class);
        car2.drive();
    }
}
