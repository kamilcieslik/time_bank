import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {FormsModule} from '@angular/forms';
import {OwlDateTimeModule, OwlNativeDateTimeModule} from 'ng-pick-datetime';
import {HttpClientModule} from '@angular/common/http';
import {RouterModule, Routes} from '@angular/router';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {AppComponent} from './app.component';
import {UserService} from './services/user/user.service';
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {LoginComponent} from "./views/login/login.component";
import {SignupComponent} from "./views/signup/signup.component";
import {NewOfferComponent} from './views/new-offer/new-offer.component';
import {ReceiveOfferComponent} from './views/receive-offer/receive-offer.component';
import {GivenOffersComponent} from './views/given-offers/given-offers.component';
import {TakenOffersComponent} from './views/taken-offers/taken-offers.component';
import {StatisticsComponent} from './views/statistics/statistics.component';
import {OfferService} from "./services/offer/offer.service";
import {Globals} from "./logged_user/logged_user";
import {NavbarComponent} from "./custom_components/navbar/navbar.component";

const appRoutes: Routes = [
    {
        path: 'login',
        component: LoginComponent,
    },
    {
        path: 'signup',
        component: SignupComponent,
    },
    {
        path: 'new-offer',
        component: NewOfferComponent,
    },
    {
        path: 'receive-offer',
        component: ReceiveOfferComponent,
    },
    {
        path: 'given-offers',
        component: GivenOffersComponent,
    },
    {
        path: 'taken-offers',
        component: TakenOffersComponent,
    },
    {
        path: 'statistics',
        component: StatisticsComponent,
    },
    {
        path: '',
        redirectTo: '/login',
        pathMatch: 'full'
    }
];

@NgModule({
    declarations: [
        AppComponent,
        NavbarComponent,
        SignupComponent,
        LoginComponent,
        NewOfferComponent,
        StatisticsComponent,
        ReceiveOfferComponent,
        GivenOffersComponent,
        TakenOffersComponent,
    ],
    imports: [
        BrowserModule,
        FormsModule,
        HttpClientModule,
        OwlDateTimeModule,
        OwlNativeDateTimeModule,
        BrowserAnimationsModule,
        RouterModule.forRoot(
            appRoutes,
            {enableTracing: true} // <-- debugging purposes only
        ),
        NgbModule.forRoot()
    ],

    providers: [UserService, OfferService, Globals],
    bootstrap: [AppComponent]
})
export class AppModule {
}
