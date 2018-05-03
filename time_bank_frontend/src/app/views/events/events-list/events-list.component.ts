import { Component, OnInit } from '@angular/core';
import {EventService} from "../../../services/event/event.service";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {Event} from "../../../dto/event.model";

@Component({
    selector: 'app-events-list',
    templateUrl: './events-list.component.html',
    styleUrls: ['./events-list.component.css']
})
export class EventsListComponent implements OnInit {
    //events: Array<Event>;
    public events: Event[];
    constructor(private eventService: EventService, public router: Router) { }


    ngOnInit() {

        this.eventService.getEvents().subscribe(data => {
            this.events = data;
        });

    }

    /*
    ngOnInit() {
        this.eventService.getEvent()
            .map((event: Array<any>) => {
                let result:Array<Event> = [];
                if (event) {
                    event.forEach((erg) => {
                        result.push(new Event(erg.id,erg.name,erg.description,erg.dateFrom,erg.dateTo,erg.address));
                    });
                }
                return event;
            })
            .subscribe(event => this.events = event);
    }
    */
    deleteUser(event: Event): void {
        this.eventService.deleteEvent(event).subscribe( data => {
            this.events = this.events.filter(u => u !== event);
        })
    };

    editEvent(){
        this.router.navigateByUrl('/selected-event');
    }


}
