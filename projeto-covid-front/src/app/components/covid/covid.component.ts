import { formatPercent } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { All, State } from 'src/app/models/usuario';
import { CovidService } from 'src/app/services/covid.service';

@Component({
  selector: 'app-covid',
  templateUrl: './covid.component.html',
  styleUrls: ['./covid.component.css']
})
export class CovidComponent implements OnInit {

  brasil: All = {
    confirmed: null,
    recovered: null,
    deaths: null,
    country: '',
    population: null,
    continent: '',
    abbreviation: '',
    capital_city: '',
    actives: null,
    percentRecovered: null,
    percentActive: null,
    percentdeaths: null,
    percentpopuCase: null,
  }

  saoPaulo: State ={
    lat: '',
    long: '',
    confirmed: null,
    recovered: null,
    deaths: null,
    updated: ''
  }

  constructor(
    private service: CovidService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.getPais('Brazil');
  }

  getPais(pais: string): void {
    this.service.readBrasil(pais)
      .subscribe(
        data => {
          this.brasil.confirmed = data.All.confirmed;
          this.brasil.recovered = data.All.recovered;
          this.brasil.deaths = data.All.deaths;
          this.brasil.country = data.All.country;
          this.brasil.population = data.All.population;
          this.brasil.continent = data.All.continent;
          this.brasil.abbreviation = data.All.abbreviation;
          this.brasil.capital_city = data.All.capital_city;
          this.brasil.actives = (data.All.confirmed - data.All.recovered - data.All.deaths);
          this.brasil.percentActive = (100 - (100 * (data.All.recovered / (data.All.confirmed -data.All.deaths))));
          this.brasil.percentRecovered = (100 * (data.All.recovered / data.All.confirmed));
          this.brasil.percentpopuCase = (100 * (data.All.confirmed / data.All.population));
          this.brasil.percentdeaths = (100 * (data.All.deaths / data.All.confirmed));

          this.saoPaulo.confirmed = data["Sao Paulo"].confirmed;
          this.saoPaulo.deaths = data["Sao Paulo"].deaths;
          this.saoPaulo.recovered = data["Sao Paulo"].recovered;
          this.saoPaulo.updated = data["Sao Paulo"].updated;
        });
        console.log(this.brasil)
        console.log(this.saoPaulo)
  }

}
