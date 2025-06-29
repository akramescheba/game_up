import { Component, OnInit, Input } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormsModule,
  FormGroup,
  ReactiveFormsModule,
  FormBuilder,
  Validators,
} from '@angular/forms';
import { GameList } from '../../models/models';
import { AuthService } from '../../services/auth.service';
import { AppService } from '../../services/app.service';
import { AvisService } from '../../services/avis.service';
import { WishlistService } from '../../services/wishlist.service';
import { CategoriesService } from '../../services/categories.service';
import { FooterComponent } from '../../header/footer/footer.component';
import { RatingModule, Rating } from 'primeng/rating';
import { ToastrService } from 'ngx-toastr';
import { MessageService } from 'primeng/api';
import { Toast, ToastModule } from 'primeng/toast';
import { ButtonModule } from 'primeng/button';
import { Ripple } from 'primeng/ripple';
import { Carousel } from 'primeng/carousel';
import { Tag } from 'primeng/tag';

@Component({
  selector: 'app-avis',
  standalone: true,
  imports: [
    Rating,
    ToastModule,
    ButtonModule,
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
  ],
  templateUrl: './avis.component.html',
  providers: [MessageService],
  styleUrl: './avis.component.scss',
})
export class AvisComponent implements OnInit {
  constructor(
    private authService: AuthService,
    private appService:AppService,
    private avisService: AvisService,
    private formBuilder: FormBuilder,
    private messageService: MessageService,
    private toastr: ToastrService
  ) {}
  note!: number;
  userName!: string;
  avisForm!: FormGroup;
  avisList: any[] = [];
  ngOnInit(): void {
    const nom = this.authService.getUserName();
    this.userName = nom ? nom : '';
    this.avisForm = this.formBuilder.group({
      name: [this.userName],
      note: ['', Validators.required],
      commentaire: ['', Validators.required],
    });
  }
  /*FONCTION POST DE CREATION DES AVIS*/
  postAvis() {
    if (this.avisForm.invalid) {
      this.toastr.warning('Veuillez remplir tous les champs correctement');
      //this.messageService.add({ severity: 'Warn', summary: 'Warn', detail: 'Veuillez remplir tous les champs correctement' });
      return;
    }
    this.avisService.createAvis(this.avisForm.value).subscribe(() => {
      this.toastr.success(
        `Nous vous remercions Mr./Mse ${this.userName}`,
        'avis posté'
      );
    });
    this.avisForm.reset();
   this.appService.reload();
  }
}
