package rodrigo.viano.pshgame.business;
import rodrigo.viano.pshgame.business.exceptions.BusinessException;
import rodrigo.viano.pshgame.model.dto.PlayerDto;

public interface IPlayerBusiness {
    public PlayerDto findTop10() throws BusinessException;
}
