import { Component, OnInit } from '@angular/core';
import { CommonModule, formatDate } from '@angular/common';
import {
  FormsModule,
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { ListAvis } from '../../models/models';
import { AvisComponent } from '../../layout/avis/avis.component';
import { AvisService } from '../../services/avis.service';
import { AuthService } from '../../services/auth.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './footer.component.html',
  styleUrl: './footer.component.scss',
})
export class FooterComponent {
  listAvis: ListAvis[] = [];
  avisForms!: FormGroup;
  selectedAvis: ListAvis | null = null;
  userName: string = '';
  constructor(
    private aviService: AvisService,
    private authService: AuthService,
    private formBuilder: FormBuilder,
    private toastr: ToastrService
  ) {}
  ngOnInit(): void {
    const nom = this.authService.getUserName();
    this.userName = nom ? nom : '';
    this.aviService.getAvis().subscribe((avis) => {
      this.listAvis = avis;
    });
    this.avisForms = this.formBuilder.group({
      name: [this.userName],
      note: ['', Validators.required],
      // date: [new Date()],
      commentaire: ['', Validators.required],
    });
  }

  postAvis() {
    const formulaire = this.avisForms.value;
    this.aviService.createAvis(formulaire).subscribe((avis) => {
      this.toastr.success('Votre avis a été envoyé');
      console.log(this.avisForms.value);
      location.reload();
    });
  }
}
