import { Component, inject } from '@angular/core';
import { CardComponent } from '../../components/card/card.component';
import { PerfilService } from '../../services/perfil.service';
import { Perfil } from '../../models/perfil.interface';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-inicio',
  standalone: true,
  imports: [CardComponent, RouterModule],
  templateUrl: './inicio.component.html',
  styleUrl: './inicio.component.css',
})
export default class InicioComponent {
  private perfilService = inject(PerfilService);

  perfil?: Perfil;
  color: string = '';
  bgColor: string = '';

  ngOnInit(): void {
    this.perfilService.getPerfil(1).subscribe((perfil) => {
      this.perfil = perfil;
      this.color = perfil.colorWeb2;
      this.bgColor = perfil.colorWeb1;
    });
  }
}
