import { Request } from "./request";

export abstract class BasePageRequest extends Request {
    page!: number;
    size!: number;
    sortDir!: string;
    sort!: string;
}