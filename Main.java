import java.util.ArrayList;
import java.util.List;

class Funcionario {
    protected String nome;
    protected int horas;
    protected double valorHora;

    public Funcionario(String nome, int horas, double valorHora) {
        this.nome = nome;
        this.horas = horas;
        this.valorHora = valorHora;
    }

    public double calcularPagamento() {
        return horas * valorHora;
    }

    public String toString() {
        return "Funcionário: " + nome + "\n" +
               "Horas trabalhadas: " + horas + "\n" +
               "Valor por hora: R$ " + valorHora + "\n" +
               "Pagamento: R$ " + calcularPagamento() + "\n";
    }
}

class FuncionarioTerceirizado extends Funcionario {
    private double despesaAdicional;

    public FuncionarioTerceirizado(String nome, int horas, double valorHora, double despesaAdicional) {
        super(nome, horas, valorHora);
        this.despesaAdicional = despesaAdicional;
    }
    
    @Override
    public double calcularPagamento() {
        return super.calcularPagamento() + despesaAdicional;
    }

    @Override
    public String toString() {
        return "Funcionário Terceirizado: " + nome + "\n" +
               "Horas trabalhadas: " + horas + "\n" +
               "Valor por hora: R$ " + valorHora + "\n" +
               "Cobrança adicional: R$ " + despesaAdicional + "\n" +
               "Pagamento: R$ " + calcularPagamento() + "\n";
    }
}

public class Main {
    public static void main(String[] args) {
        List<Funcionario> funcionarios = new ArrayList<>();

        Funcionario maria = new Funcionario("Maria", 5, 100);
        FuncionarioTerceirizado joao = new FuncionarioTerceirizado("João", 8, 80, 50);

        funcionarios.add(maria);
        funcionarios.add(joao);

        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }
}
