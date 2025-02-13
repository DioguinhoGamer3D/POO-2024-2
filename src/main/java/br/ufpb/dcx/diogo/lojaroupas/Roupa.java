package br.ufpb.dcx.diogo.lojaroupas;

public class Roupa {
    private String codigo;
    private String descricao;
    private int quantidade;
    private Tamanho tamanho;

    public Roupa(String codigo, String descricao, Tamanho tamanho, int quantidade) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.tamanho = tamanho;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
