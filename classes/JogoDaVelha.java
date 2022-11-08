package Praticas.JogoDaVelha.classes;

import java.util.Scanner;

public class JogoDaVelha {

    private Jogador jogador1;
    private Jogador jogador2;
    private Tabuleiro tabuleiro;
    private boolean acabou;

    public JogoDaVelha(Jogador jogador1, Jogador jogador2) {
        this.jogador1 = jogador1;
        this.jogador1.setMarca(Marcacao.X);
        this.jogador2 = jogador2;
        this.jogador2.setMarca(Marcacao.O);
        tabuleiro = new Tabuleiro();
        acabou = false;
    }
    
    public void jogar() {
        Jogador jogadorDaVez = jogador1;
        tabuleiro.iniciar();
        Scanner entrada = new Scanner(System.in);
        
        while (!acabou) {
            
            if (jogadorDaVez == jogador1) {
                System.out.println(jogador1.getNome() + "\t"
                + jogador1.getPontuacao() + " *");
                System.out.println(jogador2.getNome() + "\t"
                + jogador2.getPontuacao());
            } else {
                System.out.println(jogador1.getNome() + "\t"
                + jogador1.getPontuacao());
                System.out.println(jogador2.getNome() + "\t"
                + jogador2.getPontuacao() + " *");
            }
            
            System.out.println(tabuleiro);
            
            if (!tabuleiro.isPreenchido()) {
                int linha, coluna;
                System.out.print("Informe linha e coluna: ");
                linha = entrada.nextInt();
                coluna = entrada.nextInt();
                
                while (!tabuleiro.marcar(jogadorDaVez.getMarca(),
                        linha, coluna)) {
                    System.out.print("Informe novamente outra linha e coluna: ");
                    linha = entrada.nextInt();
                    coluna = entrada.nextInt();
                }
                
                if (jogadorDaVez == jogador1) {
                    jogadorDaVez = jogador2;
                } else {
                    jogadorDaVez = jogador1;
                }
            }
            
            if (tabuleiro.checarJogo(jogador1.getMarca())) {
                System.out.println("Vitória de " +
                        jogador1.getNome());
                jogador1.addPonto();
                acabou = true;
            } else if (tabuleiro.checarJogo(jogador2.getMarca())) {
                System.out.println("Vitória de " +
                        jogador2.getNome());
                jogador2.addPonto();
                acabou = true;
            } else if (tabuleiro.isPreenchido()) {
                System.out.println("Houve empate!");
                acabou = true;
            }
            
        }
        
        System.out.print("Deseja iniciar nova partida (S ou N)? ");
        String escolha = entrada.next();
        if (escolha.charAt(0) == 'S') {
            acabou = false;
            jogar();
        }
    }
    
    public static void main(String[] args) {
        JogoDaVelha jv = new JogoDaVelha(
                new Jogador("Fulano"),
                new Jogador("Cicrano"));
        jv.jogar();
    }
    
}
