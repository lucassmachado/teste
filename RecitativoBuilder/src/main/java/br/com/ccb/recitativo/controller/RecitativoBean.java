package br.com.ccb.recitativo.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.ccb.recitativo.modelo.Livro;
import br.com.ccb.recitativo.modelo.factory.BibliaFactory;

@ManagedBean
@SessionScoped
public class RecitativoBean {

	private List<Livro> livros = null;

	@PostConstruct
	public void iniciar() {
		livros = BibliaFactory.getInstance().getLivros();
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
}