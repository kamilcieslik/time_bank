import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {EventService} from "../../../services/event/event.service";
import {Subscription} from "rxjs/Subscription";
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-selected-event',
  templateUrl: './selected-event.component.html',
  styleUrls: ['./selected-event.component.css']
})
export class SelectedEventComponent implements OnInit {

    event: any = {};

    sub: Subscription;
    constructor(private route: ActivatedRoute,
                private router: Router,
                private eventService: EventService, private http: HttpClient ) {
    }

    ngOnInit() {
        console.log(`event with id`);
        this.sub = this.route.params.subscribe(params => {
            const id = params['id'];
            if (id) {
                this.eventService.get(id).subscribe((event: any) => {
                    if (event) {
                        this.event = event;
                        this.event.href = event._links.self.href;
                        console.log(`event with id '${id}' `);
                    } else {
                        console.log(`event with id '${id}' not found, returning to list`);
                        this.gotoList();
                    }
                });
            }
        });
    }

    gotoList() {
        this.router.navigate(['/events']);
    }

    updateEvent(id,event) {
        this.http.put('/events/'+id, event)
            .subscribe(res => {
                    let id = res['id'];
                    this.router.navigate(['/events']);
                }, (err) => {
                    console.log(err);
                }
            );
    }

}
