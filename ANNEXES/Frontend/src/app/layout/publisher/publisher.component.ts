import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PublisherService } from '../../services/publisher.service';
import {AppService} from '../../services/app.service';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { Publisher, GameList } from '../../models/models';

@Component({
  selector: 'app-publisher',
  standalone: true,
  imports: [CommonModule,FormsModule, ReactiveFormsModule],
  templateUrl: './publisher.component.html',
  styleUrl: './publisher.component.scss',
})
export class PublisherComponent implements OnInit {
  constructor(
    private publisherService: PublisherService,
    private appService: AppService,
    private toastr: ToastrService ) {}

  listPublisher: Publisher[] = [];
  selectedPublisher: Publisher | null = null;
  selectedGame: GameList | null = null;
  isDisplayCategoryDetails: boolean = false;
  isDisplayWarning: boolean = false;
  isDisplayEditCard: boolean = false;
  isDisplayBtn: boolean = false;
  isDisplayEdit: boolean = false;
  isDisplayDetailCard: boolean = false;

  selectGame(game: GameList): void{
    this.selectedGame = game;
    this.isDisplayDetailCard = true;
  }
  selectPublisher(publisher: Publisher): void{
    this.selectedPublisher = publisher;
  }
    displayDeletePublisher(publisher: Publisher){
    this.isDisplayBtn=true
  }
  displayDetails() {
    this.isDisplayCategoryDetails = !this.isDisplayCategoryDetails;
  }
  displayEditCard(publisher: Publisher) {
    this.isDisplayEditCard = !this.isDisplayEditCard;
  }
  displayWarningForm() {
    this.isDisplayWarning = !this.isDisplayWarning;
  }
  ngOnInit(): void {
    this.getAllPublishers();
  }
  getAllPublishers() {
    this.publisherService.getAllPublishers().subscribe((publisher) => {
      this.listPublisher = publisher;
    });
  }
 deletePublisher():void{
 if(this.selectedPublisher){
  const publisherId = this.selectedPublisher.id;
     this.publisherService.deletePublisher(publisherId).subscribe(()=>{
      this.toastr.success('Publisher supprimé avec succès');
      this.appService.reload();
    })
 }
  }
}
