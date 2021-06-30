package rodrigo.viano.pshgame.model.dto;

import java.sql.Timestamp;
import java.util.List;

import rodrigo.viano.pshgame.model.Player;

public class PlayerDto {
    private List<Player> player;
    private Timestamp lastTimeUpdated;

    public PlayerDto(List<Player> player, Timestamp lastTimeUpdated) {
        this.player = player;
        this.lastTimeUpdated = lastTimeUpdated;
    }

    public PlayerDto() {
    }

    public List<Player> getPlayer() {
        return player;
    }

    public void setPlayer(List<Player> player) {
        this.player = player;
    }

    public Timestamp getLastTimeUpdated() {
        return lastTimeUpdated;
    }

    public void setLastTimeUpdated(Timestamp lastTimeUpdated) {
        this.lastTimeUpdated = lastTimeUpdated;
    }

}
