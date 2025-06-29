import { Component, OnInit } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { ToastrService } from 'ngx-toastr';
import { UserList } from '../../../models/models';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { faUser } from '@fortawesome/free-solid-svg-icons';
import { UsersService } from '../../../services/users.service';
import { AppService } from '../../../services/app.service';

@Component({
  selector: 'app-usercrud',
  standalone: true,
  imports: [CommonModule, FontAwesomeModule, FormsModule, ReactiveFormsModule],
  templateUrl: './usercrud.component.html',
  styleUrl: './usercrud.component.scss',
})
export class UsercrudComponent implements OnInit {
  userForm!: FormGroup;
  faUser = faUser;
  userList: UserList[] = [];
  selectedUser: UserList | null = null;
  isDisplayEditCard: boolean = false;

  constructor(
    private userService: UsersService,
    private appService: AppService,
    private formBuilder: FormBuilder,
    private toastr: ToastrService
  ) {}

  ngOnInit(): void {
    this.getUsers();
    this.userForm = this.formBuilder.group({
      nom: ['', Validators.required],
      email: ['', Validators.required],
      role: ['', Validators.required],
      password: ['', Validators.required],
      repassword: ['', Validators.required],
    });
  }
  displayEditCard(user: UserList) {
    this.selectedUser = { ...user };
    this.isDisplayEditCard = true;
  }

  /*FONCTION GET D'AFFICHAGE DE LA LISTE DES USER*/
  getUsers() {
    this.userService.getAllUsers().subscribe((users) => {
      this.userList = users;
    });
  }
  /**FONCTION POST DE CREATION DE USER */
  postUser() {
    this.userService.postUser(this.userForm.value).subscribe((user) => {
      this.toastr.success('Utilisateur ajouté avec succès');
      this.appService.reload();
    });
  }

  /*FONCTION PATCH POUR LA MISE A JOUR  DE USER */
  patchUser(): void {
    if (this.selectedUser) {
      const userId = this.selectedUser.id;
      const patchData = { ...this.selectedUser };
      this.userService.patchUser(userId, patchData).subscribe((user) => {
        this.toastr.success('Utilisateur mis à jour avec succès');
        this.appService.reload();
      });
    } else {
      this.toastr.error('Erreur lor de la mise à jour');
    }
  }

  /*FONCTION SUPPRESSION  DE USER */
  deleteUserById(userId: number): void {
    this.userService.deleteUser(userId).subscribe((user) => {
      this.toastr.success('Utilisateur supprimé avec succès');
      this.appService.reload();
    });
  }
}
