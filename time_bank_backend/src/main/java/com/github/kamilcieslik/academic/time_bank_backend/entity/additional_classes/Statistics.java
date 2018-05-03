package com.github.kamilcieslik.academic.time_bank_backend.entity.additional_classes;

public class Statistics {
    private Integer numberOfGivenOffers;
    private Integer numberOfTakenOffers;
    private Long givenTimeDays;
    private Long givenTimeHours;
    private Long givenTimeMinutes;
    private Long givenTimeSeconds;
    private Long takenTimeDays;
    private Long takenTimeHours;
    private Long takenTimeMinutes;
    private Long takenTimeSeconds;

    public Statistics() {
    }

    public Statistics(Integer numberOfGivenOffers, Integer numberOfTakenOffers, Long givenTimeDays, Long givenTimeHours,
                      Long givenTimeMinutes, Long givenTimeSeconds, Long takenTimeDays, Long takenTimeHours,
                      Long takenTimeMinutes, Long takenTimeSeconds) {
        this.numberOfGivenOffers = numberOfGivenOffers;
        this.numberOfTakenOffers = numberOfTakenOffers;
        this.givenTimeDays = givenTimeDays;
        this.givenTimeHours = givenTimeHours;
        this.givenTimeMinutes = givenTimeMinutes;
        this.givenTimeSeconds = givenTimeSeconds;
        this.takenTimeDays = takenTimeDays;
        this.takenTimeHours = takenTimeHours;
        this.takenTimeMinutes = takenTimeMinutes;
        this.takenTimeSeconds = takenTimeSeconds;
    }

    public Integer getNumberOfGivenOffers() {
        return numberOfGivenOffers;
    }

    public Integer getNumberOfTakenOffers() {
        return numberOfTakenOffers;
    }

    public Long getGivenTimeDays() {
        return givenTimeDays;
    }

    public Long getGivenTimeHours() {
        return givenTimeHours;
    }

    public Long getGivenTimeMinutes() {
        return givenTimeMinutes;
    }

    public Long getGivenTimeSeconds() {
        return givenTimeSeconds;
    }

    public Long getTakenTimeDays() {
        return takenTimeDays;
    }

    public Long getTakenTimeHours() {
        return takenTimeHours;
    }

    public Long getTakenTimeMinutes() {
        return takenTimeMinutes;
    }

    public Long getTakenTimeSeconds() {
        return takenTimeSeconds;
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "numberOfGivenOffers=" + numberOfGivenOffers +
                ", numberOfTakenOffers=" + numberOfTakenOffers +
                ", givenTimeDays=" + givenTimeDays +
                ", givenTimeHours=" + givenTimeHours +
                ", givenTimeMinutes=" + givenTimeMinutes +
                ", givenTimeSeconds=" + givenTimeSeconds +
                ", takenTimeDays=" + takenTimeDays +
                ", takenTimeHours=" + takenTimeHours +
                ", takenTimeMinutes=" + takenTimeMinutes +
                ", takenTimeSeconds=" + takenTimeSeconds +
                '}';
    }
}
