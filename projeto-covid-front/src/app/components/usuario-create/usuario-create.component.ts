import { Component, OnInit } from '@angular/core';
import { generate } from 'rxjs';
import {  UsuarioService } from 'src/app/services/usuario.service'

@Component({
  selector: 'app-usuario-create',
  templateUrl: './usuario-create.component.html',
  styleUrls: ['./usuario-create.component.css']
})
export class UsuarioCreateComponent implements OnInit {

  usuario = {
    nome: '',
    sobrenome: '',
    email: '',
    senha: 'senhaPadrao',
    cpf: '',
    dataNascimento: '',
    tipoUsuario: 'ATENDENTE',
    profSaude: false,
    endereco: ''
  }

  submitted = false;

  constructor(private UsuarioService: UsuarioService) { }

  ngOnInit(): void {
  }

  createUsuario(): void {
    const data = {
      nome: this.usuario.nome,
      sobrenome: this.usuario.sobrenome,
      email: this.usuario.email,
      senha: this.usuario.senha,
      cpf: this.usuario.cpf,
      dataNascimento: this.usuario.dataNascimento,
      tipoUsuario: this.usuario.tipoUsuario,
      profSaude: this.usuario.profSaude,
      endereco: this.usuario.endereco
    };

    this.UsuarioService.create(data)
      .subscribe(
        response => {
          console.log(response);
          this.submitted = true;
        },
        error => {
          console.log(error);
        });
  }

  newUsuario(): void {
    this.submitted = false;
    this.usuario = {  
      nome: '',
      sobrenome: '',
      email: '',
      senha: '',
      cpf: '',
      dataNascimento: '',
      tipoUsuario: '',
      profSaude: false,
      endereco: ''
    };
  }

}
