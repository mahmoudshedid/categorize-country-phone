import { BaseModel } from "src/app/common/models/base.model";

export interface ICountry extends BaseModel {
    country: string;
    code: string;
}