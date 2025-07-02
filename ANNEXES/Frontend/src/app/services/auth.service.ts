import { Injectable } from '@angular/core';
import { CanActivate, Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root',
})
export class AuthService {
  constructor(private router: Router, private toastr: ToastrService) {}
  logIn(): void {
    localStorage.setItem('token', 'loggedIn');
        this.toastr.success('Vous êtes connecté');
  }

  logOut(): void {
    localStorage.removeItem('token');
    this.toastr.success('Vous êtes déconnecté');
    this.router.navigate(['/auth']);
  }
  getUserName() {
    return localStorage.getItem('nom');
  }
  getUserId() {
    return localStorage.getItem('id');
  }

  getUserRole() {
    return localStorage.getItem('role');
  }
}
