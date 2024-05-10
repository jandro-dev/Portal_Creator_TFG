import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: '',
    loadComponent: () => import('./views/inicio/inicio.component'),
  },
  {
    path: 'perfil',
    loadComponent: () => import('./views/perfil/perfil.component'),
  },
  {
    path: 'categoria',
    loadComponent: () => import('./views/categoria/categoria.component'),
  },
  {
    path: 'portal',
    loadComponent: () => import('./views/portal/portal.component'),
  },
  {
    path: 'notfound',
    loadComponent: () => import('./views/notfound/notfound.component'),
  },
  {
    path: '**',
    redirectTo: 'notfound',
  },
];
