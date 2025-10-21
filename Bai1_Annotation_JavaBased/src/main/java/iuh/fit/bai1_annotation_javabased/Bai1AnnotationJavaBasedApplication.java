package iuh.fit.bai1_annotation_javabased;

import iuh.fit.bai1_annotation_javabased.dao.EmployeeDAO;
import iuh.fit.bai1_annotation_javabased.entity.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class Bai1AnnotationJavaBasedApplication {

    @SuppressWarnings("resource")
    public static void main(String[] args) throws SQLException {
        ApplicationContext context =
                SpringApplication.run(Bai1AnnotationJavaBasedApplication.class, args);

        DataSource ds = context.getBean("dataSource", DataSource.class);
        System.out.println("DataSource: " + ds.getConnection());

        EmployeeDAO dao = context.getBean(EmployeeDAO.class);

        dao.save(new Employee(3, "Pham Van C", "Designer"));
        dao.save(new Employee(4, "Le Thi D", "Tester"));

        List<Employee> list = dao.getAll();
        list.forEach(System.out::println);
    }
}
