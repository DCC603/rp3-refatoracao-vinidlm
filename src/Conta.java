import java.util.ArrayList;
import java.util.List;

public class Conta {

    private Cliente cliente;
    private Agencia agencia;
    private int numConta;
    private double saldo;
    private List<Operacao> operacoes;

    public Conta(String nomeCliente, String cpfCliente, String telefoneCliente, int numAgencia, int numConta, String gerente, double saldoInicial) {
        this.cliente = new Cliente(nomeCliente, cpfCliente, telefoneCliente);
        this.agencia = new Agencia(numAgencia, gerente);
        this.numConta = numConta;
        this.saldo = saldoInicial;
        this.operacoes = new ArrayList<>();
    }

    public Conta() {
        this(null, null, null, 0, 0, null, 0);
    }

    public void realizarOperacao(char tipo, int valor) {
        registrarOperacao(tipo, valor);
        atualizarSaldo(tipo, valor);
    }

    private void registrarOperacao(char tipo, int valor) {
        Operacao op = new Operacao(tipo, valor);
        this.operacoes.add(op);
    }

    private void atualizarSaldo(char tipo, int valor) {
        if (tipo == 'd') {
            depositar(valor);
        } else if (tipo == 's') {
            sacar(valor);
        }
    }

    private void depositar(double valor) {
        this.saldo += valor;
    }

    private void sacar(double valor) {
        this.saldo -= valor;
    }

    public String getExtratoFormatado() {
        StringBuilder dadosExtrato = new StringBuilder();
        for (Operacao op : this.operacoes) {
            dadosExtrato.append(op.toString()).append("\n");
        }
        return dadosExtrato.toString();
    }

    @Override
    public String toString() {
        return "-----CLIENTE-----\n" +
                this.cliente.toString() +
                "\n\n" +
                "-----CONTA-----\n" +
                this.agencia.toString() + "\n" +
                String.format("Conta: %d\nSaldo: %.2f", this.numConta, this.saldo) +
                "\n\n" +
                "-----EXTRATO-----\n" +
                getExtratoFormatado() +
                "\n";
    }
}
