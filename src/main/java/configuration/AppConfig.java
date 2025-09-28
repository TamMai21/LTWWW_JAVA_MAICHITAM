package configuration;

import entity.Address;
import entity.Car;
import entity.Employee;
import entity.Engine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Engine engine() {
        return new Engine("V12");
    }

    @Bean
    public Car car() {
        return new Car(engine());
    }

    @Bean
    public Address address() {
        return new Address("Da Nang", "Central", "Vietnam");
    }

    @Bean
    public Employee employee() {
        return new Employee(301, "Pham Thi D", address());
    }
}