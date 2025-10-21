package iuh.fit.bai1_springboot.dao;

import iuh.fit.bai1_springboot.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    void save(Employee employee);
    void update(Employee employee);
    void deleteById(int id);
    Employee getById(int id);
    List<Employee> getAll();
    Employee getByIdDirectMapper(int id);
}
