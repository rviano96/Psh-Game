package rodrigo.viano.pshgame.business;

import java.time.LocalDateTime;

import rodrigo.viano.pshgame.business.exceptions.BusinessException;
import rodrigo.viano.pshgame.model.dto.PlayerDto;

public interface IPlayerBusiness {
    public PlayerDto findTop10() throws BusinessException;
}
