import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {UserService} from '../../services/user/user.service';
import {Globals} from "../../logged_user/logged_user";
import {User} from "../../dto/user.model";
import {Observable} from "rxjs/Observable";

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.css'],

})
export class LoginComponent implements OnInit {
    login: string;
    password: string;
    public user: Observable<User>;

    constructor(private router: Router, private userService: UserService, private global: Globals) {
    }

    ngOnInit() {
    }

    loginUser() {
        this.userService.loginUser(this.login, this.password).then(
            () => {
                this.router.navigateByUrl('/receive-offer');
            },
            () => {
                this.router.navigateByUrl('');
            });
    }

    goToSignupPage() {
        this.router.navigateByUrl('/signup');
    }

}
