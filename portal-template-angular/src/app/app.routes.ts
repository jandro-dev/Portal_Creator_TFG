import { Routes } from '@angular/router';
import { WebComponent } from './views/web/web.component';
import { InicioComponent } from './views/inicio/inicio.component';
import { PerfilComponent } from './views/perfil/perfil.component';
import { CategoriaComponent } from './views/categoria/categoria.component';
import { PortalComponent } from './views/portal/portal.component';
import { NotfoundComponent } from './views/notfound/notfound.component';

export const routes: Routes = [
  {
    path: '',
    component: InicioComponent,
  },
  {
    path: 'web',
    component: WebComponent,
  },
  {
    path: 'perfil',
    component: PerfilComponent,
  },
  {
    path: 'categoria',
    component: CategoriaComponent,
  },
  {
    path: 'portal',
    component: PortalComponent,
  },
  {
    path: 'notfound',
    component: NotfoundComponent,
  },
  {
    path: '**',
    redirectTo: 'notfound',
  },
];
