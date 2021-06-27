package rodrigo.viano.pshgame.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RandomUser {

    private Login login;
    private Picture picture;

    public RandomUser() {
    }

    public RandomUser(Login login, Picture picture) {

        this.setLogin(login);
        this.setPicture(picture);
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

}
