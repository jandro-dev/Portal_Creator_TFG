import { CommonModule } from '@angular/common';
import { Component, OnInit, inject } from '@angular/core';
import { PerfilService } from '../../services/perfil.service';
import { RouterModule } from '@angular/router';
import { Perfil } from '../../models/perfil.interface';

@Component({
  selector: 'navbarComponent',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
})
export class NavbarComponent implements OnInit {
  private perfilService = inject(PerfilService);

  perfil?: Perfil;
  isMenuMovil = true;
  color: string = '#fff';
  bgColor: string = '#1c1c1c';

  // Funcion para entrada / salida menu movil
  alternarMenu() {
    this.isMenuMovil = !this.isMenuMovil;
  }

  ngOnInit(): void {
    this.perfilService.getPerfil(1).subscribe((perfil) => {
      this.perfil = perfil;
      this.color = perfil.colorWeb1;
      this.bgColor = perfil.colorWeb2;
    });
  }
}
