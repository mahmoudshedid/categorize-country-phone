import { Resource } from "./resource";

export abstract class BaseModel extends Resource {
    id!: number;
}