import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UsuarioCreateComponent } from './components/usuario-create/usuario-create.component';
import { UsuarioDetailsComponent } from './components/usuario-details/usuario-details.component';
import { UsuarioListComponent } from './components/usuario-list/usuario-list.component';
import { UsuarioDeleteComponent } from './components/usuario-delete/usuario-delete.component';
import { UsuarioQueueComponent } from './components/usuario-queue/usuario-queue.component';
import { UsuarioConfirmationComponent } from './components/usuario-confirmation/usuario-confirmation.component';

@NgModule({
  declarations: [
    AppComponent,
    UsuarioCreateComponent,
    UsuarioDetailsComponent,
    UsuarioListComponent,
    UsuarioDeleteComponent,
    UsuarioQueueComponent,
    UsuarioConfirmationComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
