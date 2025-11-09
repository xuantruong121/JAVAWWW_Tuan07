package iuh.fit.se.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "First Name khong dduoc phep rong")
    private String firstName;

    @NotEmpty(message = "Last Name khong dduoc phep rong")
    private String lastName;

    private String gender;
    private LocalDate dateOfBirth;
    private String email;
    private String phone;
}
