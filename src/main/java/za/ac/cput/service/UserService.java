package za.ac.cput.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;

import java.util.List;

@Service
public class UserService implements IUserService{
    private UserRepository repository;
    @Autowired
    private UserService(UserRepository userRepository){
        this.repository = userRepository;
    }

    @Override
    public User create(User user){
        return this.repository.save(user);
    }

    @Override
    public User read(Integer id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public User update(User user){
        return this.repository.existsById(user.getUserId()) ? this.repository.save(user) : null;
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
    public List<User> getAll(){
        return this.repository.findAll();
    }
}
