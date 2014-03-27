package br.com.ccb.recitativo.modelo;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("capitulo")
public class Capitulo {

	@XStreamAsAttribute
	private Integer numero;

	@XStreamImplicit(itemFieldName = "versiculo")
	private List<Versiculo> versiculos;

	public Integer getNumero() {
		return numero;
	}

	public List<Versiculo> getVersiculos() {
		return versiculos;
	}

	public int getTotalDeVersiculos() {
		return versiculos.size();
	}

	@Override
	public int hashCode() {
		return 7 * 31 * numero.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Capitulo)) {
			return false;
		}

		return numero.equals(((Capitulo) o).numero);
	}

	@Override
	public String toString() {
		return Integer.toString(numero);
	}
}