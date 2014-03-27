package br.com.ccb.recitativo.modelo.factory;

import java.io.IOException;

import br.com.ccb.recitativo.leitor.LeitorXML;
import br.com.ccb.recitativo.modelo.Biblia;

public final class BibliaFactory {

	private static Biblia instance = null;

	private BibliaFactory() {}

	public static Biblia getInstance() {
		if (instance == null) {
			try {
				instance = new LeitorXML().getBiblia();
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}

		return instance;
	}
}