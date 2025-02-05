package br.ufpb.dcx.ayla.midias;

import java.util.List;
import java.util.LinkedList;

public class Serie extends MidiaAudioVisual{


    private List<Episodio> episodios;

    public Serie(String titulo, int anoLancamento, List<Episodio> episodios){
        super(titulo, anoLancamento);
        this.episodios = episodios;
    }

    public Serie(String titulo, int anoLancamento){
        this(titulo, anoLancamento, new LinkedList<>());
    }


    @Override
    public void reproduzir(){
        System.out.println("Reproduzindo a série genérica");
    }

    @Override
    public int getDuracao(){
        int somaDuracao = 0;
        for (Episodio ep: this.episodios){
            somaDuracao+= ep.getDuracao();
        }
        return somaDuracao;
    }

}
