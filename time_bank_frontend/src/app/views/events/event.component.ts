import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-event',
  templateUrl: './event.component.html',
  styleUrls: []
})
export class EventComponent implements OnInit {

  events: any;
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get('/events').subscribe(data => {
      this.events = data;
    });
  }

}
