package iuh.fit.se.services.impl;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.repositories.EmployeeRepository;
import iuh.fit.se.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void save(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getById(int id) {
        return this.employeeRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(int id) {
        this.employeeRepository.deleteById(id);
    }
}
