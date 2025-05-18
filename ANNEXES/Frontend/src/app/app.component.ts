import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {NavComponent} from "./nav/nav.component";
import{GameListComponent} from './layout/game-list/game-list.component';
import {HomeComponent} from "./home/home.component"

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, NavComponent,GameListComponent, HomeComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'Frontend';
  pageActive : String = "home"
}
