import { Injectable } from '@angular/core';
import {User} from "../dto/user.model";

@Injectable()
export class Globals {
    public user: User;
}
