package iuh.fit.baitap1.dao;

import iuh.fit.baitap1.entity.Employee;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDAO {
    void update(Employee emp) throws SQLException;
    List<Employee> getAll() throws SQLException;
    Employee getById(int id) throws SQLException;
    void deleteById(int id) throws SQLException;
    void save(Employee emp) throws SQLException;
}
