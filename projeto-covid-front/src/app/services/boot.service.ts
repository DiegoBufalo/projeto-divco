import { Observable, throwError } from 'rxjs';
import { Pergunta, Usuario } from './../models/usuario';
import { HttpClient, HttpErrorResponse, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { retry, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class BootService {

  private baseURL: string = "http://localhost:8080/chatbot";
  private mensagem: string;

  constructor(private HttpClient: HttpClient) { }



  buscaResposta(pergunta : Pergunta): Observable<any> {
    return this.HttpClient.post<Pergunta>(this.baseURL, pergunta)
    .pipe(
      retry(2),
      catchError(this.handleError)
      );
  }

  handleError(error: HttpErrorResponse) {
    let errorMessage = '';
    if (error.error instanceof ErrorEvent) {
      // Erro ocorreu no lado do client
      errorMessage = error.error.message;
    } else {
      // Erro ocorreu no lado do servidor
      errorMessage = `Código do erro: ${error.status}, ` + `menssagem: ${error.message}`;
    }
    console.log(errorMessage);
    return throwError(errorMessage);
  };


}