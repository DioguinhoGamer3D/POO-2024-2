package br.ufpb.dcx.amigosecreto;

public class AmigoJaExisteException extends Exception{
    public AmigoJaExisteException(String msg){
        super(msg);
    }
    public AmigoJaExisteException(){
        super();
    }
}
