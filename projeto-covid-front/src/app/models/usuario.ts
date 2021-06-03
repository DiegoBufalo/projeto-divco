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

export interface All {
  confirmed: number;
  recovered: number;
  deaths: number;
  country: string;
  population: number;
  continent: string;
  abbreviation: string;
  capital_city: string;
  actives: number,
  percentdeaths: number,
  percentRecovered: number,
  percentpopuCase: number,
  percentActive: number
}

export interface State {
  lat: string;
  long: string;
  confirmed: number;
  recovered: number;
  deaths: number;
  updated: string;
}
