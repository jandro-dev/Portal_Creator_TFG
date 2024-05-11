import { Component, EventEmitter, Input, Output } from '@angular/core';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'cardComponent',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './card.component.html',
  styleUrl: './card.component.css',
})
export class CardComponent {
  @Input() urlCard: string = '';
  @Input() titulo: string = 'Titulo';
  @Input() descripcion: string = 'Descripcion de la card';
  @Input() color: string = '#fff';
  @Input() colorHover: string = '#000';

  @Output() editar: EventEmitter<void> = new EventEmitter<void>();
  @Output() borrar: EventEmitter<void> = new EventEmitter<void>();

  isHover: boolean = false;

  entradaHover() {
    this.isHover = true;
  }

  salidaHover() {
    this.isHover = false;
  }
}
