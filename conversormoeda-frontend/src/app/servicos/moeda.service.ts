import { Moeda } from './../modelo/moeda.model';
import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { map, catchError } from 'rxjs/operators';
import { MatSnackBar } from '@angular/material/snack-bar'
import { Observable, EMPTY } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MoedaService {
    private baseUrl = "http://localhost:8080/moedas"
  
    constructor(
        private snackBar: MatSnackBar,
        private http: HttpClient
    ) { }


    public consultar(): Observable<Moeda[]> {
        return this.http.get<Moeda[]>(this.baseUrl)
        .pipe(
            map(obj => obj),
            catchError(e => this.errorHandler(e))
        )
    }

    private errorHandler(e: any): Observable<any> {
        this.exibirMensagem('Ocorreu um erro!!!', true)
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
