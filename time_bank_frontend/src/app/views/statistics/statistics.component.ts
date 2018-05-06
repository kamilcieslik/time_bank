import {Component, OnInit} from '@angular/core';
import {Statistics} from "../../dto/statistics.model";
import {Router} from "@angular/router";
import {OfferService} from "../../services/offer/offer.service";
import {HttpClient} from "@angular/common/http";
import {UserService} from "../../services/user/user.service";

@Component({
    selector: 'app-statistics',
    templateUrl: './statistics.component.html',
    styleUrls: ['./statistics.component.css']
})
export class StatisticsComponent implements OnInit {

    public statistics: Statistics;

    constructor(private eventService: OfferService, public router: Router, private http: HttpClient, private userService: UserService) {
    }

    ngOnInit() {
        this.getStatistics().subscribe(data => {
            this.statistics = data;
        });
    }

    getStatistics(): any {
        return this.http.get('/offers/statistics/' + this.userService.user.id);
    }

    getOffersTime(type: boolean) {
        if (type==true)
            return this.statistics.givenTimeDays + " D, " + this.statistics.givenTimeHours + " H, "
                + this.statistics.givenTimeMinutes + " M, " + this.statistics.givenTimeSeconds + "S";
        else
            return this.statistics.takenTimeDays + " D, " + this.statistics.takenTimeHours + " H, "
                + this.statistics.takenTimeMinutes + " M, " + this.statistics.takenTimeSeconds + "S";
    }
}
