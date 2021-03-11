package domain;

import enums.Criptografias;

public class CriptObject {
	private String mensagem;
	private String CHAVE;
	private Criptografias ctg;

	public CriptObject(String mensagem, String CHAVE, Criptografias ctg) {
		this.mensagem = mensagem;
		this.CHAVE = CHAVE;
		this.ctg = ctg;
	}

	public Criptografias getCtg() {
		return ctg;
	}

	public String getMensagem() {
		return mensagem;
	}
	
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getCHAVE() {
		return CHAVE;
	}

}
