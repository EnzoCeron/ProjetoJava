public class Vendedor extends Pessoa {
    private int idFuncionario;

    public Vendedor(String nome, String email, int idade, double cpf, int idFuncionario) {
        super(nome, email, idade, cpf);
        this.idFuncionario = idFuncionario;
    }
  
    @Override
    public String showInformacoes() {
        return super.showInformacoes() + "\nID Funcionário: " + idFuncionario;
    }

    public Object getNome() {
        return nome;
    }
    

    void venderVeiculo(Veiculo veiculo, Concessionaria concessionaria) {
        concessionaria.venderVeiculo(veiculo);
    }
}