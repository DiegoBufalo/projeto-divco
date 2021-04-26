import { Usuario } from './../models/usuario';
import { UsuarioService } from './../services/usuario.service';
import { HttpClient } from '@angular/common/http';
import { Component, EventEmitter, Output } from '@angular/core';
import { error } from '@angular/compiler/src/util';

@Component({
  selector: 'app-cadastrar-usuario',
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.scss'],
})
export class CadastrarUsuarioComponent {
  @Output() aoCadastrar = new EventEmitter<any>();

  nome: string;
  sobrenome: string;
  email: string;
  senha: string;
  cpf: string;
  dataNascimento: string;
  endereco: string;
  profSaude: boolean = false;
  tipoUsuario: string = 'ATENDENTE';

  constructor(private service: UsuarioService){

  }

  cadastrar() {
    console.log('solicitado novo cadastro');
    const valorEmitir: Usuario = {
      nome: this.nome,
      sobrenome: this.sobrenome,
      email: this.email,
      senha: this.senha,
      cpf: this.cpf,
      dataNascimento: this.dataNascimento,
      endereco: this.endereco,
      profSaude: this.profSaude,
      tipoUsuario: this.tipoUsuario,
    };

    this.service.adicionar(valorEmitir).subscribe(
      (resultado) =>{
      console.log(resultado);
    },
      (error) => console.error(error)
    );
  }
}
