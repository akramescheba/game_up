import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private router: Router ) {}

  logIn(): void {
    localStorage.setItem('token', 'loggedIn');
  }

  logOut(): void {
    localStorage.removeItem('token');
    // this.toastr.success('Vous êtes déconnecté');
    this.router.navigate(['/login']);
  }

  getNom(){
    return localStorage.getItem('nom');
  }

  getRole(){
    return localStorage.getItem('role');
  }
}
