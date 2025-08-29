public abstract class Conta implements IConta {

    private static final int AGENCIA_PADRAO = 1;
    private static int SEQUENCIAL = 1;

    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(double valor) {
        if(valor <= 0) {
            System.out.println("Valor inválido para saque!");
            return;
        }
        if(valor > saldo) {
            System.out.println("Saldo insuficiente!");
            return;
        }
        saldo -= valor;
    }

    @Override
    public void depositar(double valor) {
        if(valor <= 0) {
            System.out.println("Valor inválido para depósito!");
            return;
        }
        saldo += valor;
    }

    @Override
    public void transferir(double valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public int getAgencia() { return agencia; }
    public int getNumero() { return numero; }
    public double getSaldo() { return saldo; }

    protected void imprimirInfosComuns() {
        System.out.println("==== Informações da Conta ====");
        System.out.println("Titular: " + cliente.getNome());
        System.out.println("Agência: " + agencia);
        System.out.println("Número: " + numero);
        System.out.printf("Saldo: R$ %.2f%n", saldo);
        System.out.println("==============================");
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$ " + saldo);
    }
}
