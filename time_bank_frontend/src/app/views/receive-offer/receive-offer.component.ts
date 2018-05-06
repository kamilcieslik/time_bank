import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user/user.service";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {OfferService} from "../../services/offer/offer.service";
import {Offer} from "../../dto/offer.model";
import {User} from "../../dto/user.model";

@Component({
    selector: 'app-receive-offer',
    templateUrl: './receive-offer.component.html',
    styleUrls: ['./receive-offer.component.css']
})

export class ReceiveOfferComponent implements OnInit {
    public offers: Offer[];

    constructor(private offerService: OfferService, public router: Router, private http: HttpClient, private userService: UserService) {
    }

    ngOnInit() {
        this.offerService.getActiveOffers(this.userService.user.id).subscribe(data => {
            this.offers = data;
        });
    }

    enroll(id) {
        this.http.put('/offers/enroll/' + id, this.userService.user.id).subscribe();
        this.router.navigateByUrl('/statistics');
    }

    getOfferType(type: boolean) {
        if (type == true)
            return "Wręczę czas";
        else
            return "Przyjmę czas";
    }

    getOwner(giver: User, receiver: User) {
        if (giver != null) {
            return giver.firstName + " " + giver.lastName + ", email: " + giver.email + ", nr tel.: " + giver.phone;
        }
        else {
            return receiver.firstName + " " + receiver.lastName + ", email: " + receiver.email + ", nr tel.: " + receiver.phone;
        }
    }
}
