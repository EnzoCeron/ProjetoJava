import java.io.*;
import java.util.HashMap;

public class Concessionaria implements Serializable {
    private HashMap<Veiculo, Integer> estoque;
    private HashMap<Vendedor, Integer> equipe;
    private HashMap<Comprador, Integer> clientes;

    public Concessionaria() {
        estoque = new HashMap<>();
        equipe = new HashMap<>();
        clientes = new HashMap<>();
    }

    public void adicionarVendedor(Vendedor vendedor) {
        equipe.put(vendedor, equipe.getOrDefault(vendedor, 0) + 1);
    }

    public void adicionarComprador(Comprador comprador) {
        clientes.put(comprador, clientes.getOrDefault(comprador, 0) + 1);
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        estoque.put(veiculo, estoque.getOrDefault(veiculo, 0) + 1);
    }

    public void venderVeiculo(Veiculo veiculo) {
        estoque.put(veiculo, estoque.get(veiculo) - 1);
    }

    public int getEstoqueVeiculo(Veiculo veiculo) {
        return estoque.getOrDefault(veiculo, 0);
    }

    public HashMap<Veiculo, Integer> getEstoque() {
        return estoque;
    }

    public HashMap<Vendedor, Integer> getEquipe() {
        return equipe;
    }

    public HashMap<Comprador, Integer> getClientes() {
        return clientes;
    }

    public void lerDados(String nomeArquivo) throws IOException {

        BufferedReader leitor = null;
    
        try {
            leitor = new BufferedReader(new FileReader(nomeArquivo));
            String linha;
    
            while ((linha = leitor.readLine()) != null) {
                String[] dados = linha.split(",");
                String tipo = dados[0];
    
                if (tipo.equals("carro")) {
                    String marca = dados[1];
                    String modelo = dados[2];
                    String cor = dados[3];
                    int ano = Integer.parseInt(dados[4]);
                    adicionarVeiculo(new Carro(marca, modelo, cor, ano));
                } else if (tipo.equals("moto")) {
                    String marca = dados[1];
                    String modelo = dados[2];
                    int cilindradas = Integer.parseInt(dados[3]);
                    adicionarVeiculo(new Moto(marca, modelo, cilindradas));}
                else if (tipo.equals("Vendedor")) {
                    String nome = dados[1];
                    String email = dados[2];
                    int idade = Integer.parseInt(dados[3]);
                    double cpf = Double.parseDouble(dados[4]);
                    int idFuncionario = Integer.parseInt(dados[5]);
                    adicionarVendedor(new Vendedor(nome, email, idade, cpf, idFuncionario));
                } else if (tipo.equals("Comprador")) {
                    String nome = dados[1];
                    String email = dados[2];
                    int idade = Integer.parseInt(dados[3]);
                    double cpf = Double.parseDouble(dados[4]);
                    String endereco = dados[5];
                    adicionarComprador(new Comprador(nome, email, idade, cpf, endereco));
                }
            }
            
        } finally {
            if (leitor != null) {
                leitor.close();
            }
        }
    }

    public int getIdade() {
        return clientes.keySet().iterator().next().getIdade();
    }
}
        
    


