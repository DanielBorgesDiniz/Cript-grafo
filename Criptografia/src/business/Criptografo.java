package business;

import domain.CriptObject;

public class Criptografo {

	public static void ramificarCriptografia(CriptObject co) {

		switch (co.getCtg()) {
		case VINEGERE:

			Criptografia_Vigenere.criptografar(co);

			break;

		case CESAR:

			Criptografia_Cesar.gerarCodigo(co);

			break;

		case LATINO:

			Criptografia_Alfalatino.codificarMensagem(co);

			break;

		default:
			break;

		}

	}

}
