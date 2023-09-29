package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Trainer;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {
}
