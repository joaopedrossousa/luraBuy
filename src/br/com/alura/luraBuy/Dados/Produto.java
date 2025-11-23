package br.com.alura.luraBuy.Dados;

public class Produto {
    private String nome;
    private double valor;

    public Produto(){ }

    public Produto(String nome, double valor){
        this.nome = nome;
        this.valor = valor;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }

    @Override
    public String toString() {
        return nome + " - R$" + String.format("%.2f", valor);
    }
}
