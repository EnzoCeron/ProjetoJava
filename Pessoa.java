import java.io.Serializable;

 public abstract  class Pessoa implements Serializable {
    protected String nome;
    protected String email;
    protected int idade;
    protected double cpf;

    public Pessoa(String nome, String email, int idade, double cpf) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.cpf = cpf;
    }

    public String showInformacoes() {
        return "Nome: " + nome + "\nEmail: " + email + "\nIdade: " + idade + "\nCPF: " + cpf;
    }

}