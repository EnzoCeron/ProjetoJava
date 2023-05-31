import java.io.Serializable;

public abstract class Veiculo implements Serializable {
    protected String marca;
    protected String modelo;

    public Veiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public abstract String mostrarInformacoes();

    public Object getNome(){
        return modelo;
    };
        
    

}
