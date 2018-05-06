package com.github.kamilcieslik.academic.time_bank_backend.time_bank_services;

import com.github.kamilcieslik.academic.time_bank_backend.entity.Offer;
import com.github.kamilcieslik.academic.time_bank_backend.entity.User;
import com.github.kamilcieslik.academic.time_bank_backend.entity.additional_classes.Statistics;

import java.util.List;

public interface OfferService extends CRUDService<Offer> {
    Statistics getUserStatistics(User user);
    List<Offer> findActiveOffers(User user);
    List<Offer> findGivenOffers(User user);
    List<Offer> findTakenOffers(User user);
}
