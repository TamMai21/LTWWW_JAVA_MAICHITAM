package entity;



import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Component
public class Employee2 {
    private int id = 201;
    private String name = "Le Van C";

    @Autowired
    private Address2 address;
}

