import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-usuario-confirmation',
  templateUrl: './usuario-confirmation.component.html',
  styleUrls: ['./usuario-confirmation.component.css']
})
export class UsuarioConfirmationComponent implements OnInit {

  currentUsuario = null;
  message = '';

  constructor(
    private usuarioService: UsuarioService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

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

  vacineUsuario(): void {
    this.usuarioService.vacinationConfirm(this.currentUsuario.id)
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
