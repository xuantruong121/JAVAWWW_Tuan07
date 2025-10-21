package iuh.fit.bai2_jpaspring;

import iuh.fit.bai2_jpaspring.entity.Employee;
import iuh.fit.bai2_jpaspring.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Bai2JpaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(Bai2JpaSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner run(EmployeeRepository repo) {
        return args -> {
            System.out.println("Hello JPA Spring Boot");

            //Them du lieu
            repo.save(new Employee("Nguyen Van A", "Developer"));
            repo.save(new Employee("Tran Thi B", "Manager"));
            repo.save(new Employee("Le Van C", "Developer"));

            //Lay theo ID
            Employee e1 = repo.findById(1L).orElse(null);
            System.out.println("Employee with ID 1: " + e1);

            //Lay theo Role
            List<Employee> developers = repo.findByRole("Developer");
            System.out.println("Developers: ");
            developers.forEach(System.out::println);

            //Tim theo ten co chua tu khoa
            List<Employee> nameContainsVan = repo.findByNameContaining("Van");
            System.out.println("Employees with 'Van' in their name: ");
            nameContainsVan.forEach(System.out::println);

            //Cap nhat
            if (e1 != null) {
                e1.setRole("Senior Developer");
                repo.save(e1);
                System.out.println("Updated Employee with ID 1: " + e1);
            }

            //Xoa
            repo.deleteById(2L);
            System.out.println("Deleted Employee with ID 2");
        };
    }
}
