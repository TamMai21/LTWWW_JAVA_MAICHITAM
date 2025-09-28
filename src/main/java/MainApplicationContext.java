import entity.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApplicationContext {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        Employee emp1 = context.getBean("employee1", Employee.class);
        System.out.println("Employee1: " + emp1.getName() + " - " + emp1.getAddress().getCity());

        Employee emp2 = context.getBean("employee2", Employee.class);
        System.out.println("Employee2: " + emp2.getName() + " - " + emp2.getAddress().getCity());
    }
}
