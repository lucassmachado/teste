package br.com.ccb.recitativo.leitor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import br.com.ccb.recitativo.leitor.converter.VersiculoConverter;
import br.com.ccb.recitativo.modelo.Biblia;
import br.com.ccb.recitativo.modelo.impl.BibliaXml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class LeitorXML {

	public Biblia getBiblia() throws IOException {
		XStream stream = new XStream(new DomDriver());
		stream.processAnnotations(BibliaXml.class);
		stream.autodetectAnnotations(true);
		stream.registerConverter(new VersiculoConverter());
		return (Biblia) stream.fromXML(obterArquivo());
	}

	private InputStream obterArquivo() throws IOException {
		return new FileInputStream(obterCaminhoArquivo());
	}

	private String obterCaminhoArquivo() {
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ServletContext sc = (ServletContext) ec.getContext();
		return sc.getRealPath("/bibliaXml/Almeida Recebida 1.3.xml");
	}
}