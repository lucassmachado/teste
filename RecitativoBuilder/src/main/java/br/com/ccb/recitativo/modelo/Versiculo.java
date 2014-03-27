package br.com.ccb.recitativo.modelo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("versiculo")
public class Versiculo {

	@XStreamAsAttribute
	private Integer numero;

	private String texto;

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Integer getNumero() {
		return numero;
	}

	@Override
	public int hashCode() {
		int hash = 7 * 31;
		hash = hash + numero.hashCode();
		hash = hash + texto.hashCode();
		return hash;
	}

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Versiculo)) {
			return false;
		}

		Versiculo other = (Versiculo) o;
		return numero.equals(other.numero) && texto.equals(other.texto);
	}

	@Override
	public String toString() {
		return "Versiculo [numero=" + numero + ", versiculo=" + texto + "]";
	}
}