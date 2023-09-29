package za.ac.cput.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Subscription;
import za.ac.cput.domain.Trainer;
import za.ac.cput.repository.SubscriptionRepository;

import java.util.List;


@Service
public class SubscriptionService implements ISubscriptionService{
    private SubscriptionRepository repository;
    @Autowired
    private SubscriptionService(SubscriptionRepository subscriptionRepository){
        this.repository = subscriptionRepository;
    }

    @Override
    public Subscription create(Subscription subscription){
        return this.repository.save(subscription);
    }

    @Override
    public Subscription read(Integer id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Subscription update(Subscription subscription){
        return this.repository.existsById(subscription.getSubscriptionId()) ? this.repository.save(subscription) : null;
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
    public List<Subscription> getAll(){
        return this.repository.findAll();
    }
}
