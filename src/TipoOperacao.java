public enum TipoOperacao {
    DEPOSITO('d', "Depósito"),
    SAQUE('s', "Saque");

    private final char codigo;
    private final String descricao;

    TipoOperacao(char codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoOperacao buscarPorCodigo(char codigo) {
        for (TipoOperacao tipo : values()) {
            if (tipo.codigo == codigo) {
                return tipo;
            }
        }
        return null;
    }
}
