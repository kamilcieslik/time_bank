import { Component, OnInit } from '@angular/core';
import {User} from '../../dto/user.model';
import {Router} from '@angular/router';
import {UserService} from '../../services/user/user.service';
@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  user: User = new User();

  constructor( private router: Router, private userService: UserService) { }

  ngOnInit() {
  }

  saveUser() {
      this.userService.checkIfExist(this.user.login, this.user.email).then(
          (val) => {
              if (!val) {
                  this.userService.saveUser(this.user);
                  this.router.navigateByUrl('');
              } else { this.router.navigateByUrl('signup'); }
          });
  }

}
