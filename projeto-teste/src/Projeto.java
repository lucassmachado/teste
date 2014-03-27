public class Projeto {

	private final String nome;
	
	private final String descricao;
	private String atividades;

	public Projeto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getAtividades() {
		return atividades;
	}

	public void setAtividades(String atividades) {
		this.atividades = atividades;
	}
}
