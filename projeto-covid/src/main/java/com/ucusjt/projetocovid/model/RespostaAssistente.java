package com.ucusjt.projetocovid.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ucusjt.projetocovid.dto.RespostaAssistenteDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "resposta_assistente", schema = "public")
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RespostaAssistente{

    @Id
    @Column(name =  "id")
    private Long id;

    @Column(name =  "resposta")
    private String resposta;

    public RespostaAssistente (RespostaAssistenteDTO respostaAssistente){
        super();
        this.id = respostaAssistente.getId();
        this.resposta = respostaAssistente.getResposta();
    }
}