package Praticas.JogoDaVelha.classes;

import java.util.Arrays;

public class Tabuleiro {

    private Marcacao[][] grade;
    private boolean preenchido;

    public Tabuleiro() {
        grade = new Marcacao[3][3];
        preenchido = false;
    }
    
    public void iniciar() {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(grade[i], Marcacao.VAZIO);
        }
        preenchido = false;
    }
    
    public boolean marcar(Marcacao m, int linha, int coluna) {
        if (grade[linha][coluna] == Marcacao.VAZIO) {
            grade[linha][coluna] = m;
            return true;
        }
        return false;
    }
    
    public boolean checarJogo(Marcacao m) {
        int jogadas = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grade[i][j] != Marcacao.VAZIO) {
                    jogadas++;
                }
            }
        }
        if (jogadas == 9) {
            preenchido = true;
        }
        if ( ( grade[0][0] == grade[0][1] && grade[0][0] == grade[0][2] ) 
                && grade[0][0] == m) {
            return true;
        }
        if ( ( grade[1][0] == grade[1][1] && grade[1][0] == grade[1][2] )
                && grade[1][0] == m) {
            return true;
        }
        if ( ( grade[2][0] == grade[2][1] && grade[2][0] == grade[2][2] )
                && grade[2][0] == m) {
            return true;
        }
        if ( ( grade[0][0] == grade[1][0] && grade[0][0] == grade[2][0] )
                && grade[0][0] == m) {
            return true;
        }
        if ( ( grade[0][1] == grade[1][1] && grade[0][1] == grade[2][1] )
                && grade[0][1] == m) {
            return true;
        }
        if ( ( grade[0][2] == grade[1][2] && grade[0][2] == grade[2][2] )
                && grade[0][2] == m) {
            return true;
        }
        if ( ( grade[0][0] == grade[1][1] && grade[0][0] == grade[2][2] )
                && grade[0][0] == m) {
            return true;
        }
        if ( ( grade[0][2] == grade[1][1] && grade[0][2] == grade[2][0] )
                && grade[0][2] == m) {
            return true;
        }
        return false;
    }

    public boolean isPreenchido() {
        return preenchido;
    }
    
    public String traduzir(Marcacao m) {
        switch (m) {
            case O:
                return "O";
            case X:
                return "X";
            case VAZIO:
                return " ";
        }
        return "";
    }

    @Override
    public String toString() {
        String tela = "\n";
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tela += traduzir(grade[i][j]);
                if (j < 2) {
                    tela += "|";
                }
            }
            tela += "\n";
            if (i < 2) {
                tela += "-----\n"; 
            }
        }
        return tela;
    }
    
}
