package com.github.kamilcieslik.academic.time_bank_backend.database.repository;

import com.github.kamilcieslik.academic.time_bank_backend.entity.Offer;
import com.github.kamilcieslik.academic.time_bank_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfferRepository extends JpaRepository<Offer, Integer> {
    List<Offer> findOffersByGiver(User giver);
    List<Offer> findOffersByReceiver(User receiver);
}
