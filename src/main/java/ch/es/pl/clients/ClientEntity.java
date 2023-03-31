package ch.es.pl.clients;

import jakarta.persistence.*;

@Entity
@Table(name = "clients")
public class ClientEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String login;
    private String password;
    private String prenom;
    private int age;

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return age;
    }
}
