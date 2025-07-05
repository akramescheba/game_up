import { Component } from '@angular/core';
import {Router} from '@angular/router';
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
  constructor(private appService: AppService,private router: Router) {}
  isButtonShow: boolean = false;
homePage(){
  this.router.navigate(['/'])
}
btnConnection() {
  this.isButtonShow = !this.isButtonShow;
}

btnInscription() {
  this.isButtonShow = !this.isButtonShow;
}
}


