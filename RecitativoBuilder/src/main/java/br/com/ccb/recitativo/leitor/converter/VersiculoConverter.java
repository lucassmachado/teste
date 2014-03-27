package br.com.ccb.recitativo.leitor.converter;

import br.com.ccb.recitativo.modelo.Versiculo;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class VersiculoConverter implements Converter {

	@Override
	public boolean canConvert(Class type) {
		return type.equals(Versiculo.class);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		Versiculo versiculo = (Versiculo) source;
		writer.setValue(versiculo.getTexto());
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		Versiculo versiculo = new Versiculo();
		versiculo.setTexto(reader.getValue());
		return versiculo;
	}
}