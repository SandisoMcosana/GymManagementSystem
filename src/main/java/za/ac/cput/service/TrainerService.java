package za.ac.cput.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Trainer;
import za.ac.cput.repository.TrainerRepository;
import java.util.List;

@Service
public class TrainerService implements ITrainerService{
    private TrainerRepository repository;
    @Autowired
    private TrainerService(TrainerRepository trainerRepository){
        this.repository = trainerRepository;
    }

    @Override
    public Trainer create(Trainer trainer){
        return this.repository.save(trainer);
    }

    @Override
    public Trainer read(Integer id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Trainer update(Trainer trainer){
        return this.repository.existsById(trainer.getTrainerId()) ? this.repository.save(trainer) : null;
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
    public List<Trainer> getAll(){
        return this.repository.findAll();
    }
}
