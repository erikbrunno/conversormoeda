import { CotacaoModel } from 'src/app/modelo/cotacao.model';
import { Component, OnInit } from '@angular/core';
import { CotacaoService } from 'src/app/servicos/cotacao.service';

@Component({
  selector: 'app-conversor-moeda-list',
  templateUrl: './conversor-moeda-list.component.html',
  styleUrls: ['./conversor-moeda-list.component.css']
})
export class ConversorMoedaListComponent implements OnInit {

  public displayedColumns = ['moedaOrigem', 'valorOrigem', 'moedaDestino', 'valorDestino']
  public cotacoes: CotacaoModel[]

  constructor(
    private cotacaoService: CotacaoService
  ) { }

  ngOnInit(): void {
    this.cotacaoService.consultar().subscribe((cotacoes: CotacaoModel[]) => {
      this.cotacoes = cotacoes
      console.log(this.cotacoes)
    })
  }
}
