import { IRequest } from "src/app/common/models/request.interface";
import { ICustomer } from "./customer.interface";

export interface IRequestCustomer extends IRequest<ICustomer> {
}