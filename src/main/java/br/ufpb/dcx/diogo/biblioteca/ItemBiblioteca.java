package br.ufpb.dcx.diogo.biblioteca;

public abstract class ItemBiblioteca {

    private String titulo;
    private String autor;
    private int anoPublicacao;

    public void setTitulo(String novoTitulo){
        this.titulo=novoTitulo;
    }
    public String getTitulo(){
        return this.titulo;
    }
    public void setAutot(String novoAutor){
        this.autor=novoAutor;
    }
    public String getAutor(){
        return this.autor;
    }
    public void setAnoPublicacao(int novoAno){
        this.anoPublicacao=novoAno;
    }
    public int getAnoPublicacao(){
        return anoPublicacao;
    }
    public void emprestar(){
        //TODO
    }
    public void devolver(){
        //TODO
    }
    public String exibirDetalhes(){
        //TODO
        return null;
    }
}
