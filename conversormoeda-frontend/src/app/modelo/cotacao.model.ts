import { Moeda } from './moeda.model'

export class CotacaoModel {
    public id: number
    public moedaOrigem: Moeda
    public moedaDestino: Moeda
    public valorOrigem: number
    public valorDestino: number
}