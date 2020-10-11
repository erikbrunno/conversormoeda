import { HeaderService } from './../../components/template/header/header.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'

@Component({
  selector: 'app-conversor-moeda',
  templateUrl: './conversor-moeda.component.html',
  styleUrls: ['./conversor-moeda.component.css']
})
export class ConversorMoedaComponent implements OnInit {

  constructor(
    private router: Router,
    private headerService: HeaderService
  ) { 
    headerService.header = {
      title: 'Histórico de conversão de moedas',
      icon: 'storefront',
      routerUrl: '/conversor-moeda'
    }
  }

  ngOnInit(): void {
  }

  public navegarParaConversorMoedaAdd(): void {
    this.router.navigate(['/conversor-moeda/adicionar'])
  }

}
