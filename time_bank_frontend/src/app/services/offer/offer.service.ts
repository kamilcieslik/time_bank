import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Offer} from "../../dto/offer.model";
import {Observable} from "rxjs/Observable";

@Injectable()
export class OfferService {

    offer: Offer;
    offers: Array<Offer>;

    constructor(private http: HttpClient) {
    }

    saveOffer(offer: Offer) {
        const promise = new Promise((resolve, reject) => {
            this.http.post('/offers/save', offer).toPromise().then(res => {
                    if (res != null) {
                        resolve();
                    } else {
                        reject();
                    }
                },
                (err) => {
                    console.log(err);
                });
        });
        return promise;
    }

    getActiveOffers(userId): Observable<any> {
        return this.http.get('/offers/active/' + userId);
    }

    getTakenOffers(userId): Observable<any> {
        return this.http.get('/offers/takenOffers/' + userId);
    }

    getGivenOffers(userId): Observable<any> {
        return this.http.get('/offers/givenOffers/' + userId);
    }
}