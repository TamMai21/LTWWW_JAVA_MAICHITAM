package entity;

import lombok.*;

// Engine.java
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Engine {
    private String type;



    public void start() {
        System.out.println("Engine " + type + " started...");
    }
}
