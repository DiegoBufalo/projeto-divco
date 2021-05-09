import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from 'src/app/models/usuario';
import { UsuarioService } from 'src/app/services/usuario.service'

@Component({
  selector: 'app-usuario-details',
  templateUrl: './usuario-details.component.html',
  styleUrls: ['./usuario-details.component.css']
})
export class UsuarioDetailsComponent implements OnInit {

  currentUsuario: Usuario = null;

  constructor(
    private usuarioService: UsuarioService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.getUsuario(this.route.snapshot.paramMap.get('id'));
  }

  getUsuario(id): any {
    this.usuarioService.read(id)
      .subscribe(
        (usuario: Usuario) => {
          this.currentUsuario = usuario;
        });
  }

  updateUsuario(): void {
    this.usuarioService.update(this.currentUsuario)
      .subscribe(
        response => {
          this.router.navigate(['/usuarios'])
        });
  }

  deleteUsuario(): void {
    this.usuarioService.delete(this.currentUsuario)
      .subscribe(
        response => {
          this.router.navigate(['/usuarios']);
        });
  }

}
