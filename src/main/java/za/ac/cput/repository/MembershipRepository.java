package za.ac.cput.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Membership;
@Repository
public interface MembershipRepository extends JpaRepository<Membership, Integer> {
}
