import { MoedaIdInput } from './moeda.id.input'

export class CotacaoInput {
    public moedaOrigem: MoedaIdInput = new MoedaIdInput
    public moedaDestino: MoedaIdInput = new MoedaIdInput
    public valorOrigem: number
    public dataConsulta: Date
}