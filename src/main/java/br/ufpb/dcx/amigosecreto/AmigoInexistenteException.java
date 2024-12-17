package br.ufpb.dcx.amigosecreto;

public class AmigoInexistenteException extends Exception {
    public AmigoInexistenteException(String msg){
        super(msg);
    }
    public AmigoInexistenteException(){
        super();
    }
}
