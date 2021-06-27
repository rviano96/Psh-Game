package rodrigo.viano.pshgame.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rodrigo.viano.pshgame.business.IPlayerBusiness;
import rodrigo.viano.pshgame.model.dto.PlayerDto;

@RestController
@RequestMapping(Constantes.URL_BASE_PLAYERS)
public class PlayerRestController {
    @Autowired
    private IPlayerBusiness playerService;

    @GetMapping(value = "/topTen")
    public ResponseEntity<PlayerDto> findTop10() throws Exception {
        try {
            return new ResponseEntity<PlayerDto>(playerService.findTop10(), HttpStatus.OK);
        } catch (Exception e) {
            throw new Exception(e);
        }
    }
}