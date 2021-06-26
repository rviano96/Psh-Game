package rodrigo.viano.pshgame.business;

import java.util.List;

import rodrigo.viano.pshgame.business.exceptions.BusinessException;
import rodrigo.viano.pshgame.model.Stat;

public interface IStatBusiness {
    
    public List<Stat> saveAll(List <Stat> stats) throws BusinessException;
    public void generateStats() throws BusinessException;
}
