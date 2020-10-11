import { CotacaoModel } from './../modelo/cotacao.model';
import { CotacaoInput } from './../modelo/input/cotacao.input';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map, catchError } from 'rxjs/operators';
import { MatSnackBar } from '@angular/material/snack-bar'
import { Observable, EMPTY } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CotacaoService {

    private baseUrl = "http://localhost:8080/cotacao-moeda"
    
    constructor(
        private snackBar: MatSnackBar,
        private http: HttpClient
    ) { }

    public consultar(): Observable<CotacaoModel[]> {
        return this.http.get<CotacaoModel[]>(this.baseUrl)
          .pipe(
            map(obj => obj),
            catchError(e => this.errorHandler(e))
          )
      }

    public salvar(cotacao: CotacaoInput): Observable<CotacaoModel> {
        return this.http.post<CotacaoInput>(this.baseUrl, cotacao)
            .pipe(
                map(obj => obj),
                catchError(e => this.errorHandler(e))    
            )
    }

    private errorHandler(e: any): Observable<any> {
        this.exibirMensagem(e.error.userMessage, true)
        return EMPTY
    }

    public exibirMensagem(mensagem: string, temErro: boolean = false): void {
       this.snackBar.open(mensagem, 'X', {
            duration: 3000,
            horizontalPosition: 'right',
            verticalPosition: 'top',
            panelClass: temErro ? ['msg-erro'] : ['msg-sucesso']
        })
    }
  
}
