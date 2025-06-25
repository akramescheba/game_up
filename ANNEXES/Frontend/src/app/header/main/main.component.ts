import { Component } from '@angular/core';
import {RouterOutlet} from "@angular/router";
import {NavComponent} from '../nav/nav.component';
import {FooterComponent} from '../footer/footer.component';

@Component({
  selector: 'app-main',
  standalone: true,
  imports: [RouterOutlet,FooterComponent,NavComponent ],
  templateUrl: './main.component.html',
  styleUrl: './main.component.scss'
})
export class MainComponent {

}
