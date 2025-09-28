package entity;


import lombok.*;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Component
public class Address2 {
    private String city = "Hanoi";
    private String state = "North";
    private String country = "Vietnam";
}

