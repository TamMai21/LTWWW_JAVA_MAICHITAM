package entity;

import lombok.*;

// Car.java
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Car {
    private Engine engine;

    // Constructor Injection


    public void drive() {
        engine.start();
        System.out.println("Car is running...");
    }
}

