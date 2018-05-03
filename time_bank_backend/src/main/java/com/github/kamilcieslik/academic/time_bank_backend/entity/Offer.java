package com.github.kamilcieslik.academic.time_bank_backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.xml.bind.annotation.*;
import java.util.Date;
import java.util.Objects;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "offer")
public class Offer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @XmlAttribute(name = "id")
    private Integer id;

    @Column(name = "name")
    @XmlAttribute(name = "name")
    private String name;

    @Column(name = "description")
    @XmlAttribute(name = "description")
    private String description;

    @Column(name = "date_from")
    @XmlAttribute(name = "date_from")
    private Date dateFrom;

    @Column(name = "date_to")
    @XmlAttribute(name = "date_to")
    private Date dateTo;

    @Column(name = "address")
    @XmlAttribute(name = "address")
    private String address;

    @Column(name = "type")
    @XmlAttribute(name = "type")
    private Boolean type;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "giver_id")
    @XmlElement(name = "giver")
    @JsonIgnore
    private User giver;

    @ManyToOne(cascade = {CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH})
    @JoinColumn(name = "receiver_id")
    @XmlElement(name = "receiver")
    @JsonIgnore
    private User receiver;

    public Offer() {
    }

    public Offer(String name, String description, Date dateFrom, Date dateTo, String address, Boolean type) {
        this.name = name;
        this.description = description;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.address = address;
        this.type = type;
    }

    public Offer(String name, String description, Date dateFrom, Date dateTo, String address, Boolean type, User giver, User receiver) {
        this.name = name;
        this.description = description;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.address = address;
        this.type = type;
        this.giver = giver;
        this.receiver = receiver;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public User getGiver() {
        return giver;
    }

    public void setGiver(User giver) {
        this.giver = giver;
    }

    public void assignGiver(User giver) {
        this.giver = giver;
        giver.addGivenTimeToOther(this);
    }

    public User getReceiver() {
        return receiver;
    }

    public void assignReceiver(User receiver){
        this.receiver = receiver;
        receiver.addTimeTakenFromOther(this);
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    @Override
    public String toString() {
        return "Offer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", address='" + address + '\'' +
                ", type=" + type +
                ", giver=" + giver.getFirstName() + " " + giver.getLastName() + " (" + giver.getLogin() + ")" + '\'' +
                ", receiver=" + receiver.getFirstName() + " " + receiver.getLastName() + " (" + receiver.getLogin()
                + ")" + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Objects.equals(id, offer.id) &&
                Objects.equals(name, offer.name) &&
                Objects.equals(description, offer.description) &&
                Objects.equals(dateFrom, offer.dateFrom) &&
                Objects.equals(dateTo, offer.dateTo) &&
                Objects.equals(address, offer.address) &&
                Objects.equals(type, offer.type) &&
                Objects.equals(giver, offer.giver) &&
                Objects.equals(receiver, offer.receiver);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, dateFrom, dateTo, address, type, giver, receiver);
    }
}
