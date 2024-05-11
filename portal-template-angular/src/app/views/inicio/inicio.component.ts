import { Component, inject } from '@angular/core';
import { CardComponent } from '../../components/card/card.component';
import { PerfilService } from '../../services/perfil.service';
import { Perfil } from '../../models/perfil.interface';
import { RouterModule } from '@angular/router';
import { Categoria } from '../../models/categoria.interface';
import { CategoriaService } from '../../services/categoria.service';

@Component({
  selector: 'app-inicio',
  standalone: true,
  imports: [CardComponent, RouterModule],
  templateUrl: './inicio.component.html',
  styleUrl: './inicio.component.css',
})
export default class InicioComponent {
  private perfilService = inject(PerfilService);
  private categoriaService = inject(CategoriaService);
  categorias: Categoria[] = [];

  perfil?: Perfil;
  color: string = '';
  bgColor: string = '';

  ngOnInit(): void {
    this.perfilService.getPerfil(1).subscribe((perfil) => {
      this.perfil = perfil;
      this.color = perfil.colorWeb2;
      this.bgColor = perfil.colorWeb1;
    });
    this.loadCategorias();
  }

  loadCategorias() {
    this.categoriaService.listCategorias().subscribe((categorias) => {
      this.categorias = categorias;
    });
  }

  deleteCategoria(categoria: Categoria) {
    this.categoriaService.deleteCategoria(categoria.id).subscribe(() => {
      this.loadCategorias();
    });
  }
}
