import { BaseSerializer } from "src/app/common/models/base.serializer";
import { IRequestCustomer } from "./request.customer";

export class RequestCustomerSerializer implements BaseSerializer {
    fromJson(json: any): IRequestCustomer {
        const requestCustomer = {} as IRequestCustomer;
        requestCustomer.code = json.code;
        requestCustomer.status = json.status;
        requestCustomer.message = json.message;
        requestCustomer.data = json.data;
        requestCustomer.dataPage = json.dataPage
        
        return requestCustomer;
    }
}