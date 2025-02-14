package br.ufpb.dcx.diogo.lojaroupas;

import java.util.List;

public interface SistemaLojaRoupas {
    public List<Roupa> pesquisaRoupasPorTamanho(Tamanho tamanhoRoupa);

    public List<Roupa> pesquisaRoupasComDescricaoComecandoCom(String prefixoDescricao);

    public Tamanho consultaTamanhoDaRoupa(String codigoRoupa) throws RoupaInexistenteException;

    public void cadastraRoupa(String codigoRoupa, String descricao, Tamanho tamanho, int quantidade) throws RoupaJaExisteException;

    public void alteraQuantidadeDeRoupaNoEstoque(String codigoRoupa, String novaQuantidade) throws RoupaInexistenteException;

    public Roupa pesquisaRoupa(String codgioRoupa) throws RoupaInexistenteException;
}
