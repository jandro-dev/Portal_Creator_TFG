import { CommonModule } from '@angular/common';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'navbarComponent',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
})
export class NavbarComponent {
  isMenuMovil = true;
  @Input() bgColor: string = '#000';
  @Input() color: string = '#fff';

  // Funcion para entrada / salida menu movil
  alternarMenu() {
    this.isMenuMovil = !this.isMenuMovil;
  }
}
