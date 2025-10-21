package iuh.fit.bai1_annotation_javabased.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("classpath:database.properties")
@ComponentScan(basePackages = "iuh.fit.bai1_annotation_javabased")
public class AppConfig {

    @Value("${app.datasource.url}")
    private String url;

    @Value("${app.datasource.username}")
    private String userName;

    @Value("${app.datasource.password}")
    private String password;

    @Value("${app.datasource.driver}")
    private String driver;

    @Bean(name = "dataSource")
    public DataSource getDataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl(url);
        ds.setUsername(userName);
        ds.setPassword(password);
        ds.setDriverClassName(driver);
        return ds;
    }
}
