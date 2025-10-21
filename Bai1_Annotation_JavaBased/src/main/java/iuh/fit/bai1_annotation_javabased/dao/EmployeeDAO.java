package iuh.fit.bai1_annotation_javabased.dao;

import iuh.fit.bai1_annotation_javabased.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    void save(Employee emp);
    void update(Employee emp);
    void deleteById(int id);
    Employee getById(int id);
    List<Employee> getAll();
}
