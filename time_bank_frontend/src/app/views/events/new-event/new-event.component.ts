import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {Address} from "../../../dto/address.model";
import {Event} from "../../../dto/event.model";
import {EventService} from '../../../services/event/event.service';


@Component({
    selector: 'app-new-event',
    templateUrl: './new-event.component.html',
    styleUrls: ['./new-event.component.css']
})

export class NewEventComponent implements OnInit {

    address: Address = new Address();
    event: Event = new Event();
    constructor(public router: Router , private eventService: EventService) { }

    ngOnInit() {
    }

    refresh(){
        this.router.navigate(['/']);
    }

    createEvent() {
        this.event.address = this.address;
        this.eventService.saveEvent(this.event).then(
            () => {
                this.router.navigateByUrl('/main');
                }, () => {
                this.router.navigateByUrl('/events'); });
    }
}
