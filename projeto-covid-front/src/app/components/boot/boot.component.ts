import { element } from 'protractor';
import { BootService } from 'src/app/services/boot.service';
import { Component, ViewChild, ElementRef, OnInit } from '@angular/core';
import { DatePipe } from '@angular/common';
import { Pergunta } from 'src/app/models/usuario';

export interface Message {
  remetente?: string;
  mensagem: string;
  data?: Date;
}

export interface MessageAPI {
  id: number;
  mensagem: string;
  horario: Date;
}

@Component({
  selector: 'app-boot',
  templateUrl: './boot.component.html',
  styleUrls: ['./boot.component.css']
})
export class BootComponent {

  @ViewChild('scrollMe') private myScrollContainer: ElementRef;

  msg: string;
  resultados: Message[]
  pergunta: Pergunta;


  constructor(private chatBoot: BootService) {
    this.initBoot()
   }

   initBoot() {
    const data = {
      pergunta: 'bemvindo'
    };

    this.resultados = []
    this.chatBoot.buscaResposta(data) 
      .subscribe((lista: MessageAPI) => {
          this.resultados.push({ remetente: 'boot', mensagem: lista.mensagem, data: new Date()});
      })
  }

  sendMessage() {
    const data = {
      pergunta: this.msg
    };

    this.resultados.push({ remetente: 'eu', mensagem: this.msg, data: new Date() })
    this.chatBoot.buscaResposta(data)
      .subscribe((lista: MessageAPI) => {
          this.resultados.push({ remetente: 'boot', mensagem: lista.mensagem, data: new Date()});
      })
    this.msg = '';
  }

  ngAfterViewChecked() {
    this.scrollToBottom();
  }
  
  scrollToBottom(): void {
    try {
      this.myScrollContainer.nativeElement.scrollTop = this.myScrollContainer.nativeElement.scrollHeight;
    } catch (err) { }
  }

  private removerAcentos(s) {
    return s.normalize('NFD').replace(/[\u0300-\u036f]/g, "")
  }
}
