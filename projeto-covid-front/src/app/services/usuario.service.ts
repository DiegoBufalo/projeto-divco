import { Observable } from 'rxjs';
import { Usuario } from './../models/usuario';
import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

@Injectable({
  providedIn: 'root',
})
export class UsuarioService{

  private listaUsuario: any[];
  private url = 'http://localhost:8080/pessoa';
  private urlPost = 'http://localhost:8080/pessoa/cadastrar';

  constructor(private HttpClient: HttpClient){
    this.listaUsuario = [];
  }

    todas(): Observable<Usuario[]>{
      return this.HttpClient.get<Usuario[]>(this.url);
    }

    adicionar(usuario: Usuario): Observable<Usuario>{
      return  this.HttpClient.post<Usuario>(this.urlPost, usuario);
    }


}
