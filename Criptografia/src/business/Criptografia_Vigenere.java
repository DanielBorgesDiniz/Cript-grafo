package business;

import domain.CriptObject;

public class Criptografia_Vigenere {

	static char[] alfabeto = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public static char[][] montarTabela() {

		char[][] cripto = new char[27][27];

		int contador1 = 0, contador2 = 0;

		for (int i = 1; i < cripto.length; i++) {
			contador1 = contador2;

			for (int j = 1; j <= cripto.length - 1; j++) {
				if (contador1 == alfabeto.length) {
					contador1 = 0;
				}

				// System.out.print(alfabeto[contador1]);
				cripto[i][j] = alfabeto[contador1];
				contador1++;
			}
			contador2++;

		}

		// imprimir(cripto);

		return cripto;
	}

	public static void criptografar(CriptObject co) {

		char[][] cripto = montarTabela();

		char[] aux = co.getMensagem().toCharArray();
		char[] aux2 = co.getCHAVE().toCharArray();
		int[] coox = new int[co.getMensagem().length()];
		int[] cooy = new int[co.getMensagem().length()];
		int x = 0, y = 0;

		for (int i = 0; i < aux.length; i++) {
			if (aux[i] == ' ') {
				x = 27;
			} else {
				for (int j = 0; j < alfabeto.length; j++) {
					if (alfabeto[j] == aux[i]) {
						x = j + 1;
					}
				}
			}
			coox[i] = x;
		}

		int a = 0;
		for (int i = 0; i < aux.length; i++) {

			if (i > 0) {
				if (aux[i - 1] == ' ') {
					a = 0;
				}
			}

			if (a >= aux2.length) {
				a = 0;
			}

			for (int j = 0; j < alfabeto.length; j++) {
				if (alfabeto[j] == aux2[a]) {
					y = j + 1;
				}
			}
			cooy[i] = y;
			a++;
		}

		System.out.print("Sua codificação: ");

		for (int i = 0; i < co.getMensagem().length(); i++) {
			if (coox[i] == 27) {
				System.out.print(' ');
			} else {
				System.out.print(cripto[coox[i]][cooy[i]]);
			}
		}

	}

//Metodo usado para imprimir a tabela cripto e verificar irregularidades nela

	private static void imprimir(char[][] aux) {
		for (int i = 0; i < aux.length; i++) {
			for (int j = 0; j < aux.length; j++) {
				System.out.print(aux[i][j]);

			}
			System.out.println("");
		}
	}

}