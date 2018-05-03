import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {UserService} from '../../services/user/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  login: string;
  password: string;
  constructor(private router: Router, private userService: UserService) { }

  ngOnInit() {
  }
  loginUser() {
    this.userService.loginUser(this.login, this.password).then(
        () => {
            this.router.navigateByUrl('/main');
        }, () => {
            this.router.navigateByUrl(''); });
  }
  goToSignupPage() {
      this.router.navigateByUrl('/signup');
  }

}
