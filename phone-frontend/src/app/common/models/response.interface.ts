import { BaseResponse } from "./base.response";

export interface IResponse extends BaseResponse {
    code: number;
    status: string;
    message: string;
}