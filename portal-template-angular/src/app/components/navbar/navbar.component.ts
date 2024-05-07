import { Component, Input } from '@angular/core';

@Component({
  selector: 'navbarComponent',
  standalone: true,
  imports: [],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css',
})
export class NavbarComponent {
  @Input() bgColor: string = '#000';
  @Input() color: string = '#fff';
}
