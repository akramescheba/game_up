import { Component } from '@angular/core';
import{CommonModule} from '@angular/common';
import { AppService } from '../services/app.service';
import { ConnexionComponent } from './connexion/connexion.component';
import { InscriptionComponent } from './inscription/inscription.component';

@Component({
  selector: 'app-auth',
  standalone: true,
  imports: [CommonModule,ConnexionComponent, InscriptionComponent],
  templateUrl: './auth.component.html',
  styleUrl: './auth.component.scss',
})
export class AuthComponent {
  constructor(private appService: AppService) {}
  

  isButtonShow: boolean = false;

 btnConnection() {
  this.isButtonShow = !this.isButtonShow;
}

btnInscription() {
  this.isButtonShow = !this.isButtonShow;
}
}


