import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Portal } from '../models/portal.interface';

@Injectable({
  providedIn: 'root',
})
export class PortalService {
  
  private http = inject(HttpClient);
  private urlBase = 'localhost:8080/api/categorias';

  listPortales(categoriaID: number) {
    return this.http.get<Portal[]>(`${this.urlBase}/${categoriaID}/portales`);
  }

  getPortal(categoriaID: number, portalID: number) {
    return this.http.get<Portal>(`${this.urlBase}/${categoriaID}/portales/${portalID}`);
  }

  createPortal(categoriaID: number, portal: Portal) {
    return this.http.post<Portal>(`${this.urlBase}/${categoriaID}/portales`, portal);
  }

  updatePortal(categoriaID: number, portalID: number, portal: Portal) {
    return this.http.put<Portal>(`${this.urlBase}/${categoriaID}/portales/${portalID}`, portal);
  }

  deletePortal(categoriaID: number, portalID: number) {
    return this.http.delete<void>(`${this.urlBase}/${categoriaID}/portales/${portalID}`);
  }
}
