package com.github.kamilcieslik.academic.time_bank_backend.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @XmlAttribute(name = "id")
    private Integer id;

    @Column(name = "login")
    @XmlAttribute(name = "login")
    private String login;

    @Column(name = "password")
    @XmlAttribute(name = "password")
    private String password;

    @Column(name = "first_name")
    @XmlAttribute(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    @XmlAttribute(name = "last_name")
    private String lastName;

    @Column(name = "email")
    @XmlAttribute(name = "email")
    private String email;

    @Column(name = "phone")
    @XmlAttribute(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "giver", cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @XmlElementWrapper(name = "given_times_to_others")
    @XmlElement(name = "given_time_to_other")
    private List<Offer> givenTimesToOthers;

    @OneToMany(mappedBy = "receiver", cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @XmlElementWrapper(name = "times_taken_from_others")
    @XmlElement(name = "given_time_from_other")
    private List<Offer> timesTakenFromOthers;

    public User() {
    }

    public User(String login, String password, String firstName, String lastName, String email, String phone) {
        this.login = login;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Offer> getGivenTimesToOthers() {
        return givenTimesToOthers;
    }

    public void setGivenTimesToOthers(List<Offer> givenTimesToOthers) {
        this.givenTimesToOthers = givenTimesToOthers;
    }

    public List<Offer> getTimesTakenFromOthers() {
        return timesTakenFromOthers;
    }

    public void setTimesTakenFromOthers(List<Offer> timesTakenFromOthers) {
        this.timesTakenFromOthers = timesTakenFromOthers;
    }

    public void addGivenTimeToOther(Offer givenTime) {
        if (givenTimesToOthers==null)
            givenTimesToOthers = new ArrayList<>();
        givenTimesToOthers.add(givenTime);
    }

    public void addTimeTakenFromOther(Offer takenTime) {
        if (timesTakenFromOthers==null)
            timesTakenFromOthers = new ArrayList<>();
        timesTakenFromOthers.add(takenTime);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(email, user.email) &&
                Objects.equals(phone, user.phone) &&
                Objects.equals(givenTimesToOthers, user.givenTimesToOthers) &&
                Objects.equals(timesTakenFromOthers, user.timesTakenFromOthers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, firstName, lastName, email, phone, givenTimesToOthers, timesTakenFromOthers);
    }
}
