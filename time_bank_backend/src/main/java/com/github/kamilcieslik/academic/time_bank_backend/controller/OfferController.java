package com.github.kamilcieslik.academic.time_bank_backend.controller;

import com.github.kamilcieslik.academic.time_bank_backend.TimeBankApplication;
import com.github.kamilcieslik.academic.time_bank_backend.entity.Offer;
import com.github.kamilcieslik.academic.time_bank_backend.entity.User;
import com.github.kamilcieslik.academic.time_bank_backend.entity.additional_classes.Statistics;
import com.github.kamilcieslik.academic.time_bank_backend.time_bank_services.OfferService;
import com.github.kamilcieslik.academic.time_bank_backend.time_bank_services.UserService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.lang.Math.toIntExact;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/offers")
public class OfferController {
    private final OfferService offerService;
    private final UserService userService;

    @Autowired
    public OfferController(@Qualifier(TimeBankApplication.READ_WRITE_MODE) OfferService offerService,
                           @Qualifier(TimeBankApplication.READ_WRITE_MODE) UserService userService) {
        this.offerService = offerService;
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/statistics/{id}", produces = {APPLICATION_JSON_VALUE})
    public Statistics user(@PathVariable Integer id) {
        return offerService.getUserStatistics(userService.find(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/active/{id}")
    public List<Offer> getActiveOffers(@PathVariable Integer id) {
        return offerService.findActiveOffers(userService.find(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/givenOffers/{id}")
    public List<Offer> getGivenOffers(@PathVariable Integer id) {
        return offerService.findGivenOffers(userService.find(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/takenOffers/{id}")
    public List<Offer> getTakenOffers(@PathVariable Integer id) {
        return offerService.findTakenOffers(userService.find(id));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "enroll/{id}")
    public Offer signUpForAnOffer(@PathVariable Integer id, @RequestBody Integer userId) {
        Offer selectedOffer = offerService.find(id);
        User loggedUser = userService.find(userId);

        if (selectedOffer.getReceiver() == null)
            selectedOffer.setReceiver(loggedUser);
        else if (selectedOffer.getGiver() == null)
            selectedOffer.setGiver(loggedUser);

        offerService.save(selectedOffer);
        return selectedOffer;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/save", consumes = {APPLICATION_JSON_VALUE})
    public Offer saveOffer(@RequestBody String stringToParse) {
        System.out.println(stringToParse);

        JSONParser parser = new JSONParser();
        try {
            JSONObject json = (JSONObject) parser.parse(stringToParse);
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME;

            Offer offer = new Offer((String) json.get("name"), (String) json.get("description"),
                    Timestamp.valueOf(LocalDateTime.parse((String) json.get("dateFrom"), dateTimeFormatter)),
                    Timestamp.valueOf(LocalDateTime.parse((String) json.get("dateTo"), dateTimeFormatter)),
                    (String) json.get("address"), (Boolean) json.get("type"));

            if (json.get("giver") != null) {
                User user = userService.find(toIntExact((Long) json.get("giver")));
                offer.setGiver(user);
            }

            if (json.get("receiver") != null) {
                User user = userService.find(toIntExact((Long) json.get("receiver")));
                offer.setReceiver(user);
            }

            return offerService.save(offer);
        } catch (ParseException e) {
            return null;
        }
    }
}