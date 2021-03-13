package tui;

import java.util.Scanner;

import business.Criptografo;
import domain.CriptObject;
import enums.Criptografias;

public class Interface {

	public static void main(String[] args) {
		iniciarMenu();
	}

	public static void iniciarMenu() {
		final String CHAVE;
		CriptObject co;
		Scanner ler = new Scanner(System.in);
		System.out.println("\nEscolha o tipo de criptografia desejado:" + "\n1 - Cifra de Vinegere"
				+ "\n2 - Cifra de Cesar" + "\n3 - Cifra AlfaLatina");
		String escolha = ler.nextLine().toLowerCase();

		// futuramente novos tipos de criptografia serão aceitos

		switch (escolha) {

		case "1":
		case "vigenere":

			System.out.print("Digite a palavra chave: ");
			CHAVE = ler.nextLine().toLowerCase();
			co = new CriptObject("", CHAVE, Criptografias.VINEGERE);
			inserirMensagem(co);

			break;

		case "2":
		case "cesar":

			System.out.println("Digite um numero de -25 a 25");
			CHAVE = ler.nextLine().toLowerCase();
			co = new CriptObject("", CHAVE, Criptografias.CESAR);
			inserirMensagem(co);

			break;

		case "3":
		case "alfalatina":

			co = new CriptObject("", null, Criptografias.LATINO);
			inserirMensagem(co);

		default:

			System.out.println("Não é possivel concluir esse comando");
			iniciarMenu();

			break;
		}

	}

	public static void inserirMensagem(CriptObject co) {
		Scanner ler = new Scanner(System.in);
		boolean fim = false;

		while (fim == false) {
			System.out.print("Digite aqui a sua mensagem: ");
			String mensagem = ler.nextLine().toLowerCase();
			co.setMensagem(mensagem);

			Criptografo.ramificarCriptografia(co);

			System.out.println("\n\nDeseja terminar a codificação?" + "\n1 - sim" + "\n2 - não");
			String decisão = ler.nextLine().toLowerCase();

			switch (decisão) {
			case "1":
			case "sim":
				fim = true;
				break;
			case "2":
			case "não":
				fim = false;
				break;
			default:
				System.out.println("Não é possivel concluir esse comando");
				break;

			}

		}

		iniciarMenu();

	}

}
