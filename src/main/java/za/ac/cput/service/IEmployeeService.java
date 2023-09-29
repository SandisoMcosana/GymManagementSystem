package za.ac.cput.service;

import za.ac.cput.domain.Employee;
import za.ac.cput.domain.User;

import java.util.List;

public interface IEmployeeService extends IService<Employee, Integer>{
    List<Employee> getAll();
}
