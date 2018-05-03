import {Component, Input, OnInit} from '@angular/core';
import {Event} from '../../dto/event.model';

@Component({
  selector: 'app-list-elem-event',
  templateUrl: './list-elem-event.component.html',
  styleUrls: ['./list-elem-event.component.css']
})
export class ListElemEventComponent implements OnInit {
    @Input() event: Event;

  constructor() { }

  ngOnInit() {
  }

}
