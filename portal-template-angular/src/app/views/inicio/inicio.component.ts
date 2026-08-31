import { Component, inject } from '@angular/core';
import { CardComponent } from '../../components/card/card.component';
import { PerfilService } from '../../services/perfil.service';
import { Perfil } from '../../models/perfil.interface';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { Categoria } from '../../models/categoria.interface';
import { CategoriaService } from '../../services/categoria.service';
import { PortalService } from '../../services/portal.service';
import { Portal } from '../../models/portal.interface';

@Component({
  selector: 'app-inicio',
  standalone: true,
  imports: [CardComponent, RouterModule],
  templateUrl: './inicio.component.html',
  styleUrl: './inicio.component.css',
})
export default class InicioComponent {
  private router = inject(Router);
  private perfilService = inject(PerfilService);
  private categoriaService = inject(CategoriaService);
  private portalService = inject(PortalService);
  categorias: Categoria[] = [];
  portalesCategoria: { [categoriaID: number]: Portal[] } = {};

  perfil?: Perfil;
  color: string = '';
  bgColor: string = '';

  ngOnInit(): void {
		const idGuardado = localStorage.getItem('perfilId');

		if (!idGuardado) {
   	 	return;
  	}

		const idPerfil = parseInt(idGuardado);

    this.perfilService.getPerfil(idPerfil).subscribe({
			next: (perfil) => {
      this.perfil = perfil;
      this.color = perfil.colorWeb2;
      this.bgColor = perfil.colorWeb1;
			this.loadCategorias(perfil.id);
    },
			error: (error) => {
				console.error('Error al obtener el perfil:', error);

				localStorage.removeItem('perfilId');
				this.router.navigate(['/perfil']);
			},
		});
  }

  loadCategorias(perfilId: number) {
    this.categoriaService.listCategorias(perfilId).subscribe((categorias) => {
      this.categorias = categorias;

      this.categorias.forEach((categoria) => {
        this.loadPortales(perfilId, categoria.id);
      });
    });
  }

  loadPortales(perfilId: number,categoriaID: number) {
    this.portalService.listPortales(perfilId, categoriaID).subscribe((portales) => {
      this.portalesCategoria[categoriaID] = portales;
    });
  }

  editarPortal(categoriaId: number, portalId: number) {
    this.router.navigate(['categoria', categoriaId, 'portal', portalId, 'editar']);
  }

  deleteCategoria(categoria: Categoria) {
		if (!this.perfil) {
      return;
    }

    const perfilId = this.perfil.id;
    this.categoriaService.deleteCategoria(categoria.id, perfilId).subscribe(() => {
      this.loadCategorias(perfilId);
    });
  }

  deletePortal(categoriaID: number, portal: Portal) {
		if (!this.perfil) {
      return;
    }

    const perfilId = this.perfil.id;
    this.portalService.deletePortal(perfilId, categoriaID, portal.id).subscribe(() => {
      this.loadCategorias(perfilId);
    });
  }
}