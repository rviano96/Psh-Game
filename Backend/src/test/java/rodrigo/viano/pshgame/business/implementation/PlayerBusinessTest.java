package rodrigo.viano.pshgame.business.implementation;

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
import rodrigo.viano.pshgame.persistence.PlayerRepository;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
public class PlayerBusinessTest {
    @MockBean
    private PlayerRepository playerDao;

    @InjectMocks
    private PlayerBusiness playerService;
    
    @Test
    public void testGetTop10Players() throws BusinessException {
        /*Player player = buildPlayer("test", "test_url");
        List<Stat> stats = new ArrayList<>();
        Random r = new Random();
        int low = 0;
        int high = 100;
        int result = 0;

        for (int i = 0; i < 10; i++) {
            result = r.nextInt(high - low) + low;
            stats.add(buildStat(player, result));
        }
        Mockito.when(playerDao.findTop10ByOrderByStatScoreDesc()).thenReturn(stats);
        List<Stat> statResults = playerService.findTop10();
        assertIterableEquals(stats, statResults);
        verify(playerDao, times(1)).findTop10ByOrderByStatScoreDesc();*/
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
