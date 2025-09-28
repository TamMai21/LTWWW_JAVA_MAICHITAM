import entity.Employee2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAnnotation {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Employee2 emp = context.getBean(Employee2.class);
        System.out.println("Employee: " + emp.getName() + " - " + emp.getAddress().getCity());
    }
}
