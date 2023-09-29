package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Gym;
import za.ac.cput.domain.Inventory;
import za.ac.cput.repository.GymRepository;
import za.ac.cput.repository.InventoryRepository;

import java.util.List;
@Service
public class GymService implements IGymService{
    private GymRepository repository;

    @Autowired
    private GymService(GymRepository gymRepository){
        this.repository=gymRepository;
    }
    @Override
    public Gym create(Gym gym) {
        return repository.save(gym);
    }
    @Override
    public Gym read(Integer id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    public Gym update(Gym gym) {
        return this.repository.existsById(gym.getGymId()) ? this.repository.save(gym) : null;
    }
    @Override
    public boolean delete(Integer id) {
        if (this.repository.existsById(id)){
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }
    @Override
    public List<Gym> getAll() {
        return repository.findAll();
    }
}
