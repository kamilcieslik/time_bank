import { Injectable } from '@angular/core';
import {Address} from "../../dto/address.model";
import {Observable} from "rxjs/Observable";
import {HttpClient} from "@angular/common/http";

@Injectable()
export class AddressService {
    address: Address;

    constructor(private http: HttpClient) { }



}
