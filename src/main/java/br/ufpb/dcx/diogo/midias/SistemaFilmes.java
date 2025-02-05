package br.ufpb.dcx.ayla.midias;

import java.util.List;
import java.util.LinkedList;

public class SistemaFilmes {

	public static void main(String[] args) {

		List<MidiaAudioVisual> midiasAudioVisuais = new LinkedList<>();
		Filme filme1= new Filme("Divertidamente", 120, 2015);
		midiasAudioVisuais.add(filme1);

		List<Episodio> episodiosSenna = new LinkedList<>();
		episodiosSenna.add(new Episodio("Vocação", 61, 2024));
		episodiosSenna.add(new Episodio("Determinação", 66, 2024));

		Serie serie1 = new Serie("Senna", 2024, episodiosSenna);

		midiasAudioVisuais.add(serie1);

		System.out.println("To String:");
		for(MidiaAudioVisual m: midiasAudioVisuais){
			System.out.println(m.toString());
		}


		for(MidiaAudioVisual m: midiasAudioVisuais){
			m.reproduzir();
		}

	}

}
