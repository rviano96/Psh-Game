package rodrigo.viano.pshgame.business.implementation;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
import rodrigo.viano.pshgame.model.dto.PlayerDto;
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

        List<Player> players = new ArrayList<>();
        Random r = new Random();
        int low = 0;
        int high = 100;
        int score = 0;
        
        for (int i = 0; i < 5; i++) {
            score = r.nextInt(high - low) + low;
            players.add(buildPlayer("test"+i, "test_url"+i,buildStat(score)));
        }

        PlayerDto playerDtoResponse = new PlayerDto(players,Timestamp.valueOf( LocalDateTime.now()));
        Mockito.when(playerDao.findTop10ByOrderByStatScoreDesc()).thenReturn(players);
        PlayerDto playerResults = playerService.findTop10();
        assertIterableEquals(playerDtoResponse.getPlayer(), playerResults.getPlayer());
        verify(playerDao, times(1)).findTop10ByOrderByStatScoreDesc();
    }

    private Player buildPlayer(String nickname, String image, Stat stat) {
        Player player = new Player();
        player.setImage(image);
        player.setNickname(nickname);
        player.setStat(stat);
        return player;
    }

    private Stat buildStat(int score) {
        Stat stat = new Stat();
        stat.setCreationDateTime();
        stat.setScore(score);
        return stat;
    }
}
