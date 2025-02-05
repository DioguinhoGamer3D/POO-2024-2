package br.ufpb.dcx.ayla.midias;

import java.util.Objects;

public abstract class MidiaAudioVisual implements Midia{

    private String titulo;
    private int anoLancamento;

    public MidiaAudioVisual(String titulo, int anoLancamento){
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
    }

    public abstract int getDuracao();

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String novoTitulo) {
        this.titulo = novoTitulo;
    }

    public int getAnoLancamento() {
        return this.anoLancamento;
    }

    public void setAnoLancamento(int ano) {
        this.anoLancamento = ano;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MidiaAudioVisual that = (MidiaAudioVisual) o;
        return anoLancamento == that.anoLancamento && Objects.equals(titulo, that.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, anoLancamento);
    }
}
