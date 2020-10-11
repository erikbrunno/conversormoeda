import { Moeda } from './../../modelo/moeda.model';
import { MoedaService } from './../../servicos/moeda.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { CotacaoInput } from 'src/app/modelo/input/cotacao.input';
import { CotacaoService } from 'src/app/servicos/cotacao.service';
import { CotacaoModel } from 'src/app/modelo/cotacao.model';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-conversor-moeda-add',
  templateUrl: './conversor-moeda-add.component.html',
  styleUrls: ['./conversor-moeda-add.component.css']
})
export class ConversorMoedaAddComponent implements OnInit {

  public moedas: Moeda[]
  //public cotacao: CotacaoInput = new CotacaoInput()
  public cotacaoModel: CotacaoModel = new CotacaoModel()

  public formulario: FormGroup = new FormGroup({
    'dataConsulta': new FormControl(null, [ Validators.required ]),
    'valorOrigem': new FormControl(null, [ Validators.required ]),
    'moedaOrigemId': new FormControl(null, [ Validators.required ]),
    'moedaDestinoId': new FormControl(null, [ Validators.required ])
  })

  constructor(
    private moedaService: MoedaService,
    private cotacaoService: CotacaoService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.moedaService.consultar().subscribe((moedas: Moeda[]) => {
      this.moedas = moedas
    })
  }

  public salvar(): void {

    console.log("Chegou aqui")

    if (this.formulario.status == 'INVALID') {
      this.formulario.get('dataConsulta').markAsTouched()
      this.formulario.get('valorOrigem').markAsTouched()
      this.formulario.get('moedaOrigemId').markAsTouched()
      this.formulario.get('moedaDestinoId').markAsTouched()
    } else {

      let cotacao: CotacaoInput = new CotacaoInput() 
      cotacao.dataConsulta = this.formulario.value.dataConsulta
      cotacao.valorOrigem = this.formulario.value.valorOrigem
      cotacao.moedaOrigem.id = this.formulario.value.moedaOrigemId
      cotacao.moedaDestino.id = this.formulario.value.moedaDestinoId

      console.log(cotacao)

      this.cotacaoService.salvar(cotacao).subscribe((cotacaoModel: CotacaoModel) => {      
          this.cotacaoModel = cotacaoModel
      })

    }
  }

  public cancelar(): void {
    this.router.navigate(['/conversor-moeda'])
  }
}
