package br.com.ccb.recitativo.modelo;

import java.util.List;

public interface Biblia {

	List<Livro> getLivros();

	List<Capitulo> getCapitulos(String livro);

	int getTotalDeLivros();
}