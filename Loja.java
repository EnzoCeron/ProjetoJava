import java.util.ArrayList;

public class Loja {
    private String nome;
    private String endereco;
    private String telefone;
    private double faturamentoMensal;
    private double despesasMensais;
    private ArrayList<Cliente> clientes;
    private ArrayList<Venda> vendas;
    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Veiculo> estoque;

    public Loja(String nome, String endereco, String telefone, double faturamentoMensal, double despesasMensais, ArrayList<Cliente> clientes, ArrayList<Venda> vendas, ArrayList<Funcionario> funcionarios, ArrayList<Veiculo> estoque){
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.faturamentoMensal = faturamentoMensal;
        this.despesasMensais = despesasMensais;
        this.clientes = clientes;
        this.vendas = vendas;
        this.funcionarios = funcionarios;
        this.estoque = estoque;
    }

}




