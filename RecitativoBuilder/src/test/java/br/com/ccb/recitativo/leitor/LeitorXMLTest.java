package br.com.ccb.recitativo.leitor;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

import br.com.ccb.recitativo.modelo.Biblia;
import br.com.ccb.recitativo.modelo.factory.BibliaFactory;

public class LeitorXMLTest {

	private static Biblia biblia = BibliaFactory.getInstance();

	@Test
	public void quantidadeLivros() throws IOException {
		biblia = new LeitorXML().getBiblia();
		
		assertEquals(66, biblia.getLivros().size());
	}

	@Test
	public void primeiroLivroGenesis() throws IOException {
		biblia = new LeitorXML().getBiblia();

		assertEquals("Gênesis", biblia.getLivros().get(0).getNome());
	}
}
