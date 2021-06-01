import { Observable, throwError } from 'rxjs';
import { Usuario } from './../models/usuario';
import { HttpClient, HttpErrorResponse, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { retry, catchError } from 'rxjs/operators';

@Injectable({
  providedIn: 'root',
})

export class UsuarioService{

  private baseUrl = 'http://localhost:8080/pessoa';

  constructor(private HttpClient: HttpClient){ }
  
  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  }


    readAll(): Observable<Usuario[]>{
      return this.HttpClient.get<Usuario[]>(this.baseUrl)
        .pipe(
            retry(2),
            catchError(this.handleError)
        );
    }

    read(id): Observable<Usuario> {
      return this.HttpClient.get<Usuario>(this.baseUrl +'/'+id)
      .pipe(
        retry(1),
        catchError(this.handleError)
        );
    }

    readCpf(cpf): Observable<Usuario> {
      return this.HttpClient.get<Usuario>(this.baseUrl +'/cpf'+cpf)
      .pipe(
        retry(1),
        catchError(this.handleError)
        );
    }

    create(data: Usuario): Observable<Usuario> {
      return this.HttpClient.post<Usuario>(this.baseUrl+'/cadastrar',JSON.stringify(data), this.httpOptions)
      .pipe(
        retry(2),
        catchError(this.handleError)
        );
    }
  
    update(data : Usuario): Observable<Usuario> {
      return this.HttpClient.put<Usuario>(this.baseUrl+'/atualizar/'+data.id, JSON.stringify(data), this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
        );
    }
  
    delete(data: Usuario): Observable<Usuario> {
      return this.HttpClient.delete<Usuario>(this.baseUrl+'/deletar/'+data.id, this.httpOptions)
      .pipe(
        retry(1),
        catchError(this.handleError)
        );
    }
  
    vacinationConfirm(id): Observable<Usuario> {
      return this.HttpClient.get<Usuario>(this.baseUrl+'/confirmar/'+id)
      .pipe(
        retry(1),
        catchError(this.handleError)
        );
    }

    queue(): Observable<Usuario[]> {
      return this.HttpClient.get<Usuario[]>(this.baseUrl+'/fila')
      .pipe(
        retry(1),
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
