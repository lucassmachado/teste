package br.com.ccb.recitativo.modelo;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("livro")
public class Livro {

	@XStreamAsAttribute
	private String nome;

	@XStreamImplicit(itemFieldName = "capitulo")
	private List<Capitulo> capitulos;

	public List<Capitulo> getCapitulos() {
		return capitulos;
	}

	public String getNome() {
		return nome;
	}

	public int getTotalDeCapitulos() {
		return capitulos.size();
	}

	@Override
	public int hashCode() {
		return 7 * 31 * nome.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Livro)) {
			return false;
		}

		return ((Livro) o).nome.equals(nome);
	}

	@Override
	public String toString() {
		return nome;
	}
}