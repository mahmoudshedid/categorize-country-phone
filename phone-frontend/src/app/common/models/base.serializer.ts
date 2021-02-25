import { Resource } from "./resource";
import { Serializer } from "./serializer";

export interface BaseSerializer extends Serializer {
    fromJson(json: any): Resource;
}