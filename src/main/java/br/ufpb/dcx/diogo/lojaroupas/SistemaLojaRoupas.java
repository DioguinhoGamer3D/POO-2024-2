package br.ufpb.dcx.diogo.lojaroupas;

import java.util.List;

public interface SistemaLojaRoupas {
    public List<Roupa> pesquisaRoupasPorTamanho(Tamanho tamanhoRoupa);

    public List<Roupa> pesquisaRoupasPorTamanho(String prefixoDescricao);

    public Tamanho consultaTamanhoDaRoupa(String codigoRoupa) throws RoupaInexistenteException;

    public void cadastraRoupa(String codigoRoupa, String descricao, Tamanho tamanho, int quantidade) throws RoupaJaExisteException;

    public void alteraquantidadeDeRoupaNoEstoque(String codigoRoupa) throws RoupaInexistenteException;

    public Roupa pesquisa(String codgioRoupa) throws RoupaInexistenteException;
}
