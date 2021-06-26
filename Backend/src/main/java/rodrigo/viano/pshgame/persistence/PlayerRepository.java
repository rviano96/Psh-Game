package rodrigo.viano.pshgame.persistence;

import rodrigo.viano.pshgame.model.Player;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository  extends JpaRepository<Player, Long>{
    List<Player> findTop10ByOrderByStatScoreDesc();
}
