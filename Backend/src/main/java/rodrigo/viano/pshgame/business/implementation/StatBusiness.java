package rodrigo.viano.pshgame.business.implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rodrigo.viano.pshgame.business.IStatBusiness;
import rodrigo.viano.pshgame.business.exceptions.BusinessException;
import rodrigo.viano.pshgame.model.Player;
import rodrigo.viano.pshgame.model.Stat;
import rodrigo.viano.pshgame.persistence.StatRepository;

@Service
public class StatBusiness implements IStatBusiness {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private StatRepository statDao;

    
    @Override
    public List<Stat> saveAll(List<Stat> stats) throws BusinessException {
        try{
            List<Stat> statResult = statDao.saveAll(stats);
            for(Stat stat : statResult){
                log.info("Estadística guardada con éxito. ID: {} ", stat.getId());
            }
            return statResult;
        }catch(Exception e){
            log.error(e.getMessage());
            throw new BusinessException(e);
        }
    }

    @Override
    public void generateStats() throws BusinessException {
        //Player player = buildPlayer("test", "test_url");
        List<Stat> stats = new ArrayList<>();
        Random r = new Random();
        int low = 0;
        int high = 100;
        int result = 0;

        for (int i = 0; i < 10; i++) {
            result = r.nextInt(high - low) + low;
            stats.add(buildStat(buildPlayer("test_"+i, "test_url_"+i), result));
        }
        try{
            saveAll(stats);
        }catch(Exception e){
            log.error(e.getMessage());
            throw new BusinessException(e);
        }
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
