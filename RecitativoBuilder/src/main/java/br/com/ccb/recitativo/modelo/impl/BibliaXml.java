package br.com.ccb.recitativo.modelo.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.ccb.recitativo.modelo.Biblia;
import br.com.ccb.recitativo.modelo.Capitulo;
import br.com.ccb.recitativo.modelo.Livro;
import br.com.ccb.recitativo.modelo.Versiculo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("biblia")
public class BibliaXml implements Biblia {

	@XStreamImplicit(itemFieldName = "livro")
	private List<Livro> livros;

	public List<Livro> getLivros() {
		return livros;
	}

	private Map<String, List<Capitulo>> getLivrosMap() {
		Map<String, List<Capitulo>> livrosMap = new HashMap<String, List<Capitulo>>();

		for (Livro livro : livros) {
			livrosMap.put(livro.getNome(), livro.getCapitulos());
		}

		return livrosMap;
	}

	public List<Capitulo> getCapitulos(String livro) {
		Map<String, List<Capitulo>> livrosMap = getLivrosMap();

		if (!livrosMap.containsKey(livro)) {
			throw new IllegalArgumentException("Livro inexistente!");
		}

		return livrosMap.get(livro);
	}

	public int getTotalDeLivros() {
		return livros.size();
	}

	@Override
	public int hashCode() {
		return 7 * 31 * livros.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof BibliaXml)) {
			return false;
		}

		return livros.equals(((BibliaXml) o).livros);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (Livro livro : livros) {
			builder.append("\n");
			builder.append(livro);
			builder.append(" - ");

			for (Capitulo capitulo : livro.getCapitulos()) {
				builder.append(capitulo);

				for (Versiculo versiculo : capitulo.getVersiculos()) {
					builder.append(" ");
					builder.append(versiculo.getNumero());
					builder.append(" ");
					builder.append(versiculo.getTexto());
					builder.append(" ");
				}
			}
		}

		return builder.toString();
	}
}