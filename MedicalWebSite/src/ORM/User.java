package ORM;

import some_usefull_classes.Password;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

public class User implements Serializable {
    
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private Password password;
    private String gender;
    private Date birthDate;
    private String about_user;
    private Blob photo;

    public User(String firstName, String lastName, String email, Password password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public void User(String firstName, String lastName, String email, Password password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Password getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(Password password) {
        this.password = password;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setAbout_user(String about_user) {
        this.about_user = about_user;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getAbout_user() {
        return about_user;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

}
