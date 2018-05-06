import { Component, OnInit } from '@angular/core';
import {User} from "../../dto/user.model";
import {Offer} from "../../dto/offer.model";
import {HttpClient} from "@angular/common/http";
import {UserService} from "../../services/user/user.service";
import {OfferService} from "../../services/offer/offer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-taken-offers',
  templateUrl: './taken-offers.component.html',
  styleUrls: ['./taken-offers.component.css']
})
export class TakenOffersComponent implements OnInit {
    public offers: Offer[];

    constructor(private offerService: OfferService, public router: Router, private http: HttpClient, private userService: UserService) {
    }

    ngOnInit() {
        this.offerService.getTakenOffers(this.userService.user.id).subscribe(data => {
            this.offers = data;
        });
    }

    getGiver(giver: User) {
        if (giver!=null)
          return giver.firstName + " " + giver.lastName;
        else
          return "---"
    }

    calculateTime(dateFrom: string, dateTo: string) {
        let diffInMs: number = (Date.parse(dateTo) - Date.parse(dateFrom)) / 1000;

        let hours: number = Math.floor(diffInMs / 3600) % 24;
        diffInMs -= hours * 3600;

        let minutes: number = Math.floor(diffInMs / 60) % 60;
        diffInMs -= minutes * 60;

        let seconds: number = diffInMs % 60;  // in theory the modulus is not required

        return hours + " godzin, " + minutes + " minut, " + seconds + " sekund";
    }
}
