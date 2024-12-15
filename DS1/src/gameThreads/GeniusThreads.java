package gameThreads;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class GeniusThreads extends JFrame {
    private JButton botaoVerde, botaoVermelho, botaoAzul, botaoAmarelo, botaoIniciar;
    private ArrayList<Integer> sequenciaCores = new ArrayList<>();
    private int posicaoDoJogador = 0;
    private boolean rodadaDoJogador = false;

    public GeniusThreads() {
        setTitle("Genius");
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel blocoDeCores = new JPanel();
        blocoDeCores.setLayout(new GridLayout(2, 2));

        botaoVerde = criarBotao(Color.GREEN);
        botaoVermelho = criarBotao(Color.RED);
        botaoAzul = criarBotao(Color.BLUE);
        botaoAmarelo = criarBotao(Color.YELLOW);



        blocoDeCores.add(botaoVerde);
        blocoDeCores.add(botaoVermelho);
        blocoDeCores.add(botaoAzul);
        blocoDeCores.add(botaoAmarelo);

        add(blocoDeCores, BorderLayout.CENTER);

        botaoIniciar = new JButton("Começar");
        botaoIniciar.addActionListener(e -> iniciarJogo());
        add(botaoIniciar, BorderLayout.SOUTH);






    }


    private JButton criarBotao(Color cor) {
        JButton botao = new JButton();
        botao.setBackground(cor);
        botao.setEnabled(false);
        botao.addActionListener(e -> verificarJogada(botao));
        return botao;
    }


    private void iniciarJogo() {
        sequenciaCores.clear();
        posicaoDoJogador = 0;
        rodadaDoJogador = false;
        botaoIniciar.setEnabled(false);
        addSequenciaCores();
    }





    private void addSequenciaCores() {
        Random gerador = new Random();
        sequenciaCores.add(gerador.nextInt(4));
        new Thread(this::mostrarSequencia).start();
    }

    private void mostrarSequencia() {
        desabilitarBotoes();
        for (int indice : sequenciaCores) {
            new Thread(() -> piscarBotao(indiceBotao(indice))).start();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                JOptionPane.showMessageDialog(this, e);
            }

        }
        rodadaDoJogador = true;
        SwingUtilities.invokeLater(this::habilitarBotoes);
    }

    private void verificarJogada(JButton botaoClicado) {
        if (!rodadaDoJogador) return;

        int indice = pegarIndicePorBotao(botaoClicado);



        if (indice == sequenciaCores.get(posicaoDoJogador)) {
            posicaoDoJogador++;
            if (posicaoDoJogador == sequenciaCores.size()) {
                rodadaDoJogador = false;
                desabilitarBotoes();
                JOptionPane.showMessageDialog(this, "acertou! Próxima rodada.");
                posicaoDoJogador = 0;
                addSequenciaCores();
            }
        } else {
            rodadaDoJogador = false;
            desabilitarBotoes();
            JOptionPane.showMessageDialog(this, "Errou! jogo acabou.");
            botaoIniciar.setEnabled(true);
        }

    }

    private void piscarBotao(JButton botao) {


        try {
            SwingUtilities.invokeLater(() -> botao.setBackground(botao.getBackground().darker()));
            Thread.sleep(300);
            SwingUtilities.invokeLater(() -> botao.setBackground(botao.getBackground().brighter()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    private void desabilitarBotoes() {
        botaoVerde.setEnabled(false);
        botaoVermelho.setEnabled(false);
        botaoAzul.setEnabled(false);
        botaoAmarelo.setEnabled(false);
    }

    private void habilitarBotoes() {
        botaoVerde.setEnabled(true);
        botaoVermelho.setEnabled(true);
        botaoAzul.setEnabled(true);
        botaoAmarelo.setEnabled(true);
    }

    private int pegarIndicePorBotao(JButton botao) {
        if (botao == botaoVerde) {
            return 0;
        } else if (botao == botaoVermelho) {
            return 1;
        } else if (botao == botaoAzul) {
            return 2;
        } else if (botao == botaoAmarelo) {
            return 3;
        } else {
            return -1;
        }
    }



    private JButton indiceBotao(int indice) {
        if (indice == 0) {
            return botaoVerde;
        } else if (indice == 1) {
            return botaoVermelho;
        } else if (indice == 2) {
            return botaoAzul;
        } else if (indice == 3) {
            return botaoAmarelo;
        } else {
            return null;
        }
    }



}
