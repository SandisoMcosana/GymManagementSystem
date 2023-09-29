package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Inventory;
import za.ac.cput.repository.InventoryRepository;

import java.util.List;

@Service
public class InventoryService implements IInventoryService {
    private InventoryRepository repository;

    @Autowired
    private InventoryService(InventoryRepository inventoryRepository){
        this.repository=inventoryRepository;
    }
    @Override
    public Inventory create(Inventory inventory) {
        return repository.save(inventory);
    }
    @Override
    public Inventory read(Integer id) {
        return repository.findById(id).orElse(null);
    }
    @Override
    public Inventory update(Inventory inventory) {
        return this.repository.existsById(inventory.getItemId()) ? this.repository.save(inventory) : null;
    }
    @Override
    public boolean delete(Integer id) {
        return false;
    }
    @Override
    public List<Inventory> getAll() {
        return repository.findAll();
    }
}
