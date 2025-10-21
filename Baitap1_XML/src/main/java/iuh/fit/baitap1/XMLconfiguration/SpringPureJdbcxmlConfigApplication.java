package iuh.fit.baitap1.XMLconfiguration;

import iuh.fit.baitap1.dao.EmployeeDAO;
import iuh.fit.baitap1.dao.impl.EmployeeDAOImpl;
import iuh.fit.baitap1.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class SpringPureJdbcxmlConfigApplication {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws SQLException {
        SpringApplication.run(SpringPureJdbcxmlConfigApplication.class, args);

        ApplicationContext context = new ClassPathXmlApplicationContext("databaseConfig.xml");
        DataSource dataSource = context.getBean("dataSource", DataSource.class);
        System.out.println(dataSource.getConnection());

        EmployeeDAO empDAO = (EmployeeDAO) context.getBean("employeeDAO");

        // Thêm dữ liệu mẫu
        empDAO.save(new Employee(1, "Nguyen Van A", "Developer"));
        empDAO.save(new Employee(2, "Tran Thi B", "Tester"));

        // Cập nhật
        empDAO.update(new Employee(1, "Nguyen Van A", "Team Lead"));

        // Lấy tất cả nhân viên
        List<Employee> employees = empDAO.getAll();
        employees.forEach(System.out::println);

        // Lấy theo ID
        System.out.println("Employee id=1: " + empDAO.getById(1));

        // Xóa nhân viên
        empDAO.deleteById(2);
    }
}
