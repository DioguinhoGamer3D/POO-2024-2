package br.ufpb.dcx.amigosecreto;

public class AmigoNaoSorteadoException extends Exception{
    public AmigoNaoSorteadoException(String msg){
        super(msg);
    }
    public AmigoNaoSorteadoException(){
        super();
    }
}
