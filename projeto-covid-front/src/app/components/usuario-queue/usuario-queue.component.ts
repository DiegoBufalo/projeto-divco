import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-usuario-queue',
  templateUrl: './usuario-queue.component.html',
  styleUrls: ['./usuario-queue.component.css']
})
export class UsuarioQueueComponent implements OnInit {

  usuarios: any;
  currentUsuario = null;
  currentIndex = -1;
  cpf = 0;

  constructor(
    private UsuarioService: UsuarioService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.readUsuarios();
  }

  readUsuarios(): void {
    this.UsuarioService.queue()
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

searchByCpf(): void {
  this.UsuarioService.read(this.cpf)
    .subscribe(
      usuario => {
        this.usuarios = usuario;
        console.log(usuario);
      },
      error => {
        console.log(error);
      });
}

vacineUsuario(): void {
  this.UsuarioService.vacinationConfirm(this.currentUsuario.id)
    .subscribe(
      response => {
        console.log(response);
        this.router.navigate(['/fila'])
      },
      error => {
        console.log(error);
      });
}

}
