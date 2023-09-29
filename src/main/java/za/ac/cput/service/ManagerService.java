package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Manager;
import za.ac.cput.repository.ManagerRepository;

import java.util.List;

@Service
public class ManagerService implements IManagerService{
    private ManagerRepository repository;

    @Autowired
    private ManagerService(ManagerRepository managerRepository){
        this.repository = managerRepository;
    }

    @Override
    public Manager create(Manager manager){
        return this.repository.save(manager);
    }

    @Override
    public Manager read(Integer id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Manager update(Manager manager){
        return this.repository.existsById(manager.getManagerId()) ? this.repository.save(manager) : null;
    }

    @Override
    public boolean delete(Integer id){
        if (this.repository.existsById(id)){
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Manager> getAll(){
        return this.repository.findAll();
    }
}
