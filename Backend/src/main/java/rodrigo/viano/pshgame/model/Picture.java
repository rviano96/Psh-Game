package rodrigo.viano.pshgame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Picture {
    private String large;

    public Picture() {
    }

    public Picture(String large) {
        this.setLarge(large);
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

}
