package rodrigo.viano.pshgame.model;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "stats")
public class Stat implements Serializable {
    private static final long serialVersionUID = 6554265456180416900L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private int score;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createDateTime;

    @OneToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, optional = false)
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

    public Stat() {
    }

    public Stat(Long id, int score) {
        this.id = id;
        this.score = score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setPlayer(Player player){
        this.player = player;
    }

    @PrePersist
    public void setCreationDateTime() {
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        this.createDateTime = timestamp;
    }

    public int getScore() {
        return this.score;
    }

    public Long getId() {
        return this.id;
    }

    public Player getPlayer(){
        return this.player;
    }
    
    public Timestamp getCreationDateTime() {
        return this.createDateTime;
    }
}