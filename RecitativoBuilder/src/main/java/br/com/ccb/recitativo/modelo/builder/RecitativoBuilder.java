package br.com.ccb.recitativo.modelo.builder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.ccb.recitativo.modelo.Recitativo;
import br.com.ccb.recitativo.modelo.search.BibliaSearch;

public class RecitativoBuilder {

	private final BibliaSearch bibliaSearch;

	private String livro;

	private int capitulo;

	private int versoInicial;

	private Calendar data;

	private String auxiliar;

	private int versoFinal;

	public RecitativoBuilder(BibliaSearch bibliaSearch) {
		this.bibliaSearch = bibliaSearch;
	}

	public RecitativoBuilder livro(String livro) {
		this.livro = livro;
		return this;
	}

	public RecitativoBuilder capitulo(int capitulo) {
		this.capitulo = capitulo;
		return this;
	}

	public RecitativoBuilder doVerso(int versoInicial) {
		this.versoInicial = versoInicial;
		return this;
	}

	public RecitativoBuilder aoVerso(int versoFinal) {
		this.versoFinal = versoFinal;
		return this;
	}

	public RecitativoBuilder paraData(Calendar data) {
		this.data = data;
		return this;
	}

	public RecitativoBuilder auxiliar(String auxiliar) {
		this.auxiliar = auxiliar;
		return this;
	}

	public List<Recitativo> construir() {
		return preencherRecitativos();
	}

	private List<Recitativo> preencherRecitativos() {
		List<Recitativo> recitativos = new ArrayList<Recitativo>();

		for (int verso = versoInicial; verso <= versoFinal; verso++) {
			recitativos.add(construirRecitativo(verso, buscarTextoBiblico(verso)));
		}

		return recitativos;
	}

	private String buscarTextoBiblico(int verso) {
		return bibliaSearch.livro(livro)
				.capitulo(capitulo)
				.verso(verso)
				.buscar();
	}

	private Recitativo construirRecitativo(int verso, String textoBiblico) {
		Recitativo recitativo = new Recitativo();
		recitativo.setLivro(livro);
		recitativo.setCapitulo(capitulo);
		recitativo.setVersiculo(verso);
		recitativo.setDataRecitativo(data);
		recitativo.setAuxiliar(auxiliar);
		recitativo.setTextoBiblico(textoBiblico);
		return recitativo;
	}
}