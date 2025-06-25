import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { UsercrudComponent } from '../admin/usercrud/usercrud.component';
import { GamecrudComponent } from '../admin/gamecrud/gamecrud.component';
import { CategoryComponent } from '../../layout/category/category.component';
import { AvisComponent } from '../../layout/avis/avis.component';
import { AppService } from '../../services/app.service';
import { AuthService } from '../../services/auth.service';
import { faUser } from '@fortawesome/free-solid-svg-icons';

@Component({
  selector: 'app-admin',
  standalone: true,
  imports: [
    RouterOutlet,
    FontAwesomeModule,
    CommonModule,
  ],
  providers: [],
  templateUrl: './admin.component.html',
  styleUrl: './admin.component.scss',
})
export class AdminComponent implements OnInit {
  faUser = faUser;
  pageActive: string = 'games';
  constructor(
    private appService: AppService,
    private router: Router,
      private route: ActivatedRoute,
    private authService: AuthService
  ) {}

  userName: string = '';

  deconnexion() {
    this.authService.logOut();
  }
navigateTo(page: string): void {
  this.router.navigate([`/admin/${page}`]);
}


  ngOnInit() {
    const nom = this.authService.getUserName();
    this.userName = nom ? nom : '';
  }
}
