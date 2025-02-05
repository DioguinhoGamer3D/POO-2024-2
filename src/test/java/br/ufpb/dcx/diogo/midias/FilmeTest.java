package br.ufpb.dcx.ayla.midias;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FilmeTest {

    @Test
    public void testaConstrutor(){
        Filme filme1 = new Filme("Titanic", 120, 1998);
        assertTrue(filme1.getTitulo().equals("Titanic"));
        assertEquals(120, filme1.getDuracao());
        assertEquals(1998, filme1.getAnoLancamento());
    }


    @Test
    public void testaEhLongaMetragem(){
        Filme filme1 = new Filme("Titanic", 120, 1998);
        assertTrue(filme1.ehLongaMetragem());
        Filme filme2 = new Filme("A volta dos que não foram", 60, 1980);
        assertTrue(filme2.ehLongaMetragem());
        Filme filme3 = new Filme("A Noviça Rebelde", 172, 1965);
        assertTrue(filme3.ehLongaMetragem());
        Filme filme4 = new Filme("O menino que sabia voar", 11, 2022);
        assertFalse(filme4.ehLongaMetragem());

    }

}
