package com.github.kamilcieslik.academic.time_bank_backend.database.service;

import com.github.kamilcieslik.academic.time_bank_backend.entity.Offer;
import com.github.kamilcieslik.academic.time_bank_backend.database.repository.OfferRepository;
import com.github.kamilcieslik.academic.time_bank_backend.entity.User;
import com.github.kamilcieslik.academic.time_bank_backend.entity.additional_classes.Statistics;
import com.github.kamilcieslik.academic.time_bank_backend.time_bank_services.OfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Qualifier("database")
public class OfferDbServiceImpl implements OfferService {
    private final OfferRepository offerRepository;

    @Autowired
    public OfferDbServiceImpl(OfferRepository offerRepository) {
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

    @Override
    public Statistics getUserStatistics(User user) {
        List<Offer> givenOffers = offerRepository.findOffersByGiver(user);
        List<Offer> takenOffers = offerRepository.findOffersByReceiver(user);

        Integer numberOfGivenOffers = givenOffers.size();
        Integer numberOfTakenOffers = takenOffers.size();

        AtomicReference<Long> numberOfGivenSeconds = new AtomicReference<>(0L);
        givenOffers.forEach(offer -> numberOfGivenSeconds.updateAndGet(v -> v + TimeUnit.MILLISECONDS
                .toSeconds(offer.getDateTo().getTime() - offer.getDateFrom().getTime())));

        Long givenTimeDays = TimeUnit.SECONDS.toDays(numberOfGivenSeconds.get());
        Long givenTimeHours = TimeUnit.SECONDS.toHours(numberOfGivenSeconds.get()) - (givenTimeDays * 24);
        Long givenTimeMinutes = TimeUnit.SECONDS.toMinutes(numberOfGivenSeconds.get())
                - (TimeUnit.SECONDS.toHours(numberOfGivenSeconds.get()) * 60);
        Long givenTimeSeconds = TimeUnit.SECONDS.toSeconds(numberOfGivenSeconds.get())
                - (TimeUnit.SECONDS.toMinutes(numberOfGivenSeconds.get()) * 60);

        AtomicReference<Long> numberOfTakenSeconds = new AtomicReference<>(0L);
        takenOffers.forEach(offer -> numberOfTakenSeconds.updateAndGet(v -> v + TimeUnit.MILLISECONDS
                .toSeconds(offer.getDateTo().getTime() - offer.getDateFrom().getTime())));

        Long takenTimeDays = TimeUnit.SECONDS.toDays(numberOfTakenSeconds.get());
        Long takenTimeHours = TimeUnit.SECONDS.toHours(numberOfTakenSeconds.get()) - (takenTimeDays * 24);
        Long takenTimeMinutes = TimeUnit.SECONDS.toMinutes(numberOfTakenSeconds.get())
                - (TimeUnit.SECONDS.toHours(numberOfTakenSeconds.get()) * 60);
        Long takenTimeSeconds = TimeUnit.SECONDS.toSeconds(numberOfTakenSeconds.get())
                - (TimeUnit.SECONDS.toMinutes(numberOfTakenSeconds.get()) * 60);

        return new Statistics(numberOfGivenOffers, numberOfTakenOffers, givenTimeDays, givenTimeHours, givenTimeMinutes,
                givenTimeSeconds, takenTimeDays, takenTimeHours, takenTimeMinutes, takenTimeSeconds);
    }
}
