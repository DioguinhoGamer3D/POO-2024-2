package br.ufpb.dcx.diogo.amigosecreto;

public class AmigoInexistenteException extends Exception {
    public AmigoInexistenteException(String msg){
        super(msg);
    }
    public AmigoInexistenteException(){
        super();
    }
}
