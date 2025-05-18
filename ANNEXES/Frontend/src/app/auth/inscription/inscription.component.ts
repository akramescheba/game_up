import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthComponent } from '../auth.component';

@Component({
  selector: 'app-inscription',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './inscription.component.html',
  styleUrl: './inscription.component.scss',
})
export class InscriptionComponent {
  constructor(private auth: AuthComponent) {}

  isButtonShow: boolean = false;

  btnConnection() {
  this.auth.btnConnection()
  }
}
