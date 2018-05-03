import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Event} from '../../dto/event.model';
import { Http, Response, Headers, RequestOptions } from '@angular/http';
import {Observable} from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable()
export class EventService {

    event: Event;
    events: Array<Event>;
    constructor(private http: HttpClient) { }

    saveEvent(event: Event) {
        const promise = new Promise((resolve, reject) => {
            this.http.post('/events', event).toPromise().then(res => {
                    if ( res != null) {
                        resolve();
                    } else { reject(); }
                },
                (err) => {
                    console.log(err);
                });
        });
        return promise;
    }

    getEvents() : Observable<any>{
        return this.http.get('/events');
    }

    get(id: string) {
        return this.http.get('/events/' + '/' + id);
    }

    updateEvent(id: string,event:any){
        return this.http.post('/events/' + '/' + id,event);
    }
    public deleteEvent(event) {
        return this.http.delete('/events/'+ event.id);
    }


    private extractData(response: Response) {
        let body = response.json();
        return body || {};
    }

    private handleError(error: Response) {
        console.log(error);
        return Observable.throw(error.json().error || "500 internal server error");
    }






}
