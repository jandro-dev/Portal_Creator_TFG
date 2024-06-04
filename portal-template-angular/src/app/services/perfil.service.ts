import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Perfil } from '../models/perfil.interface';

@Injectable({
  providedIn: 'root',
})
export class PerfilService {
  private http = inject(HttpClient);
  private urlBase = 'https://portalcreator.onrender.com/api/perfil';

  getPerfil(id: number) {
    return this.http.get<Perfil>(`${this.urlBase}/${id}`);
  }

  createPerfil(perfil: Perfil) {
    return this.http.post<Perfil>(`${this.urlBase}`, perfil);
  }

  updatePerfil(id: number, perfil: Perfil) {
    return this.http.put<Perfil>(`${this.urlBase}/${id}`, perfil);
  }
}
