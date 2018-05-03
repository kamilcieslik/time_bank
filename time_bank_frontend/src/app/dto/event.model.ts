
import {Address} from "./address.model";

export class Event {
    constructor();
    constructor(
        id: string,
        name: string,
        description: string,
        dateFrom: any,
        dateTo: any,
        address: Address);

    constructor(
        id?: string,
        name?: string,
        description?: string,
        dateFrom?: any,
        dateTo?: any,
        address?: Address
    ){
        this.id = id;
        this.name = name;
        this.description = name;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.address = address;
    }



    public id: string;
    public name: string;
    public description: string;
    public dateFrom: any;
    public dateTo: any;
    public address: Address;
}
