import { BaseSerializer } from "src/app/common/models/base.serializer";
import { ICustomer } from "./customer.interface";

export class CustomerSerializer implements BaseSerializer {
    fromJson(json: any): ICustomer {
        const customer = {} as ICustomer;

        customer.id = json.id;
        customer.name = json.name;
        customer.phone = json.phone;
        customer.phoneValid = json.phoneValid;

        return customer;
    }
}