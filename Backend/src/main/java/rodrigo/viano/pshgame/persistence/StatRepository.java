package rodrigo.viano.pshgame.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import rodrigo.viano.pshgame.model.Stat;

@Repository
public interface StatRepository extends JpaRepository<Stat, Long>{
}
