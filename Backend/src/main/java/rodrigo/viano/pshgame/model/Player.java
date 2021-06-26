package rodrigo.viano.pshgame.model;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "players")
public class Player implements Serializable {
    private static final long serialVersionUID = 6554265456180416900L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 30, nullable = false)
    private String nickname;

    @Column(length = 255, nullable = false, name = "image_url")
    private String image;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "player")
    @JsonIgnoreProperties("player")
    private Stat stat;

    public Player() {
    }

    public Player(Long id, String nickname, String image) {
        this.id = id;
        this.nickname = nickname;
        this.image = image;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getNickname() {
        return this.nickname;
    }

    public Long getId() {
        return this.id;
    }

    public Stat getStat(){
        return this.stat;
    }

    public String getImage() {
        return this.image;
    }
}