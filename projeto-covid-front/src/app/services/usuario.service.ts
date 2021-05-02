import { Observable } from 'rxjs';
import { Usuario } from './../models/usuario';
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root',
})

export class UsuarioService{

  private listaUsuario: any[];
  private baseUrl = 'http://localhost:8080/pessoa';

  constructor(private HttpClient: HttpClient){ }

    readAll(): Observable<any>{
      return this.HttpClient.get(this.baseUrl);
    }

    read(id): Observable<any> {
      return this.HttpClient.get(`${this.baseUrl}/${id}`);
    }

    create(data): Observable<any> {
      return this.HttpClient.post(`${this.baseUrl}/cadastrar`, data);
    }
  
    update(id, data): Observable<any> {
      return this.HttpClient.put(`${this.baseUrl}/atualizar/${id}`, data);
    }
  
    delete(id): Observable<any> {
      return this.HttpClient.delete(`${this.baseUrl}/deletar/${id}`);
    }
  
    vacinationConfirm(id): Observable<any> {
      return this.HttpClient.get(`${this.baseUrl}/confirmar/${id}`);
    }

    queue(): Observable<any> {
      return this.HttpClient.get(`${this.baseUrl}/fila`);
    }


}
