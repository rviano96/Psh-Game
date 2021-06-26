package rodrigo.viano.pshgame.business;

import java.util.List;

import rodrigo.viano.pshgame.business.exceptions.BusinessException;
import rodrigo.viano.pshgame.model.Player;

public interface IPlayerBusiness {
    public List<Player> findTop10() throws BusinessException;

}
