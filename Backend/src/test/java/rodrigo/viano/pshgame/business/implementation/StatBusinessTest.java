package rodrigo.viano.pshgame.business.implementation;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import rodrigo.viano.pshgame.business.exceptions.BusinessException;
import rodrigo.viano.pshgame.model.Player;
import rodrigo.viano.pshgame.model.Stat;
import rodrigo.viano.pshgame.persistence.StatRepository;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class StatBusinessTest {

    @MockBean
    private StatRepository statDao;

    @InjectMocks
    private StatBusiness statService;

    @Test
    public void testSaveMultipleStats() throws BusinessException {
        Player player = buildPlayer("test", "test_url");
        List<Stat> stats = new ArrayList<>();
        stats.add(buildStat(player, 10));
        stats.add(buildStat(player, 0));
        stats.add(buildStat(player, 20));
        Mockito.when(statDao.saveAll(stats)).thenReturn(stats);
        List<Stat> statResults = statService.saveAll(stats);
        assertIterableEquals(stats, statResults);
        verify(statDao, times(1)).saveAll(stats);
    }

    private Player buildPlayer(String nickname, String image) {
        Player player = new Player();
        player.setImage(image);
        player.setNickname(nickname);
        return player;
    }

    private Stat buildStat(Player player, int score) {
        Stat stat = new Stat();
        stat.setCreationDateTime();
        stat.setScore(score);
        stat.setPlayer(player);
        return stat;
    }

}