import { Injectable } from '@angular/core';
import { CanActivate, CanDeactivate, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { ToastrService } from 'ngx-toastr';

@Injectable({
  providedIn: 'root'
})
export class AuthguadService implements CanActivate{
 constructor(private router: Router, private toastr: ToastrService) {}

  canActivate(): boolean {
    if (localStorage.getItem('token') != null) {
      return true;
    } else {
      this.router.navigate(['/home']);
      return false;
    }
    return true
  }
}
