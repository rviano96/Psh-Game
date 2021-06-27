package rodrigo.viano.pshgame.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import rodrigo.viano.pshgame.model.Player;

public class PlayerDto {
    private List<Player> player;
    private LocalDateTime lastTimeUpdated;

    public PlayerDto(List<Player> player, LocalDateTime lastTimeUpdated) {
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

    public LocalDateTime getLastTimeUpdated() {
        return lastTimeUpdated;
    }

    public void setLastTimeUpdated(LocalDateTime lastTimeUpdated) {
        this.lastTimeUpdated = lastTimeUpdated;
    }

}
