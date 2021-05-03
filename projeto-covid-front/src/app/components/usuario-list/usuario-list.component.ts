import { Component, OnInit } from '@angular/core';
import { UsuarioService } from 'src/app/services/usuario.service'

@Component({
  selector: 'app-usuario-list',
  templateUrl: './usuario-list.component.html',
  styleUrls: ['./usuario-list.component.css']
})
export class UsuarioListComponent implements OnInit {

  usuarios: any;
  currentUsuario = null;
  currentIndex = -1;
  id = -1;

  constructor(private UsuarioService: UsuarioService) { }

  ngOnInit(): void {
    this.readUsuarios();
  }

  readUsuarios(): void {
      this.UsuarioService.readAll()
      .subscribe(
        usuarios => {
          this.usuarios = usuarios;
          console.log(usuarios);
        },
          error => {
            console.log(error);
          });
  }

  refresh(): void {
    this.readUsuarios();
    this.currentUsuario = null;
    this.currentIndex = -1;
  }

  setCurrentUsuario(usuario, index): void {
    this.currentUsuario = usuario;
    this.currentIndex = index;
  }

  searchById(): void {
    this.UsuarioService.read(this.id)
      .subscribe(
        usuario => {
          this.usuarios = usuario;
          console.log(usuario);
        },
        error => {
          console.log(error);
        });
  }

}
