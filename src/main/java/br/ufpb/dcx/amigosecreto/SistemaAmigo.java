package br.ufpb.dcx.amigosecreto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SistemaAmigo{

	private List<Mensagem> mensagens= new ArrayList<>();

	private List<Amigo> amigos = new ArrayList<>();

	public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
		for(Amigo a: amigos) {
			if ((a.getEmail().equals(emailAmigo))) {
				throw new AmigoJaExisteException("Amigo com o email: " + emailAmigo + " já existe.");
			}
		}
		Amigo a = new Amigo(nomeAmigo, emailAmigo);
		amigos.add(a);
	}

	public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
		for (Amigo a : amigos) {
			if (a.getEmail().equals(emailAmigo)) {
				return a;
			}
		}
		throw new AmigoInexistenteException("Amigo com email:" + emailAmigo + "não existe.");
	}

	public void enviarMensagemParaTodos(String texto, String emailremetente, boolean ehAnonima) {
		Mensagem m = new MensagemParaTodos(texto, emailremetente, ehAnonima);
		this.mensagens.add(m);
	}

	public void enviarMensagemParaAlguem(String texto, String emaiRemetente, String emailDestinatario, boolean ehAnonima) {
		Mensagem m = new MensagemParaAlguem(texto, emaiRemetente, emailDestinatario, ehAnonima);
		this.mensagens.add(m);
	}

	public List<Mensagem> pesquisaMensagensAnonimas() {
		List<Mensagem> anonimas = new ArrayList<>();
		for (Mensagem m : mensagens) {
			if (m.ehAnonima()) {
				anonimas.add(m);
			}
		}
		return anonimas;
	}

	public List<Mensagem> pesquisaTodasAsMensagens() {
		return mensagens;
	}

	public void configuraAmigoSecretoDe(String emailDaPessoa, String emailSorteado) throws AmigoInexistenteException {
		pesquisaAmigo(emailDaPessoa).setAmigoSorteado(emailSorteado);
	}

	public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
		for (Amigo a : amigos) {
			if (Objects.equals(a.getEmail(), emailDaPessoa)) {
				return a.getEmailAmigoSorteado();
			}
			else if(a.getEmailAmigoSorteado()==null){
				throw new AmigoNaoSorteadoException("Amigo não foi sorteado");
			}
		}
        throw new AmigoInexistenteException();
    }
	public List<String> sortear(){
		List<String> resultado = new ArrayList<>();
		if (amigos.size() < 2) {
			System.out.println("Não há amigos suficientes para realizar o sorteio.");
			return resultado;
		}
		List<Amigo> amigosRestantes = new ArrayList<>(amigos);
		for (Amigo amigo : amigos) {
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