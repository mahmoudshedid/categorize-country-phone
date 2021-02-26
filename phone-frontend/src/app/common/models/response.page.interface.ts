import { IResponse } from "./response.interface";

export interface IResponsePage extends IResponse {
    offset: number;
    page: number;
    size: number;
    totalPages: number;
    totalElements: number;
}