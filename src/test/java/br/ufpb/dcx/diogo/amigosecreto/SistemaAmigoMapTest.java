package br.ufpb.dcx.diogo.amigosecreto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaAmigoMapTest {

    SistemaAmigoMap sistema;

    @BeforeEach
    void setUp()  {
        this.sistema = new SistemaAmigoMap();
    }

    @Test
    void testSistemaAmigo() {
        assertTrue(sistema.pesquisaTodasAsMensagensMap().isEmpty());
        assertThrows(AmigoInexistenteException.class,
                ()-> sistema.pesquisaAmigoMap("ayla@teste.com"));
    }

    @Test
    void testPesquisaECadastraAmigo() {
        try {
            sistema.pesquisaAmigoMap("ayla@teste.com");
            fail("Deveria falhar pois não existe ainda");
        } catch (AmigoInexistenteException e) {
            //Ok
        }
        try {
            sistema.cadastraAmigoMap("ayla", "ayla@teste.com");
            Amigo a = sistema.pesquisaAmigoMap("ayla@teste.com");
            assertEquals("ayla", a.getNome());
            assertEquals("ayla@teste.com", a.getEmail());
        } catch (AmigoJaExisteException | AmigoInexistenteException  e) {
            fail("Não deveria lançar exceção");
        }


    }

    @Test
    void testEnviarMensagemParaTodos() {
        assertTrue(sistema.pesquisaTodasAsMensagensMap().isEmpty());
        sistema.enviarMensagemParaTodosMap("texto", "ayla@dcx.ufpb.br", true);
        List<Mensagem> mensagensAchadas = sistema.pesquisaTodasAsMensagensMap();
        assertTrue(mensagensAchadas.size()==1);
        assertTrue(mensagensAchadas.get(0).getEmailRemetente().equals("ayla@dcx.ufpb.br"));
    }

    @Test
    void testEnviarMensagemParaAlguem() {
        assertTrue(sistema.pesquisaTodasAsMensagensMap().isEmpty());
        sistema.enviarMensagemParaAlguemMap("texto", "ayla@dcx.ufpb.br", "rodrigo@dcx.ufpb.br", true);
        List<Mensagem> mensagensAchadas = sistema.pesquisaTodasAsMensagensMap();
        assertEquals(1, mensagensAchadas.size());
        assertTrue(mensagensAchadas.get(0) instanceof MensagemParaAlguem);
        assertTrue(mensagensAchadas.get(0).getTexto().equals("texto"));
    }

    @Test
    void testPesquisaMensagensAnonimas() {
        assertTrue(sistema.pesquisaTodasAsMensagensMap().isEmpty());
        sistema.enviarMensagemParaAlguemMap("texto 1", "ayla@dcx.ufpb.br", "rodrigo@dcx.ufpb.br", false);
        assertTrue(sistema.pesquisaMensagensAnonimasMap().isEmpty());
        sistema.enviarMensagemParaAlguemMap("texto 2", "ayla@dcx.ufpb.br", "rodrigo@dcx.ufpb.br", true);
        assertTrue(sistema.pesquisaMensagensAnonimasMap().size()==1);
    }

    @Test
    void testPesquisaTodasAsMensagens() {
        assertTrue(sistema.pesquisaTodasAsMensagensMap().isEmpty());
        sistema.enviarMensagemParaAlguemMap("texto 1", "ayla@dcx.ufpb.br", "rodrigor@dcx.ufpb.br", false);
        assertTrue(sistema.pesquisaTodasAsMensagensMap().size()==1);
        sistema.enviarMensagemParaAlguemMap("texto 2", "ayla@dcx.ufpb.br", "rodrigor@dcx.ufpb.br", true);
        assertTrue(sistema.pesquisaTodasAsMensagensMap().size()==2);
    }

    @Test
    void testPesquisaAmigoEConfiguraAmigoSecretoDe() {
        assertThrows(AmigoInexistenteException.class,
                ()-> sistema.pesquisaAmigoSecretoDeMap("ayla@dcx.ufpb.br"));
        try {
            sistema.cadastraAmigoMap("Ayla", "ayla@dcx.ufpb.br");
            sistema.cadastraAmigoMap("Ana", "ana@dcx.ufpb.br");
            sistema.configuraAmigoSecretoDeMap("ayla@dcx.ufpb.br", "ana@dcx.ufpb.br");
            sistema.configuraAmigoSecretoDeMap("ana@dcx.ufpb.br", "ayla@dcx.ufpb.br");
            assertEquals("ana@dcx.ufpb.br", sistema.pesquisaAmigoSecretoDeMap("ayla@dcx.ufpb.br"));
            assertEquals("ayla@dcx.ufpb.br", sistema.pesquisaAmigoSecretoDeMap("ana@dcx.ufpb.br"));
        } catch (AmigoInexistenteException | AmigoJaExisteException | AmigoNaoSorteadoException e) {
            fail("Não deveria lançar exceção");
        }
    }
}
