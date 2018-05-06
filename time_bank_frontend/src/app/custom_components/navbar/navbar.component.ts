import {Component, HostListener, Input, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {
    @Input() activeMenu: string;
    isCollapsed: boolean;
    currentModuleName = "Time Bank";

    constructor(private router: Router) {
        this.isCollapsed = true;
    }

    ngOnInit() {
        if (window.innerWidth < 767 && this.activeMenu != 'Wyloguj')
            this.currentModuleName = this.activeMenu;
        else if (window.innerWidth < 875)
            this.currentModuleName = "";
        else
            this.currentModuleName = "Time Bank";
    }

    @HostListener('window:resize', ['$event'])
    onResize(event) {
        if (event.target.innerWidth < 767)
            this.currentModuleName = this.activeMenu;
        else if (event.target.innerWidth < 875)
            this.currentModuleName = "";
        else
            this.currentModuleName = "Time Bank";
    }
}
