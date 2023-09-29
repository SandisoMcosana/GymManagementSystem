package za.ac.cput.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Membership;
import za.ac.cput.repository.MembershipRepository;
import java.util.List;
@Service
public class MembershipService implements IMembershipService{
    private MembershipRepository repository;
    @Autowired
    private MembershipService(MembershipRepository membershipRepository){
        this.repository = membershipRepository;
    }
    @Override
    public Membership create(Membership membership){
        return this.repository.save(membership);
    }
    @Override
    public Membership read(Integer id){
        return this.repository.findById(id).orElse(null);
    }

    @Override
    public Membership update(Membership membership){
        return this.repository.existsById(membership.getMembershipId()) ? this.repository.save(membership) : null;
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
    public List<Membership> getAll(){
        return this.repository.findAll();
    }
}
