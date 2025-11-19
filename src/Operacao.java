public class Operacao {

    private TipoOperacao tipo;
    private double valor;

    public Operacao(char codigoTipo, double valor) {
        this.tipo = TipoOperacao.buscarPorCodigo(codigoTipo);
        this.valor = valor;
    }

    public String toString() {
        String descricaoTipo = (this.tipo != null) ? this.tipo.getDescricao() : "Desconhecido";
        return descricaoTipo + ":\t" + this.valor;
    }
}
