import { Injectable } from '@angular/core';
import {User} from '../../dto/user.model';
import {HttpClient} from '@angular/common/http';

@Injectable()
export class UserService {
  user: User;
  constructor(private http: HttpClient) { }

    saveUser(user: User) {
        this.http.post('/users', user)
            .subscribe( (err) => {
                    console.log(err);
                }
            );
    }

    loginUser (login: string, password: string)  {
        const promise = new Promise((resolve, reject) => {
            this.http.get<User>('/users/login', {
                params: {
                    login: login,
                    password: password
                },
            }).toPromise().then(res => {
                if ( res != null) {
                    this.user = res;
                    resolve();
                } else { reject(); }
                },
                (err) => {
                    console.log(err);
                });
        });
        return promise;
    }
    checkIfExist(login: string, email: string) {
        const promise = new Promise((resolve, reject) => {
            this.http.get<boolean>('/users/check', {
                params: {
                    login: login,
                    email: email
                },
            }).toPromise().then(res => {
                resolve(res.valueOf());
            },
                (err) => {
                    console.log(err);
                });
        });
        return promise;
    }
}
