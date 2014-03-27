package br.com.ccb.recitativo.modelo.search;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.ccb.recitativo.modelo.Biblia;
import br.com.ccb.recitativo.modelo.factory.BibliaFactory;

public class BibliaSearchTest {

	private Biblia biblia = BibliaFactory.getInstance();

	@Test
	public void buscarTextoBiblicoComInterfaceFluente() {
		String verso = "O Senhor é o meu pastor; nada me faltará.";

		String versoObtido = new BibliaSearch(biblia)
						.livro("Salmos")
						.capitulo(23)
						.verso(1)
						.buscar();

		assertEquals(verso, versoObtido);
	}

	@Test(expected = IllegalArgumentException.class)
	public void buscarTextoBiblicoNaoExistente() {
		new BibliaSearch(biblia)
			.livro("Salmos")
			.capitulo(0)
			.verso(0)
			.buscar();

	}

	@Test
	public void salmos150Verso6() {
		String verso = "Tudo quanto tem fôlego louve ao Senhor. Louvai ao Senhor!";

		String versoObtido = new BibliaSearch(biblia)
						.livro("Salmos")
						.capitulo(150)
						.verso(6)
						.buscar();

		assertEquals(verso, versoObtido);
	}

	@Test(expected = NullPointerException.class)
	public void faltaDoArgumentoLivro() {
		String verso = "Tudo quanto tem fôlego louve ao Senhor. Louvai ao Senhor!";

		String versoObtido = new BibliaSearch(biblia)
						.capitulo(150)
						.verso(6)
						.buscar();

		assertEquals(verso, versoObtido);
	}

	@Test(expected = IllegalStateException.class)
	public void faltaDoArgumentoVerso() {
		new BibliaSearch(biblia)
			.livro("Salmos")
			.capitulo(150)
			.buscar();
	}

	@Test(expected = IllegalStateException.class)
	public void faltaDoArgumentoCapitulo() {
		new BibliaSearch(biblia)
			.livro("Salmos")
			.verso(6)
			.buscar();
	}

}
