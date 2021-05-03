import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuarioService } from 'src/app/services/usuario.service'

@Component({
  selector: 'app-usuario-details',
  templateUrl: './usuario-details.component.html',
  styleUrls: ['./usuario-details.component.css']
})
export class UsuarioDetailsComponent implements OnInit {

  currentUsuario = null;
  message = '';

  constructor(
    private usuarioService: UsuarioService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.message = '';
    this.getUsuario(this.route.snapshot.paramMap.get('id'));
  }

  getUsuario(id): void {
    this.usuarioService.read(id)
      .subscribe(
        usuario => {
          this.currentUsuario = usuario;
          console.log(usuario);
        },
        error => {
          console.log(error);
        });
  }

  updateUsuario(): void {
    this.usuarioService.update(this.currentUsuario.id, this.currentUsuario)
      .subscribe(
        response => {
          console.log(response);
          this.router.navigate(['/usuarios'])
        },
        error => {
          console.log(error);
        });
  }

  deleteUsuario(): void {
    this.usuarioService.delete(this.currentUsuario.id)
      .subscribe(
        response => {
          console.log(response);
          this.router.navigate(['/usuarios']);
        },
        error => {
          console.log(error);
        });
  }

}
