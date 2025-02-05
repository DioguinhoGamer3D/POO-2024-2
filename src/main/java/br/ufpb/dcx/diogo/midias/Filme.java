package br.ufpb.dcx.ayla.midias;

import java.util.Objects;

public class Filme extends MidiaAudioVisual{


	private int duracao;


	public Filme(String titulo, int duracao, int anoLancamento) {
		super(titulo, anoLancamento);
		this.duracao = duracao;
	}



	public int getDuracao() {
		return this.duracao;
	}

	public boolean ehLongaMetragem(){
		return this.duracao>=60;
	}


	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}



	@Override
	public String toString() {
		return "br.ufpb.dcx.ayla.midias.Filme " +
				"de titulo '" + super.getTitulo() + '\'' +
				", de duracao " + duracao +
				" minutos, e que foi lançado no ano " + super.getAnoLancamento();
	}



	@Override
	public void reproduzir(){
		System.out.println("Reproduzindo o  "+ this.toString());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		if (!super.equals(o)) return false;
		Filme filme = (Filme) o;
		return duracao == filme.duracao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), duracao);
	}
}
