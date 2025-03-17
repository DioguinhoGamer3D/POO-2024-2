package br.ufpb.dcx.diogo.SistemaVendas;

import java.util.Collection;

public interface SistemaVendas {
    void cadastrarVenda(String codigoPedido, double valorProduto, Mes mes, int ano) throws ProdutoNaoExisteException;
    void cadastrarProduto(String codigo, String descricao);
    Collection<Venda> pesquisarTodasAsVendas();
    Collection<Produto> pesquisarTodosOsProdutos();
    double obterValorTotalVendasMes(Mes mes, int ano);
    boolean existeVendaDoProduto(String codigoProduto);
    int contaVendaSDoProduto(String codigoProduto);
    boolean existeProduto(String codigo);
    String pesquisaDescricaoDoProduto(String codidigoProduto);
}
