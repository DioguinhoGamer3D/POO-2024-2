package br.ufpb.dcx.diogo.SistemaVendas;

public class Venda {
    private String codigoProduto;
    private double valorProduto;
    private int anoVenda;
    private Mes mesVenda;

    public Venda(String codigoProduto, double valorProduto, Mes mesVenda, int anoVenda ){
        this.codigoProduto =  codigoProduto;
        this.valorProduto = valorProduto;
        this.anoVenda = anoVenda;
        this.mesVenda = mesVenda;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public int getAnoVenda() {
        return anoVenda;
    }

    public void setAnoVenda(int anoVenda) {
        this.anoVenda = anoVenda;
    }

    public Mes getMesVenda() {
        return mesVenda;
    }

    public void setMesVenda(Mes mesVenda) {
        this.mesVenda = mesVenda;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "codigoProduto='" + codigoProduto + '\'' +
                ", valorProduto=" + valorProduto +
                ", anoVenda=" + anoVenda +
                ", mesVenda=" + mesVenda +
                '}';
    }
}
