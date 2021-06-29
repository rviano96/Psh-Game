package rodrigo.viano.pshgame.business.implementation;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rodrigo.viano.pshgame.business.IPlayerBusiness;
import rodrigo.viano.pshgame.business.exceptions.BusinessException;
import rodrigo.viano.pshgame.model.Player;
import rodrigo.viano.pshgame.model.dto.PlayerDto;
import rodrigo.viano.pshgame.persistence.PlayerRepository;

@Service
public class PlayerBusiness implements IPlayerBusiness {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    PlayerRepository playerDao;

    @Override
    public PlayerDto findTop10() throws BusinessException {
        try {
            List<Player> players = playerDao.findTop10ByOrderByStatScoreDesc();
            Timestamp lastTimeUpdated = playerDao.getLastTimeUpdated();
            PlayerDto playerDto = new PlayerDto(players, lastTimeUpdated);
            return playerDto;
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException(e);
        }
    }

}
