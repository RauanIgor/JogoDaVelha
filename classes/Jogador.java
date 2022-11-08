package Praticas.JogoDaVelha.classes;

public class Jogador {

    private String nome;
    private int pontuacao;
    private Marcacao marca;

    public Jogador(String nome) {
        this.nome = nome;
        pontuacao = 0;
    }

    public String getNome() {
        return nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public Marcacao getMarca() {
        return marca;
    }

    public void setMarca(Marcacao marca) {
        this.marca = marca;
    }
    
    public void addPonto() {
        pontuacao++;
    }
    
}
