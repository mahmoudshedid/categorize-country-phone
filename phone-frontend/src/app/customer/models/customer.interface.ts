import { BaseModel } from "../../common/models/base.model";

export interface ICustomer extends BaseModel {
    name: string;
    phone: string;
    valid: false;
}