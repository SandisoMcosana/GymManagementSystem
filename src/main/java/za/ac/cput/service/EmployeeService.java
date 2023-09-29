package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Employee;
import za.ac.cput.repository.EmployeeRepository;
import za.ac.cput.repository.UserRepository;

import java.util.List;
@Service
public class EmployeeService implements IEmployeeService{

    private EmployeeRepository repository;
    @Autowired
    private EmployeeService(EmployeeRepository employeeRepository){
        this.repository = employeeRepository;
    }


    @Override
    public Employee create(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Employee read(Integer id) {
        return this.repository.findById(id).orElse(null);
    }


    @Override
    public Employee update(Employee employee) {
        return this.repository.existsById(employee.getEmployeeId()) ? this.repository.save(employee): null;
    }

    @Override
    public boolean delete(Integer id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return true;
    }
        return false;
    }

    @Override
    public List<Employee> getAll() {
        return this.repository.findAll();

    }
}
