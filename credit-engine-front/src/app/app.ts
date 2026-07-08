import { Component } from '@angular/core';
import { CurrencyManagerComponent } from './components/currency-manager/currency-manager.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    CurrencyManagerComponent
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {

}
