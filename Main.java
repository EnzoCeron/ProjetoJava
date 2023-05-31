import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;



public class Main {
    public static void main(String[] args) {
        Concessionaria concessionaria = new Concessionaria();
        
        try {
            concessionaria.lerDados("veiculos.csv");
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
        
        try {
            FileOutputStream fos = new FileOutputStream("concessionaria.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(concessionaria);
            oos.close();
            fos.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        new ConcessionariaGUI(concessionaria);
    }
}


    
