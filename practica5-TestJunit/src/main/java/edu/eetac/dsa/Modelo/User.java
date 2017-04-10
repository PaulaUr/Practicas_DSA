package edu.eetac.dsa.Modelo;

/**
 * Created by pauli on 08/03/2017.
 */
public class User {

    private int id;
    private int level;
    private String nick;
    private  String email;
    private String password;

    public User(int id, int level, String nick, String email, String password) {
        this.id = id;
        this.level = level;
        this.nick = nick;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
