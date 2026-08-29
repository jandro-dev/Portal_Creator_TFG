import { CommonModule } from '@angular/common';
import { Component, OnInit, inject } from '@angular/core';
import { PerfilService } from '../../services/perfil.service';
import { Router, RouterModule } from '@angular/router';
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
	private router = inject(Router);

  perfil?: Perfil;
  isMenuMovil = true;
  color: string = '#fff';
  bgColor: string = '#1c1c1c';

  // Funcion para entrada / salida menu movil
  alternarMenu() {
    this.isMenuMovil = !this.isMenuMovil;
  }

  ngOnInit(): void {

		const idGuardado = localStorage.getItem('perfilId');

		if (!idGuardado) {
      return;
    }

		const idPerfil = parseInt(idGuardado);

		this.perfilService.getPerfil(idPerfil).subscribe({
      next: (perfil) => {
        this.perfil = perfil;
        this.color = perfil.colorWeb1;
        this.bgColor = perfil.colorWeb2;
      },
      error: (error) => {
        console.error('Error al obtener el perfil:', error);

        localStorage.removeItem('perfilId');
        this.perfil = undefined;
      },
    });
  }

	borrarPerfil(): void {

		 if (!this.perfil) {
      return;
    }
  	const idPerfil = this.perfil.id

		this.perfilService.deletePerfil(idPerfil).subscribe({
			next: () => {
				localStorage.removeItem('perfilId');
				this.perfil = undefined;
				window.location.href = '/';
			},
			error: (error) => {
				console.error('Error al borrar el perfil:', error);
			},
		});
	}
}
