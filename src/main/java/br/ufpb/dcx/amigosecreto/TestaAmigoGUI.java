package br.ufpb.dcx.amigosecreto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestaAmigoGUI {
    public static void main(String[] args) throws AmigoJaExisteException, AmigoInexistenteException, AmigoNaoSorteadoException {
        SistemaAmigo sistema = new SistemaAmigo();
        Scanner leitor = new Scanner(System.in);
        System.out.println("Quantos amigos vão participar?");
        int quantAmigos = leitor.nextInt();
        leitor.nextLine();
        for (int k = 0; k < quantAmigos; k++) {
            System.out.println("Digite o nome do amigo: ");
            String nome = leitor.nextLine();
            System.out.println("Digite o email do amigo: ");
            String email = leitor.nextLine();
            sistema.cadastraAmigo(nome, email);
        }
        List<String> resultadoSorteio = sistema.sortear();
        for (String resultado : resultadoSorteio) {
            System.out.println(resultado);
        }
        System.out.println("Digite a mensagem: ");
        String texto = leitor.nextLine();
        System.out.println("Quem é o remetente da mensagem?(email)");
        String emailRemetente = leitor.nextLine();
        System.out.println("É anônimo?(true/false)");
        boolean ehAnonima = leitor.nextBoolean();
        sistema.enviarMensagemParaTodos(texto,emailRemetente,ehAnonima);
    }
}