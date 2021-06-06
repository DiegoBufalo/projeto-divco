import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BootComponent } from './components/boot/boot.component';
import { CovidComponent } from './components/covid/covid.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { ReportComponent } from './components/report/report.component';
import { UsuarioConfirmationComponent } from './components/usuario-confirmation/usuario-confirmation.component';
import { UsuarioCreateComponent } from './components/usuario-create/usuario-create.component';
import { UsuarioDeleteComponent } from './components/usuario-delete/usuario-delete.component';
import { UsuarioDetailsComponent } from './components/usuario-details/usuario-details.component';
import { UsuarioListComponent } from './components/usuario-list/usuario-list.component';
import { UsuarioQueueComponent } from './components/usuario-queue/usuario-queue.component';

const routes: Routes = [
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: 'home', component: CovidComponent },
  { path: 'bot', component: BootComponent },
  { path: 'usuarios', component: UsuarioListComponent },
  { path: 'usuarios/:id', component: UsuarioDetailsComponent },
  { path: 'cadastrar', component: UsuarioCreateComponent },
  { path: 'deletar/:id', component: UsuarioDeleteComponent},
  { path: 'fila', component: UsuarioQueueComponent },
  { path: 'confirmar/:id', component: UsuarioConfirmationComponent },
  { path: 'relatorio', component: ReportComponent },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
