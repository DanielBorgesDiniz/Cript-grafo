package business;

import domain.CriptObject;

public class Criptografia_Cesar {

	static char[] alfabeto = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public static int[] localizarLetras(CriptObject co) {

		char[] aux = co.getMensagem().toCharArray();
		int[] cood = new int[co.getMensagem().length()];

		int x = 0;
		for (int i = 0; i < co.getMensagem().length(); i++) {
			if (aux[i] == ' ') {
				x = 27;
			} else {
				for (int j = 0; j < alfabeto.length; j++) {
					if (alfabeto[j] == aux[i]) {
						x = j;
					}
				}
			}
			cood[i] = x;

		}

		return cood;
	}

	public static int[] movimentarLetras(CriptObject co) {

		int[] cood = localizarLetras(co);

		int valorMovimento = Integer.parseInt(co.getCHAVE());
		int[] cod = new int[co.getMensagem().length()];

		int aux2;
		for (int i = 0; i < cood.length; i++) {
			if (cood[i] == 27) {
				aux2 = 27;
			} else {
				aux2 = cood[i] + valorMovimento;

				if (aux2 > 25) {
					int aux3 = 26 - cood[i];
					aux2 = valorMovimento - aux3;
				} else if (aux2 < 0) {
					int aux3 = 26 + cood[i];
					aux2 = valorMovimento + aux3;
				}
			}

			cod[i] = aux2;

		}

		return cod;
	}

	public static void gerarCodigo(CriptObject co) {
		int[] cod = movimentarLetras(co);

		System.out.print("Sua codificação: ");

		for (int i = 0; i < cod.length; i++) {
			if (cod[i] == 27) {
				System.out.print(' ');
			} else {
				System.out.print(alfabeto[cod[i]]);
			}
		}

	}

}
