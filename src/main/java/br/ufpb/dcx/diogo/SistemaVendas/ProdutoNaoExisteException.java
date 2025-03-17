package br.ufpb.dcx.diogo.SistemaVendas;

public class ProdutoNaoExisteException extends RuntimeException {
    public ProdutoNaoExisteException(String message) {
        super(message);
    }
}
