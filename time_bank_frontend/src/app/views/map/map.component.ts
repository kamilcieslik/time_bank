import {Component, HostListener, OnDestroy, OnInit} from '@angular/core';
import {EventService} from "../../services/event/event.service";

@Component({
    selector: 'app-map',
    templateUrl: './map.component.html',
    styleUrls: ['./map.component.css']
})
export class MapComponent implements OnInit, OnDestroy {
    latitude = 51.1078852;
    longitude = 17.0385376;
    mapTypes = ['hybrid', 'roadmap', 'satellite', 'terrain'];
    mapTypeId = 0;
    events: Event[];

    arrows = ["/assets/img/map_view/arrow_up_white.png", "/assets/img/map_view/arrow_up_black.png"];
    isEventsListOnScreen: boolean;
    imageNumber = 0;
    arrowBottomMarginWithoutList: string;
    arrowBottomMarginWithList: string;

    constructor(private eventService: EventService) {
        document.body.style.overflowY = "hidden";


    }

    ngOnDestroy(): void {
        document.body.style.overflowY = "auto";
    }

    ngOnInit() {
        if (window.innerWidth < 320){
            this.arrowBottomMarginWithList = "300px";
            this.arrowBottomMarginWithoutList = "60px";
        }
        else if (window.innerWidth < 451){
            this.arrowBottomMarginWithList = "310px";
            this.arrowBottomMarginWithoutList = "70px";
        }
        else{
            this.arrowBottomMarginWithList = "290px";
            this.arrowBottomMarginWithoutList = "50px";
        }
    }

    @HostListener('window:resize', ['$event'])
    onResize(event) {
        if (event.target.innerWidth < 320){
            this.arrowBottomMarginWithList = "300px";
            this.arrowBottomMarginWithoutList = "60px";
        }
        else if (event.target.innerWidth < 451){
            this.arrowBottomMarginWithList = "310px";
            this.arrowBottomMarginWithoutList = "70px";
        }
        else{
            this.arrowBottomMarginWithList = "290px";
            this.arrowBottomMarginWithoutList = "50px";
        }
    }


    changeMapTypeId() {
        let currentMapTypeId = this.mapTypeId;
        currentMapTypeId++;
        if (currentMapTypeId > 3)
            currentMapTypeId = 0;
        this.mapTypeId = currentMapTypeId;

        if (this.mapTypeId == 0 || this.mapTypeId == 2)
            this.imageNumber = 0;
        else
            this.imageNumber = 1;
    }

    displayEventsListOnScreen() {
        this.isEventsListOnScreen = !this.isEventsListOnScreen;

        if (this.isEventsListOnScreen==true)
            this.arrows = ["/assets/img/map_view/arrow_down_white.png", "/assets/img/map_view/arrow_down_black.png"];
        else
            this.arrows = ["/assets/img/map_view/arrow_up_white.png", "/assets/img/map_view/arrow_up_black.png"];
    }

    getEvents() {
        this.eventService.getEvents().subscribe(data => {
            this.events = data;
        });
    }
}
