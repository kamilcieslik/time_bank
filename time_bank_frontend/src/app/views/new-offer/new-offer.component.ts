import {Component, OnInit} from '@angular/core';
import {UserService} from "../../services/user/user.service";
import {OfferService} from "../../services/offer/offer.service";
import {Router} from "@angular/router";
import {Offer} from "../../dto/offer.model";

@Component({
    selector: 'app-new-offer',
    templateUrl: './new-offer.component.html',
    styleUrls: ['./new-offer.component.css']
})
export class NewOfferComponent implements OnInit {
    offer: Offer = new Offer();

    constructor(public router: Router, private offerService: OfferService, private userService: UserService) {
    }

    ngOnInit() {
    }

    createOffer() {
        console.log(this.offer)

        if (this.offer.type) {
            this.offer.type = true;
            this.offer.giver = this.userService.user.id;
        }
        else {
            this.offer.type = false;
            this.offer.receiver = this.userService.user.id;
        }

        this.offerService.saveOffer(this.offer).then(
            () => {
                this.router.navigateByUrl('/receive-offer');
            });
    }
}
