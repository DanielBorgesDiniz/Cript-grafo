package business;

import domain.CriptObject;

public class Criptografia_Alfalatino {

	static char[] alfabeto = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r',
			's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };

	public static void codificarMensagem(CriptObject co) {

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

		for (int i = 0; i < cood.length; i++) {
			if (cood[i] == 27) {

			} else {
				System.out.print((cood[i] + 1) + " ");
			}
		}

	}
}
