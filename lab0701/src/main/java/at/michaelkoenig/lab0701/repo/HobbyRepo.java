package at.michaelkoenig.lab0701.repo;

import at.michaelkoenig.lab0701.model.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Michael König
 */
@Repository
public interface HobbyRepo extends JpaRepository<Hobby, Integer> {
}
