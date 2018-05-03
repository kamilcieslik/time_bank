package com.github.kamilcieslik.academic.time_bank_backend.time_bank_services;

import com.github.kamilcieslik.academic.time_bank_backend.entity.Offer;
import com.github.kamilcieslik.academic.time_bank_backend.entity.User;
import com.github.kamilcieslik.academic.time_bank_backend.entity.additional_classes.Statistics;

public interface OfferService extends CRUDService<Offer> {
    Statistics getUserStatistics(User user);
}
