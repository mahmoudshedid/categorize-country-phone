import { BaseSerializer } from "src/app/common/models/base.serializer";
import { IResponsePageCustomer } from "./response.page.customer";

export class ResponsePageCustomerSerializer implements BaseSerializer {
    fromJson(json: any): IResponsePageCustomer {
        const responsePageCustomer = {} as IResponsePageCustomer;

        responsePageCustomer.code = json.code;
        responsePageCustomer.status = json.status;
        responsePageCustomer.message = json.message;
        responsePageCustomer.offset = json.dataPage.pageable.offset;
        responsePageCustomer.page = json.dataPage.pageable.pageNumber;
        responsePageCustomer.size = json.dataPage.pageable.pageSize;
        responsePageCustomer.totalPages = json.dataPage.totalPages;
        responsePageCustomer.totalElements = json.dataPage.totalElements;

        return responsePageCustomer;
    }
}