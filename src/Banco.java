import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
    public void adicionarConta(Conta conta) {
        if (conta != null) {
            this.contas.add(conta);
        }
    }
    public Conta buscarConta(int numero) {
        if (contas != null) {
            for (Conta c : contas) {
                if (c.getNumero() == numero) {
                    return c;
                }
            }
        }
        return null; 
    }
    public void imprimirResumoContas() {
        System.out.println("=== Resumo das Contas do Banco " + nome + " ===");
        if (contas != null && !contas.isEmpty()) {
            for (Conta c : contas) {
                c.imprimirInfosComuns();
            }
        } else {
            System.out.println("Nenhuma conta cadastrada.");
        }
    }
}
