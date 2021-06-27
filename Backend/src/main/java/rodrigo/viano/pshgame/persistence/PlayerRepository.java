package rodrigo.viano.pshgame.persistence;

import rodrigo.viano.pshgame.model.Player;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface PlayerRepository  extends JpaRepository<Player, Long>{
    List<Player> findTop10ByOrderByStatScoreDesc();
    @Query(value = "select create_date_time from players order by create_date_time desc limit 1", nativeQuery = true)
    LocalDateTime getLastTimeUpdated();
}
