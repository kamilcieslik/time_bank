package com.github.kamilcieslik.academic.time_bank_backend.db_file_read_write;

import com.github.kamilcieslik.academic.time_bank_backend.entity.Offer;
import com.github.kamilcieslik.academic.time_bank_backend.entity.User;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Database {
    @XmlElementWrapper(name = "users")
    @XmlElement(name = "user")
    private List<User> users;
    @XmlElementWrapper(name = "offers")
    @XmlElement(name = "offer")
    private List<Offer> offers;

    public Database() {
    }

    public Database(List<User> users, List<Offer> offers) {
        this.users = users;
        this.offers = offers;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public void addUser(User user) {
        if (users == null)
            users = new ArrayList<>();
        users.add(user);
    }

    public void addOffer(Offer offer) {
        if (offers == null)
            offers = new ArrayList<>();
        offers.add(offer);
    }

    public void deleteUser(User user) {
        users.remove(user);
    }

    public void deleteOffer(Offer offer) {
        offers.remove(offer);
    }

    public User findUserById(Integer id) {
        return users.stream().findFirst().filter(user -> user.getId().equals(id)).get();
    }

    public Offer findOfferById(Integer id) {
        return offers.stream().findFirst().filter(offer -> offer.getId().equals(id)).get();
    }

    public User findUserByLogin(String login) {
        return users.stream().findFirst().filter(user -> user.getLogin().equals(login)).get();
    }

    public User findUserByEmail(String email) {
        return users.stream().findFirst().filter(user -> user.getEmail().equals(email)).get();
    }

    public User findUserByLoginAndPassword(String login, String password) {
        return users.stream().findFirst().filter(user -> user.getLogin().equals(login) && user.getPassword()
                .equals(password)).get();
    }

    public List<Offer> findOffersByGiver(User user) {
        return offers.stream().filter(offer -> offer.getGiver().getId().equals(user.getId())).collect(Collectors.toList());
    }

    public List<Offer> findOffersByReceiver(User user) {
        return offers.stream().filter(offer -> offer.getReceiver().getId().equals(user.getId())).collect(Collectors.toList());
    }

    public List<Offer> findOffersWhereGiverIsNullOrReceiverIsNull(User user) {
        return offers.stream().filter(offer -> offer.getGiver() == null || offer.getReceiver() == null).collect(Collectors.toList());
    }
}
