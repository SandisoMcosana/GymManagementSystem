package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.domain.Gym;

public interface GymRepository extends JpaRepository<Gym, Integer> {
}
