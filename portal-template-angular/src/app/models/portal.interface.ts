import { Categoria } from "./categoria.interface";

export interface Portal {
    id:          number;
    nombre:      string;
    descripcion: string;
    link:        string;
    categoria:   Categoria;
}
