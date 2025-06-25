import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {
  FormsModule,
  FormBuilder,
  FormGroup,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import {ListAvis} from '../../models/models';
import { ToastrService } from 'ngx-toastr';
import { AvisService } from '../../services/avis.service';


@Component({
  selector: 'app-avis',
  standalone: true,
  imports: [ReactiveFormsModule,FormsModule,CommonModule],
  templateUrl: './avis.component.html',
  styleUrl: './avis.component.scss',
})
export class AvisComponent implements OnInit {
  listAvis: ListAvis[] = [];
  avisForms!: FormGroup;
  selectedAvis:ListAvis|null=null;
  constructor(
    private aviService: AvisService,
    private formBuilder: FormBuilder,
    private toastr: ToastrService, 
  ) {}

  ngOnInit(): void {
     /*METHODE GET DE RECUPERATION D'UN AVIS DEPUIS L'API */
    this.aviService.getAvis().subscribe((avis) => {
      this.listAvis = avis;
    });
    this.avisForms = this.formBuilder.group({
      note: ['', Validators.required, Validators.min(1), Validators.max(10)],
      commentaire: ['', Validators.required, Validators.min(20), Validators.max(150)],
    });
  }
 /*METHODE POST DE CREATION D'UN AVIS */
  postAvis() {
    this.aviService.createAvis(this.avisForms.value).subscribe((avis) => {
      this.toastr.success('Votre avis a été envoyé');
      location.reload();
    });
 
  }
 /*METHODE DELETE DE SUPPRESSION D'UN AVIS */
  deleteAvisById(avisId: number):void{
    this.aviService.deleteAvisById(avisId).subscribe((avis) =>{
      this.toastr.success('Votre avis a été supprimé');
    })
  }
}
