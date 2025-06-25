import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AuthComponent } from '../auth.component';
import {UsersService} from '../../services/users.service';
import { Router } from '@angular/router';
import {
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-inscription',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './inscription.component.html',
  styleUrl: './inscription.component.scss',
})
export class InscriptionComponent implements OnInit{
  constructor(private auth: AuthComponent,
    private formBuilder: FormBuilder,
    private userService: UsersService,
    private router: Router,
    private toastr: ToastrService
  ) {}

  isButtonShow: boolean = false;
  psw: string = '';
  repsw: string = '';
    userForm!: FormGroup;

  btnConnection() {
  this.auth.btnConnection()
  }

    ngOnInit() {
    this.userForm = this.formBuilder.group({
      nom: ['', Validators.required],
      email: ['', Validators.required],
      role: ['', Validators.required],
      password: ['', Validators.required],
      repassword: ['', Validators.required],
    });
  }

  inscription() {

    if (this.userForm.valid) {
      const psw = this.userForm.get('password')?.value;
      const repsw = this.userForm.get('repassword')?.value;
      if (psw === repsw) {
        this.userService
          .postUser(this.userForm.value)
          .subscribe((response) => { 
            this.toastr.success(
              'Inscrption réussie',
              'Vous serez redirigé vers la page de connexion',
              {
                timeOut: 5000, 
                positionClass: 'toast-top-center'
              }
            );
          });
      } else {
        this.toastr.error('Les mots de passes saisis ne sont pas indentiques',
        );
      }
    }else{
      this.toastr.error('Veillez remplir tous les champs');
  }
}
}
