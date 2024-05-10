import { Portal } from "./portal.interface";

export interface Categoria {
    id:         number;
    nombre:     string;
    portales:   Array<Portal>
}
