import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AgmCoreModule} from '@agm/core';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule, Routes} from '@angular/router';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {AppComponent} from './app.component';
import {EventComponent} from './views/events/event.component';
import {NavbarComponent} from './custom_components/navbar/navbar.component';
import {FriendsComponent} from './views/friends/friends.component';
import {GroupsComponent} from './views/groups/groups.component';
import {MapComponent} from './views/map/map.component';
import { ProfileComponent } from './views/profile/profile.component';
import { SignupComponent } from './views/signup/signup.component';
import {UserService} from './services/user/user.service';
import {EventService} from './services/event/event.service';

import { LoginComponent } from './custom_components/login/login.component';
import { EventsListComponent } from './views/events/events-list/events-list.component';
import { NewEventComponent } from './views/events/new-event/new-event.component';
import { SelectedEventComponent } from './views/events/selected-event/selected-event.component';

import { HashtagsComponent } from './views/hashtags/hashtags.component';
import { HistoryComponent } from './views/history/history.component';
import {LogoutComponent} from './views/logout/logout.component';
import { EventsFilterComponent } from './custom_components/events-filter/events-filter.component';
import { ListElemEventComponent } from './custom_components/list-elem-event/list-elem-event.component';

const appRoutes: Routes = [
    {
        path: 'login',
        component: LoginComponent,
    },
    {
        path: 'map',
        component: MapComponent,
    },
    {
        path: 'events',
        component: EventComponent,
    },
    {
        path: 'friends',
        component: FriendsComponent,
    },
    {
        path: 'groups',
        component: GroupsComponent,
    },
    {
        path: 'profile',
        component: ProfileComponent,
    },
    {
        path: 'history',
        component: HistoryComponent,
    },
    {
        path: 'hashtags',
        component: HashtagsComponent,
    },
    {
        path: 'logout',
        component: LogoutComponent,
    },
    {
        path: 'signup',
        component: SignupComponent,
    },
    {
        path: 'selected-event/:id',
        component: SelectedEventComponent,
    },
    {
        path: '',
        redirectTo: '/map',
        pathMatch: 'full'
    }
];

@NgModule({
    declarations: [
        AppComponent,
        EventComponent,
        NavbarComponent,
        FriendsComponent,
        GroupsComponent,
        MapComponent,
        ProfileComponent,
        SignupComponent,
        LoginComponent,
        EventsListComponent,
        NewEventComponent,
        SelectedEventComponent,
        HashtagsComponent,
        HistoryComponent,
        LogoutComponent,
        EventsFilterComponent,
        ListElemEventComponent
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule,
        AgmCoreModule.forRoot({
           apiKey:'AIzaSyBEmx5P3vl4ox4OU6nPgwTbU9k-_0Zm6Lo'
        }),
        RouterModule.forRoot(
            appRoutes,
            {enableTracing: true} // <-- debugging purposes only
        ),
        NgbModule.forRoot()
    ],

    providers: [UserService, EventService],
    bootstrap: [AppComponent]
})
export class AppModule {
}
