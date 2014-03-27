package br.com.ccb.recitativo.modelo.search;

import java.util.List;

import br.com.ccb.recitativo.modelo.Biblia;
import br.com.ccb.recitativo.modelo.Capitulo;

public class BibliaSearch {

	private final Biblia biblia;

	private List<Capitulo> capitulos;

	private int capitulo;

	private int verso;

	private int argumentosPreenchidos = 0;

	public BibliaSearch(Biblia biblia) {
		if (biblia == null) {
			throw new NullPointerException("Argumento biblia null: " + biblia);
		}

		this.biblia = biblia;
	}

	public BibliaSearch livro(String livro) {
		if (livro == null || livro.trim().equals("")) {
			throw new IllegalArgumentException("Livro inexistente: " + livro);
		}

		this.capitulos = biblia.getCapitulos(livro);
		this.argumentosPreenchidos++;
		return this;
	}

	public BibliaSearch capitulo(int capitulo) {
		if (capitulo < 1 || capitulo > capitulos.size()) {
			throw new IllegalArgumentException("Capítulo inexistente: " + capitulo);
		}

		this.capitulo = capitulo;
		this.capitulo--;
		this.argumentosPreenchidos++;
		return this;
	}

	public BibliaSearch verso(int verso) {
		if (verso < 1 || verso > capitulos.get(capitulo).getTotalDeVersiculos()) {
			throw new IllegalArgumentException("Versículo inexistente: " + verso);
		}

		this.verso = verso;
		this.verso--;
		this.argumentosPreenchidos++;
		return this;
	}

	public String buscar() {
		if (this.argumentosPreenchidos < 3) {
			throw new IllegalStateException("Falta argumentos para preenhcer!");
		}

		return capitulos.get(capitulo).getVersiculos().get(verso).getTexto();
	}
}