package za.ac.cput.service;
import za.ac.cput.domain.Membership;
import java.util.List;

public interface IMembershipService extends IService<Membership, Integer>{
    List<Membership> getAll();
}
