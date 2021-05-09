import { Component, Input, OnInit } from '@angular/core';
import { Usuario } from 'src/app/models/usuario';
import { UsuarioService } from 'src/app/services/usuario.service'

@Component({
  selector: 'app-usuario-list',
  templateUrl: './usuario-list.component.html',
  styleUrls: ['./usuario-list.component.css']
})
export class UsuarioListComponent implements OnInit {

  usuario = {} as Usuario;
  usuarios: Usuario[];

  @Input() currentUsuario = null;
  
  
  currentIndex = -1;
  cpf = 0;

  constructor(private UsuarioService: UsuarioService) { }

  ngOnInit() {
    this.readUsuarios();
  }

  readUsuarios() {
      this.UsuarioService.readAll()
      .subscribe(
        (usuarios: Usuario[]) => {
          this.usuarios = usuarios;
          console.log(usuarios)
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

  searchByCpf(): void {
    this.UsuarioService.read(this.cpf)
      .subscribe(
        usuarioCpf => {
          this.usuario = usuarioCpf;
          console.log(usuarioCpf);
        },
        error => {
          console.log(error);
        });
  }

}
