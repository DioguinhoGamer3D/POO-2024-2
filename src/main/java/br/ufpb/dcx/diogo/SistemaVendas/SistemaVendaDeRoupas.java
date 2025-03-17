package br.ufpb.dcx.diogo.SistemaVendas;

import java.util.*;

public class SistemaVendaDeRoupas implements SistemaVendas{
    private Map<String, Produto> produtos;
    private List<Venda> vendas;

    public SistemaVendaDeRoupas(){
        this.produtos = new HashMap<>();
        this.vendas = new ArrayList<>();
    }

    @Override
    public void cadastrarVenda(String codigoProduto, double valorProduto, Mes mes, int ano)
            throws ProdutoNaoExisteException {
        if (existeProduto(codigoProduto)){
            Venda venda = new Venda(codigoProduto, valorProduto,
                    mes, ano);
            this.vendas.add(venda);
        } else {
            throw new ProdutoNaoExisteException("Não existe produto com "+
                    "o código " + codigoProduto);
        }
    }

    @Override
    public void cadastrarProduto(String codigo, String descricao) {

    }

    @Override
    public Collection<Venda> pesquisarTodasAsVendas() {
        return List.of();
    }

    @Override
    public Collection<Produto> pesquisarTodosOsProdutos() {
        return List.of();
    }

    @Override
    public double obterValorTotalVendasMes(Mes mes, int ano) {
        return 0;
    }

    @Override
    public boolean existeVendaDoProduto(String codigoProduto) {
        return false;
    }

    @Override
    public int contaVendaSDoProduto(String codigoProduto) {
        return 0;
    }

    @Override
    public boolean existeProduto(String codigo) {
        return false;
    }

    @Override
    public String pesquisaDescricaoDoProduto(String codidigoProduto) {
        return "";
    }
}
