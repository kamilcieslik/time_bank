import {Component, OnInit} from '@angular/core';
import {Offer} from "../../dto/offer.model";
import {HttpClient} from "@angular/common/http";
import {UserService} from "../../services/user/user.service";
import {User} from "../../dto/user.model";
import {OfferService} from "../../services/offer/offer.service";
import {Router} from "@angular/router";

@Component({
    selector: 'app-given-offers',
    templateUrl: './given-offers.component.html',
    styleUrls: ['./given-offers.component.css']
})
export class GivenOffersComponent implements OnInit {
    public offers: Offer[];

    constructor(private offerService: OfferService, public router: Router, private http: HttpClient, private userService: UserService) {
    }

    ngOnInit() {
        this.offerService.getGivenOffers(this.userService.user.id).subscribe(data => {
            this.offers = data;
        });
    }

    // noinspection JSMethodCanBeStatic
    getReceiver(receiver: User) {
        if (receiver != null)
            return receiver.firstName + " " + receiver.lastName;
        else
            return "---"
    }

    // noinspection JSMethodCanBeStatic
    calculateTime(dateFrom: string, dateTo: string) {
        let diffInMs: number = (Date.parse(dateTo) - Date.parse(dateFrom)) / 1000;

        let hours: number = Math.floor(diffInMs / 3600) % 24;
        diffInMs -= hours * 3600;

        let minutes: number = Math.floor(diffInMs / 60) % 60;
        diffInMs -= minutes * 60;

        let seconds: number = diffInMs % 60;

        return hours + " godzin, " + minutes + " minut, " + seconds + " sekund";
    }
}