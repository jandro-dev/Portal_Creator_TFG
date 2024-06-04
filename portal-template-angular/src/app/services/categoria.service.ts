import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Categoria } from '../models/categoria.interface';

@Injectable({
  providedIn: 'root',
})
export class CategoriaService {
  private http = inject(HttpClient);
  private urlBase = 'https://portalcreator.onrender.com/api/perfil/1/api/categorias';

  listCategorias() {
    return this.http.get<Categoria[]>(`${this.urlBase}`);
  }

  getCategoria(id: number) {
    return this.http.get<Categoria>(`${this.urlBase}/${id}`);
  }

  createCategoria(categoria: Categoria) {
    return this.http.post<Categoria>(`${this.urlBase}`, categoria);
  }

  updateCategoria(id: number, categoria: Categoria) {
    return this.http.put<Categoria>(`${this.urlBase}/${id}`, categoria);
  }

  deleteCategoria(id: number) {
    return this.http.delete<void>(`${this.urlBase}/${id}`);
  }
}
