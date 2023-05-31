import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ConcessionariaGUI {
    private Concessionaria concessionaria;
    private JFrame frame;
    private JTextArea textArea;

    public ConcessionariaGUI(Concessionaria concessionaria) {
        this.concessionaria = concessionaria;
        SwingUtilities.invokeLater(this::createGUI);
    }

    private void createGUI() {
        frame = new JFrame("Concessionaria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());

        // Criação do painel dos botões
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(10, 10, 10, 10);

        JButton showButtonCar = new JButton("Mostrar Veiculos");
        showButtonCar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                for (Veiculo veiculo : concessionaria.getEstoque().keySet()) {
                    if (veiculo instanceof Carro) {
                        textArea.append(((Carro) veiculo).mostrarInformacoes() + "\n");
                    } else if (veiculo instanceof Moto) {
                        textArea.append(((Moto) veiculo).mostrarInformacoes() + "\n");
                    }
                }
            }
        });
        buttonPanel.add(showButtonCar, gbc);

        JButton showButtonVendedor = new JButton("Mostrar Vendedores");
        gbc.gridx = 1;
        showButtonVendedor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                for (Vendedor vendedor : concessionaria.getEquipe().keySet()) {
                    if (vendedor.getClass() == Vendedor.class) {
                        textArea.append(vendedor.showInformacoes() + "\n");
                    }
                }
            }
        });
        buttonPanel.add(showButtonVendedor, gbc);

        JButton showButtonClientes = new JButton("Mostrar Clientes");
        gbc.gridx = 2;
        showButtonClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                for (Comprador comprador : concessionaria.getClientes().keySet()) {
                    if (comprador.getClass() == Comprador.class) {
                        textArea.append(comprador.showInformacoes() + "\n");
                    }
                }
            }
        });
        buttonPanel.add(showButtonClientes, gbc);

        JButton comprarButton = new JButton("Comprar Veículo");
        gbc.gridx = 3;
        comprarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nomeComprador = JOptionPane.showInputDialog(frame, "Digite o nome do comprador:");
                String nomeCarro = JOptionPane.showInputDialog(frame, "Digite o nome do carro:");
                String nomeVendedor = JOptionPane.showInputDialog(frame, "Digite o nome do vendedor:");
        
                Comprador comprador = null;
                for (Entry<Comprador, Integer> entry : concessionaria.getClientes().entrySet()) {
                    if (entry.getKey().getNome().equals(nomeComprador)) {
                        comprador = entry.getKey();
                        break;
                    }
                }
        
                Veiculo veiculo = null;
                for (Entry<Veiculo, Integer> entry : concessionaria.getEstoque().entrySet()) {
                    if (entry.getKey().getNome().equals(nomeCarro)) {
                        veiculo = entry.getKey();
                        break;
                    }
                }
        
                Vendedor vendedor = null;
                for (Entry<Vendedor, Integer> entry : concessionaria.getEquipe().entrySet()) {
                    if (entry.getKey().getNome().equals(nomeVendedor)) {
                        vendedor = entry.getKey();
                        break;
                    }
                }
        
                if (comprador != null && veiculo != null && vendedor != null) {
                    try {
                        comprador.comprarVeiculo(veiculo, vendedor, concessionaria);
                        JOptionPane.showMessageDialog(frame, "Veículo comprado com sucesso!");
                    } catch (IdadeInsuficienteException ex) {
                        JOptionPane.showMessageDialog(frame, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "Dados inválidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        });
        buttonPanel.add(comprarButton, gbc);
        






        // Adiciona o painel dos botões ao painel principal
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(10, 10, 10, 10);
        mainPanel.add(buttonPanel, gbc);

        // Criação do painel de exibição das informações
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(10, 10, 10, 10);
        mainPanel.add(scrollPane, gbc);

        frame.add(mainPanel);
        frame.pack();
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Abre a janela em tela cheia após a exibição inicial
    }
}

