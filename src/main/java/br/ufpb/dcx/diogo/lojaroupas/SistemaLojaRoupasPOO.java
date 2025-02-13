package br.ufpb.dcx.diogo.lojaroupas;

import java.util.List;

public class SistemaLojaRoupasPOO implements SistemaLojaRoupas{

    @Override
    public List<Roupa> pesquisaRoupasPorTamanho(Tamanho tamanhoRoupa) {
        return null;
    }

    @Override
    public List<Roupa> pesquisaRoupasPorTamanho(String prefixoDescricao) {
        return null;
    }

    @Override
    public Tamanho consultaTamanhoDaRoupa(String codigoRoupa) throws RoupaInexistenteException {
        return null;
    }

    @Override
    public void cadastraRoupa(String codigoRoupa, String descricao, Tamanho tamanho, int quantidade) throws RoupaJaExisteException {

    }

    @Override
    public void alteraquantidadeDeRoupaNoEstoque(String codigoRoupa) throws RoupaInexistenteException {

    }

    @Override
    public Roupa pesquisa(String codigoRoupa) throws RoupaInexistenteException {
        return null;
    }
}
