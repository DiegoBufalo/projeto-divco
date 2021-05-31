import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Usuario } from 'src/app/models/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms'; 
import { NullTemplateVisitor } from '@angular/compiler';

@Component({
  selector: 'app-usuario-details',
  templateUrl: './usuario-details.component.html',
  styleUrls: ['./usuario-details.component.css']
})
export class UsuarioDetailsComponent implements OnInit {

  usuarioEncontrado: Usuario ={
    id: null,
    nome: '',
    sobrenome: '',
    email: '',
    senha:'',
    tipoUsuario: '',
    profSaude: false,
    endereco: ''
  }
  
  currentUsuario: FormGroup;


  constructor(
    private usuarioService: UsuarioService,
    private route: ActivatedRoute,
    private router: Router,
    private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.currentUsuario = this.formBuilder.group({
      id: new FormControl('', Validators.required),
      nome: new FormControl('', Validators.required),
      sobrenome: new FormControl('', Validators.required),
      email: new FormControl('', [Validators.required, Validators.email]),
      tipoUsuario: new FormControl('', Validators.required),
      profSaude: new FormControl('', Validators.required),
      endereco: new FormControl('', Validators.required)
    });

    this.getUsuario(this.route.snapshot.params.id);

  }

  getUsuario(id): void {
    this.usuarioService.read(id)
      .subscribe(
        data => {
          this.usuarioEncontrado.id = data[0].id
          this.usuarioEncontrado.nome = data[0].nome
          this.usuarioEncontrado.sobrenome = data[0].sobrenome
          this.usuarioEncontrado.email = data[0].email
          this.usuarioEncontrado.senha = data[0].senha
          this.usuarioEncontrado.tipoUsuario = data[0].tipoUsuario
          this.usuarioEncontrado.profSaude = data[0].profSaude
          this.usuarioEncontrado.endereco = data[0].endereco
        });

        this.currentUsuario.setValue(this.usuarioEncontrado);
         console.log(this.currentUsuario.get("nome"));
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
