public class Comprador extends Pessoa {
    private String endereco;
    
    public Comprador(String nome,String email, int idade, double cpf, String endereco) {
        super(nome, email, idade, cpf);
        this.endereco = endereco;
    }

    @Override
    public String showInformacoes() {
        return super.showInformacoes() + "\nEndereço: " + endereco;
    }

    public int getIdade() {
        return idade;
    }

    public String comprarVeiculo(Veiculo veiculo, Vendedor vendedor, Concessionaria concessionaria) throws IdadeInsuficienteException {
        if (concessionaria.getIdade() >= 18) {
            //vendedor.venderVeiculo(veiculo, concessionaria);
            return "Compra realizada com sucesso!";
        } else {
            throw new IdadeInsuficienteException("Idade insuficiente para realizar a compra.");
        }
    }

    public Object getNome() {
        return nome;
    }
}
    