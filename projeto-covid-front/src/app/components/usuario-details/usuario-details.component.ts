import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario, UsuarioAtualizar } from 'src/app/models/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms'; 
import { NullTemplateVisitor } from '@angular/compiler';

@Component({
  selector: 'app-usuario-details',
  templateUrl: './usuario-details.component.html',
  styleUrls: ['./usuario-details.component.css']
})
export class UsuarioDetailsComponent implements OnInit {

  usuarioEncontrado: UsuarioAtualizar ={
    id: null,
    nome: '',
    sobrenome: '',
    email: '',
    senha:'',
    tipoUsuario: '',
    profSaude: false,
    endereco: ''
  }


  constructor(
    private usuarioService: UsuarioService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.getUsuario(this.route.snapshot.params.id);

  }

  getUsuario(id): void {
    this.usuarioService.read(id)
      .subscribe(
        (data: UsuarioAtualizar) => {
          this.usuarioEncontrado = data;
        });
  }

  updateUsuario(): void {
    this.usuarioService.update(this.usuarioEncontrado)
      .subscribe(
        response => {
          this.router.navigate(['/usuarios'])
        });
  }

  deleteUsuario(): void {
    this.usuarioService.delete(this.usuarioEncontrado)
      .subscribe(
        response => {
          this.router.navigate(['/usuarios']);
        });
  }

}
