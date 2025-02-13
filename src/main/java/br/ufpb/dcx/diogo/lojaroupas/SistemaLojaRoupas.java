package br.ufpb.dcx.diogo.lojaroupas;

import java.util.List;

public interface SistemaLojaRoupas {
    public List<Roupa> pesquisaRoupasComDescricaoComecandoCom(Tamanho tamanhoRoupa);

    public List<Roupa> pesquisaRoupasComDescricaoComecandoCom(String prefixoDescricao);

    public Tamanho consultaTamanhoDaRoupa(String codigoRoupa) throws RoupaInexistenteException;

    public void cadastraRoupa(String codigoRoupa, String descricao, Tamanho tamanho, int quantidade) throws RoupaJaExisteException;

    public void alteraquantidadeDeRoupaNoEstoque(String codigoRoupa, String novaQuantidade) throws RoupaInexistenteException;

    public Roupa pesquisa(String codgioRoupa) throws RoupaInexistenteException;
}
