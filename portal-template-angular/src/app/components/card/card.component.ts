import { Component, Input } from '@angular/core';

@Component({
  selector: 'cardComponent',
  standalone: true,
  imports: [],
  templateUrl: './card.component.html',
  styleUrl: './card.component.css',
})
export class CardComponent {
  @Input() urlCard: string = '';
  @Input() titulo: string = 'Titulo';
  @Input() descripcion: string = 'Descripcion de la card';
  @Input() color: string = '#fff';
  @Input() colorHover: string = '#000';

  isHover: boolean = false;

  entradaHover() {
    this.isHover = true;
  }

  salidaHover() {
    this.isHover = false;
  }
}
