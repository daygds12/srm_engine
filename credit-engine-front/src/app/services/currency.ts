import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface Currency {
  id?: number;
  code: string;
  description: string;
}

@Injectable({
  providedIn: 'root'
})
export class CurrencyService {

  private apiUrl = 'http://localhost:8080/currencies';

  constructor(private http: HttpClient) {}

  findAll(): Observable<Currency[]> {
    return this.http.get<Currency[]>(this.apiUrl);
  }

  save(currency: Currency): Observable<Currency> {
    return this.http.post<Currency>(this.apiUrl, currency);
  }
}
