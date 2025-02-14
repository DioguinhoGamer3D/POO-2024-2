package br.ufpb.dcx.diogo.lojaroupas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class SistemaLojaRoupasPOOTest {
    @Test
    public void testaCadastroDeRoupa(){
        SistemaLojaRoupasPOO sistema = new SistemaLojaRoupasPOO();
        try{
            sistema.cadastraRoupa("001", "Camisa polo Azul Masculina", Tamanho.M ,10);
            Roupa r = sistema.pesquisaRoupa("001");
            assertEquals(10, r.getQuantidade());
            sistema.cadastraRoupa("002","Camisa vermelha feminina", Tamanho.M, 2);
            assertEquals(2, sistema.pesquisaRoupasComDescricaoComecandoCom("Camisa").size());
            sistema.alteraQuantidadeDeRoupaNoEstoque("001", "9");
            assertEquals(9,sistema.pesquisaRoupa("001").getQuantidade());
        } catch (RoupaJaExisteException | RoupaInexistenteException e){
            fail("Nâo deveria lançar exceção");
        }
    }
}
