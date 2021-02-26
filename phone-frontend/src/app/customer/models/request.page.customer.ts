import { BasePageRequest } from "src/app/common/models/base.page.request";

export interface RequestPageCustomer extends BasePageRequest {
    code: string;
    country: string,
}