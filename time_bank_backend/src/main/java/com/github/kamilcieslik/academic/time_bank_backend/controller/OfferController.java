package com.github.kamilcieslik.academic.time_bank_backend.controller;

import com.github.kamilcieslik.academic.time_bank_backend.TimeBankApplication;
import com.github.kamilcieslik.academic.time_bank_backend.entity.additional_classes.Statistics;
import com.github.kamilcieslik.academic.time_bank_backend.time_bank_services.OfferService;
import com.github.kamilcieslik.academic.time_bank_backend.time_bank_services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

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
}
