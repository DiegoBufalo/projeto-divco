import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { retry } from 'rxjs/operators';
import { All } from '../models/usuario';

@Injectable({
  providedIn: 'root'
})
export class CovidService {

  private baseUrl = 'https://covid-api.mmediagroup.fr/v1';

  constructor(private HttpClient: HttpClient) { }

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }

  readBrasil(pais: string): Observable<any> {
    return this.HttpClient.get<any>(this.baseUrl +'/cases?country='+ pais)
    .pipe(
      retry(1)
      );
  }
}
