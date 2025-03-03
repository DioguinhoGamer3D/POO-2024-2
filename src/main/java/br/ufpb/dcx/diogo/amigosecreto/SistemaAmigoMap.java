package br.ufpb.dcx.diogo.amigosecreto;

import java.util.*;

public class SistemaAmigoMap {

    private Map<String, Mensagem> mensagensMap;
    private Map<String, Amigo> amigoMap;

    public SistemaAmigoMap(){
        this.mensagensMap = new HashMap<>();
        this.amigoMap = new HashMap<>();
    }

    public void cadastraAmigoMap(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException{
        if(amigoMap.containsKey(emailAmigo)){
            throw new AmigoJaExisteException("Esse email já está cadastrado!");
        } else {
            Amigo amigo = new Amigo(nomeAmigo,emailAmigo);
            this.amigoMap.put(emailAmigo,amigo);
        }
    }
    public Amigo pesquisaAmigoMap(String emailAmigo) throws AmigoInexistenteException{
        if (amigoMap.containsKey(emailAmigo)){
            for(Amigo a: amigoMap.values()){
                return a;
            }
        }
        throw new AmigoInexistenteException("Não existe amigo com esse email"+ emailAmigo);
    }
    public void enviarMensagemParaTodosMap(String texto, String emailremetente, boolean ehAnonima) {
        Mensagem m = new MensagemParaTodos(texto, emailremetente, ehAnonima);
        mensagensMap.put(emailremetente,m);
    }
    public void enviarMensagemParaAlguemMap(String texto, String emaiRemetente, String emailDestinatario, boolean ehAnonima) {
        Mensagem m = new MensagemParaAlguem(texto, emaiRemetente, emailDestinatario, ehAnonima);
        mensagensMap.put(emailDestinatario, m);
    }
    public List<Mensagem> pesquisaMensagensAnonimasMap() {
        List<Mensagem> mensagem = new ArrayList<>();
        if(mensagensMap.containsKey(null)){
            for(Mensagem m:mensagensMap.values()){
                mensagem.add(m);
            }
        } return mensagem;
    }
    public List<Mensagem> pesquisaTodasAsMensagensMap() {
        List<Mensagem> mensagem = new ArrayList<>(mensagensMap.values());
        return mensagem;
    }
    public void configuraAmigoSecretoDeMap(String emailDaPessoa, String emailSorteado) throws AmigoInexistenteException {
        pesquisaAmigoMap(emailDaPessoa).setAmigoSorteado(emailSorteado);
    }
    public String pesquisaAmigoSecretoDeMap(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        if (amigoMap.containsKey(emailDaPessoa)){
            for( Amigo a: amigoMap.values()){
                return a.getEmailAmigoSorteado();
            }
        }
        throw new AmigoInexistenteException();
    }
    public List<String> sortearMap(){
        List<String> resultado = new ArrayList<>();
        if (amigoMap.size() < 2) {
            System.out.println("Não há amigos suficientes para realizar o sorteio.");
            return resultado;
        }
        List<Amigo> amigosRestantes = new ArrayList<>(amigoMap.values());
        for (Amigo amigo : amigoMap.values()) {
            Amigo sorteado = null;
            while (sorteado == null || sorteado == amigo) {
                int index = (int) (Math.random() * amigosRestantes.size());
                sorteado = amigosRestantes.get(index);
            }
            resultado.add(amigo.getNome() + " pegou " + sorteado.getNome());
            amigosRestantes.remove(sorteado);
        }
        return resultado;
    }
}
