import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import {AppService} from '../services/app.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent implements OnInit {
  constructor( private appService:AppService){}
  gameList:any[]=[];


  ngOnInit(){
this.getGameList()
  }
  
     getGameList(): void {
      const container = document.getElementById("card");
    this.appService.getAllGame().subscribe(
      (game) => {
        this.gameList = game;

      },
      (error) => {
        console.error(error);
        // this.toastr.error('Impossible de charger les projets.');
      }
    );
  }

}
