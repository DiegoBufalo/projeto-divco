export interface Usuario {
  id?: number;
  nome?: string;
  sobrenome?: string;
  email?: string;
  senha?: string;
  cpf?: string;
  dataNascimento?: string;
  tipoUsuario?: string;
  profSaude?: boolean;
  endereco?: string;
  dataVacinacao?: string;
}

export interface Pergunta{
  pergunta: string;
}

export interface UsuarioAtualizar{
  id?: number;
  nome?: string;
  sobrenome?: string;
  email?: string;
  senha?: string;
  tipoUsuario?: string;
  profSaude?: boolean;
  endereco?: string;
}
