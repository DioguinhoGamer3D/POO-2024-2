package br.ufpb.dcx.amigosecreto;

import java.util.Objects;

public class TestaSistemaAmigo {
    public static void main(String[] args) throws AmigoJaExisteException, AmigoNaoSorteadoException, AmigoInexistenteException {
        SistemaAmigo sistema = new SistemaAmigo();
        sistema.cadastraAmigo("José","jose@gmail.com");
        sistema.cadastraAmigo("Maria","maria@gmail.com");
        try{
            sistema.configuraAmigoSecretoDe("jose@gmail.com","maria@gmail.com");
            sistema.configuraAmigoSecretoDe("maria@gmail.com","jose@gmail.com");
        } catch (AmigoInexistenteException e){
            System.out.println("Amigo não existe.");
        }
        sistema.enviarMensagemParaAlguem("Oii","maria@gmail.com","jose@gmail.com",true);
        sistema.enviarMensagemParaTodos("Oiii","maria@gmail.com",true);
        for(Mensagem m: sistema.pesquisaTodasAsMensagens()){
            if(m.ehAnonima()){
                System.out.println(m.getTextoCompletoAExibir());
            }
        }try{
            if(Objects.equals(sistema.pesquisaAmigoSecretoDe("jose@gmail.com"), "maria@gmail.com")) {
                System.out.println("Ok");
            }
        } catch (AmigoInexistenteException e){
            System.out.println("Amigo não existe.");
        } catch (AmigoNaoSorteadoException e ){
            System.out.println("Amigo não foi sorteado.");
        }
    }
}
