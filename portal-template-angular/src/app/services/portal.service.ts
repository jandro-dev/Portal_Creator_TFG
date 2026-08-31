import { HttpClient } from '@angular/common/http';
import { Injectable, inject } from '@angular/core';
import { Portal } from '../models/portal.interface';

@Injectable({
  providedIn: 'root',
})
export class PortalService {
  private http = inject(HttpClient);
  private urlBase = 'https://portalcreator.onrender.com/api/categorias';

  listPortales(perfilId: number, categoriaID: number) {
    return this.http.get<Portal[]>(`${this.urlBase}/${categoriaID}/portales?perfilId=${perfilId}`);
  }

  getPortal(perfilId: number, categoriaID: number, portalID: number) {
    return this.http.get<Portal>(
      `${this.urlBase}/${categoriaID}/portales/${portalID}?perfilId=${perfilId}`
    );
  }

  createPortal(perfilId: number, categoriaID: number, portal: Portal) {
    return this.http.post<Portal>(
      `${this.urlBase}/${categoriaID}/portales?perfilId=${perfilId}`,
      portal
    );
  }

  updatePortal(perfilId: number, categoriaID: number, portalID: number, portal: Portal) {
    return this.http.put<Portal>(
      `${this.urlBase}/${categoriaID}/portales/${portalID}?perfilId=${perfilId}`,
      portal
    );
  }

  deletePortal(perfilId: number, categoriaID: number, portalID: number) {
    return this.http.delete<void>(
      `${this.urlBase}/${categoriaID}/portales/${portalID}?perfilId=${perfilId}`
    );
  }
}
