package br.com.ccb.recitativo.modelo.builder;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Test;

import br.com.ccb.recitativo.modelo.Biblia;
import br.com.ccb.recitativo.modelo.Recitativo;
import br.com.ccb.recitativo.modelo.factory.BibliaFactory;
import br.com.ccb.recitativo.modelo.search.BibliaSearch;

public class RecitativoBuilderTest {

	private Biblia biblia = BibliaFactory.getInstance();

	@Test
	public void contrucaoDoObjetoRecitativoBuilder() {
		List<Recitativo> recitativos = new RecitativoBuilder(new BibliaSearch(biblia))
											.livro("Apocalipse")
											.capitulo(3)
											.doVerso(7)
											.aoVerso(19)
											.paraData(new GregorianCalendar(16, Calendar.FEBRUARY, 2014))
											.auxiliar("Lucas")
											.construir();

		assertEquals("Lucas", recitativos.get(0).getAuxiliar());
		assertEquals("Apocalipse", recitativos.get(0).getLivro());
	}
}