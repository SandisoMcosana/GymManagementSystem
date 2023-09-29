package za.ac.cput.service;
import za.ac.cput.domain.Trainer;
import java.util.List;

public interface ITrainerService extends IService<Trainer, Integer>{
    List<Trainer> getAll();
}
