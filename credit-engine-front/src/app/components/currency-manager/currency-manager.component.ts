import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CurrencyService, Currency } from '../../services/currency';

@Component({
  selector: 'app-currency-manager',
  standalone: true,
  imports: [
    CommonModule,
    FormsModule
  ],
  templateUrl: './currency-manager.component.html',
  styleUrl: './currency-manager.component.css'
})
export class CurrencyManagerComponent implements OnInit {

  currencies: Currency[] = [];

  newCurrency: Currency = {
    code: '',
    description: ''
  };

  errorMessage = '';

  constructor(private currencyService: CurrencyService) {}

  ngOnInit(): void {
    this.loadCurrencies();
  }

  loadCurrencies(): void {
    this.currencyService.findAll()
      .subscribe({
        next: (data) => {
          this.currencies = data;
        },
        error: () => {
          this.errorMessage = 'Erro ao carregar moedas';
        }
      });
  }

  save(): void {

    this.currencyService.save(this.newCurrency)
      .subscribe({
        next: (currency) => {
          this.currencies.push(currency);

          this.newCurrency = {
            code: '',
            description: ''
          };
        },
        error: () => {
          this.errorMessage = 'Erro ao salvar moeda';
        }
      });

  }

}
