package br.com.ccb.recitativo.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Recitativo {

	private String livro;

	private int capitulo;

	private int versiculo;

	private Calendar dataRecitativo;

	private String auxiliar;

	private String textoBiblico;

	public String getLivro() {
		return livro;
	}

	public void setLivro(String livro) {
		this.livro = livro;
	}

	public int getCapitulo() {
		return capitulo;
	}

	public void setCapitulo(int capitulo) {
		this.capitulo = capitulo;
	}

	public int getVersiculo() {
		return versiculo;
	}

	public void setVersiculo(int versiculo) {
		this.versiculo = versiculo;
	}

	public Calendar getDataRecitativo() {
		return dataRecitativo;
	}

	public void setDataRecitativo(Calendar dataRecitativo) {
		this.dataRecitativo = dataRecitativo;
	}

	public String getAuxiliar() {
		return auxiliar;
	}

	public void setAuxiliar(String auxiliar) {
		this.auxiliar = auxiliar;
	}

	public String getTextoBiblico() {
		return textoBiblico;
	}

	public void setTextoBiblico(String textoBiblico) {
		this.textoBiblico = textoBiblico;
	}

	@Override
	public String toString() {
		StringBuilder recitativo = new StringBuilder();
		recitativo.append("\t\tCONGREGAÇÃO CRISTÃ NO BRASIL\t\t");
		recitativo.append("\nNOME:_____________________________");
		recitativo.append("\nLIVRO: ");
		recitativo.append(livro);
		recitativo.append("\nCAPÍTULO: ");
		recitativo.append(capitulo);
		recitativo.append("\tVERSOS: ");
		recitativo.append(versiculo);
		recitativo.append("\nRECITATIVO PARA O DIA: ");
		recitativo.append(formatarData(dataRecitativo));
		recitativo.append("\nAUXILIAR: ");
		recitativo.append(auxiliar);
		recitativo.append("\nTEXTO: ");
		recitativo.append(textoBiblico);
		return recitativo.toString();
	}

	private String formatarData(Calendar data) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(data.getTime());
	}
}