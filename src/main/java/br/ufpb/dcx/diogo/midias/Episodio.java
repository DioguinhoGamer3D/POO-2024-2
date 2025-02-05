package br.ufpb.dcx.ayla.midias;

public class Episodio extends MidiaAudioVisual{

    private int duracao;

    public Episodio(String titulo, int duracao, int anoLancamento){
        super(titulo, anoLancamento);
        this.duracao = duracao;
    }

    public int getDuracao(){
        return this.duracao;
    }

    public void reproduzir(){
        System.out.println("Reproduzindo o episódio "+ super.getTitulo());
    }

}
