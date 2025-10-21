package iuh.fit.bai1_springboot;

import iuh.fit.bai1_springboot.dao.EmployeeDAO;
import iuh.fit.bai1_springboot.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Bai1SpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(Bai1SpringBootApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(EmployeeDAO employeeDAO) {
        return args -> {
            System.out.println("✅ Starting Spring Boot JDBC AutoConfig Demo");

            Employee employee = new Employee("John Doe", "Developer");
            employeeDAO.save(employee);

            List<Employee> employees = employeeDAO.getAll();
            employees.forEach(System.out::println);

            Employee emp = employeeDAO.getById(5);
            System.out.println("Employee with ID 1: " + emp);

            Employee empDirect = employeeDAO.getByIdDirectMapper(5);
            System.out.println("Employee with ID 1 (Direct Mapper): " + empDirect);
        };
    }
}
