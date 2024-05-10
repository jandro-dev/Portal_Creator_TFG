import { Component } from '@angular/core';
import { CardComponent } from '../../components/card/card.component';

@Component({
  selector: 'app-inicio',
  standalone: true,
  imports: [CardComponent],
  templateUrl: './inicio.component.html',
  styleUrl: './inicio.component.css'
})
export default class InicioComponent {

}
