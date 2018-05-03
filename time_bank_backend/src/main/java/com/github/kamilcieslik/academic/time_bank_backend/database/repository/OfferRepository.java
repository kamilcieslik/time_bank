package com.github.kamilcieslik.academic.time_bank_backend.database.repository;

import com.github.kamilcieslik.academic.time_bank_backend.database.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepository extends JpaRepository<Offer, Integer> {
}
