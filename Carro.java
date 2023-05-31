public class Carro extends Veiculo {
    private String cor;
    private int ano;

    public Carro(String marca, String modelo, String cor, int ano) {
        super(marca, modelo);
        this.cor = cor;
        this.ano = ano;
    }

    @Override
    public String mostrarInformacoes() {
        return ("Carro -> Marca: " + marca + ", Modelo: " + modelo + ", Cor: " + cor + ", Ano: " + ano);
    }

    

    
}
