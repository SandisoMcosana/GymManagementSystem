package za.ac.cput.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Programme;
import za.ac.cput.repository.ProgrammeRepository;

import java.util.List;

@Service
public class ProgrammeService implements IProgrammeService{
    private ProgrammeRepository repository;

    @Autowired
    private ProgrammeService(ProgrammeRepository programmeRepository){
        this.repository = programmeRepository;
    }

    @Override
    public Programme create(Programme programme){
        return this.repository.save(programme);
    }

    @Override
    public Programme read(Integer id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Programme update(Programme programme){
        return this.repository.existsById(programme.getProgrammeId()) ? this.repository.save(programme) : null;
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
    public List<Programme> getAll(){
        return this.repository.findAll();
    }
}
