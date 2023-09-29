package za.ac.cput.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.domain.Programme;
@Repository
public interface ProgrammeRepository extends JpaRepository<Programme, Integer> {
}
