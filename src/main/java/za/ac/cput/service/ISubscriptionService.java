package za.ac.cput.service;
import za.ac.cput.domain.Subscription;
import java.util.List;

public interface ISubscriptionService extends IService<Subscription, Integer>{
    List<Subscription> getAll();
}
