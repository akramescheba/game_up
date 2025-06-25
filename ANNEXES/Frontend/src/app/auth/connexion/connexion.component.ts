import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { UsersService } from '../../services/users.service';
import { AuthService } from '../../services/auth.service';
import { AuthComponent } from '../auth.component';

interface usersDataList {
  id: number;
  nom: string;
  email: string;
  password: string;
  role: string;
}

@Component({
  selector: 'app-connexion',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './connexion.component.html',
  styleUrl: './connexion.component.scss',
})
export class ConnexionComponent implements OnInit {
  email: string = '';
  psw: string = '';
  loginForm!: FormGroup;
  userList: usersDataList[] = [];

  constructor(
    private router: Router,
    private auth: AuthComponent,
    private usersService: UsersService,
    private authService: AuthService,
    private formBuilder: FormBuilder
  ) {}


  isButtonShow: boolean = false;
  btnInscription() {
    this.auth.btnInscription();
  }
  ngOnInit() {
    this.loginForm = this.formBuilder.group({
      email: ['', Validators.required],
      psw: ['', Validators.required],
    });
  }

  Connection() {
    if (this.loginForm.valid) {
      const email = this.loginForm.get('email')?.value;
      const psw = this.loginForm.get('psw')?.value;
      this.usersService.getAllUsers().subscribe((userData: usersDataList[]) => {
        this.userList = userData;

        const user = this.userList.find((u) => u.email === email);
        if (user) {
          if (user.password === psw) {
            this.authService.logIn();
            localStorage.setItem('nom', user.nom);
            localStorage.setItem('role', user.role);
            if (user.role === 'administrateur') {
              this.router.navigate(['/admin']);
            } else if (user.role === 'client') {
              this.router.navigate(['/client']);
            }
          }
        }
      });
    }
  }
}
