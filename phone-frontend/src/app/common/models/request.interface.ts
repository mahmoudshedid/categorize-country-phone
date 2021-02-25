import { Page } from "./page.interface";
import { Resource } from "./resource"

export interface IRequest<T extends Resource> {
    code: number;
    status: string;
    message: string;
    data: T;
    dataPage: Page<T>
}