package dev.shailendra.admindashboard.service;

import dev.shailendra.admindashboard.exception.UserNotFoundException;
import dev.shailendra.admindashboard.model.Employee;
import dev.shailendra.admindashboard.repo.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo){
        this.employeeRepo = employeeRepo;
    }

    public Employee getById(Integer id){
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User By Id" + id + " " +
                "user not found"));
    }

    public List<Employee> findAllEmployees(){
        return employeeRepo.findAll();
    }

    public Employee addEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Integer id){
        employeeRepo.delete(employeeRepo.getById(id));
    }
}
