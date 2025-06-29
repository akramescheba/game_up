import { Component, OnInit } from '@angular/core';
import { CommonModule, formatDate } from '@angular/common';
import {
  FormsModule,
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { CarouselModule } from 'primeng/carousel';
import { ListAvis, GameList } from '../../models/models';
import { AvisComponent } from '../../layout/avis/avis.component';
import { AvisService } from '../../services/avis.service';
import { AuthService } from '../../services/auth.service';
import { ToastrService } from 'ngx-toastr';
import { RatingModule,Rating  } from 'primeng/rating';
import { MessageService } from 'primeng/api';
import { Toast,ToastModule  } from 'primeng/toast';
import { ButtonModule } from 'primeng/button';
import { Ripple } from 'primeng/ripple';
import { AppService } from '../../services/app.service';
import { Carousel } from 'primeng/carousel';
import { Tag } from 'primeng/tag';



@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [Rating,RatingModule, Carousel, ButtonModule, ToastModule, ButtonModule, CommonModule, FormsModule,CarouselModule, ReactiveFormsModule],
   providers: [MessageService],
   templateUrl: './footer.component.html',
  styleUrl: './footer.component.scss',
})
export class FooterComponent {
  listAvis: ListAvis[] = [];
  gameList: GameList[]=[];
  avisForms!: FormGroup;
  selectedAvis: ListAvis | null = null;
  userName: string = '';
  constructor(
    private aviService: AvisService,
    private authService: AuthService,
    private formBuilder: FormBuilder,
    private toastr: ToastrService,
    private messageService: MessageService,
    private appService: AppService
  ) {}
  ngOnInit(): void {
    this.aviService.getAvis().subscribe((avis) => {
      this.listAvis = avis;
    });
  }
    
}
