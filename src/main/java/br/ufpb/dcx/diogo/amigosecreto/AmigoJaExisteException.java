package br.ufpb.dcx.diogo.amigosecreto;

public class AmigoJaExisteException extends Exception{
    public AmigoJaExisteException(String msg){
        super(msg);
    }
    public AmigoJaExisteException(){
        super();
    }
}
