import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Categoria } from '../models/categoria.interface';

@Injectable({
  providedIn: 'root',
})
export class CategoriaService {
  private http = inject(HttpClient);
  private urlBase = 'https://portalcreator.onrender.com/api/categorias';

  listCategorias(perfilId: number) {
    return this.http.get<Categoria[]>(`${this.urlBase}?perfilId=${perfilId}`);
  }

  getCategoria(id: number, perfilId: number) {
    return this.http.get<Categoria>(`${this.urlBase}/${id}?perfilId=${perfilId}`);
  }

  createCategoria(perfilId: number, categoria: Categoria) {
    return this.http.post<Categoria>(`${this.urlBase}?perfilId=${perfilId}`, categoria);
  }

  updateCategoria(id: number, perfilId: number, categoria: Categoria) {
    return this.http.put<Categoria>(`${this.urlBase}/${id}?perfilId=${perfilId}`, categoria);
  }

  deleteCategoria(id: number, perfilId: number) {
    return this.http.delete<void>(`${this.urlBase}/${id}?perfilId=${perfilId}`);
  }
}
