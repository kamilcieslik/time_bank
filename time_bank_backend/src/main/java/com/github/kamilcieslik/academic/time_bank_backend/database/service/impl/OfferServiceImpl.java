package com.github.kamilcieslik.academic.time_bank_backend.database.service.impl;

import com.github.kamilcieslik.academic.time_bank_backend.database.entity.Offer;
import com.github.kamilcieslik.academic.time_bank_backend.database.repository.OfferRepository;
import com.github.kamilcieslik.academic.time_bank_backend.database.service.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public List<Offer> findAll() {
        return offerRepository.findAll();
    }

    @Override
    public Offer save(Offer offer) {
        return offerRepository.save(offer);
    }

    @Override
    public void delete(Integer id) {
        offerRepository.deleteById(id);
    }

    @Override
    public void delete(Offer offer) {
        offerRepository.delete(offer);
    }

    @Override
    public Offer find(Integer id) {
        return offerRepository.findById(id).orElse(null);
    }
}
