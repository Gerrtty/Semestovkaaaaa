package ORM;

import some_usefull_classes.Email;
import some_usefull_classes.Phone;

import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class User implements Serializable {
    
    private int id;
    private String firstName;
    private String lastName;
    private Email email;
    private String password;
    private String gender;
    private Date birthDate;
    private String about_user;
    private InputStream photo;
    private Phone phone;
    private List<String> roles;

    private void initRoles(String... roles) {

        this.roles = new ArrayList<String>();
        if (roles != null) {
            this.roles.addAll(Arrays.asList(roles));
        }
    }

    public User(String firstName, String lastName, Email email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User(Email email, String password) {
        this.email = email;
        this.password = password;
    }

    public User() {

    }

    public User(String firstName, String lastName, Email email, String password, String gender,
             String about_user, InputStream photo, Phone phone, String... roles) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.about_user = about_user;
        this.photo = photo;
        this.phone = phone;
        initRoles(roles);
    }

    public void User(String firstName, String lastName, Email email, String password) {
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

    public Email getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public void setLastname(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(String password) {
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

    public InputStream getPhoto() {
        return photo;
    }

    public void setPhoto(InputStream photo) {
        this.photo = photo;
    }

    public String getPhone() {
        return phone.getPhone();
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getRoles() {
        return roles;
    }
}
