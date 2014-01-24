
public class Ingresso {

	private String numIdentificacao;
	private Evento evento;
	private Secao secao;

	
	public Ingresso(String numIdentificacao, Evento evento, Secao secao){
		this.numIdentificacao = numIdentificacao;
		this.evento = evento;
		this.secao = secao;
	}
	
	public String getNumIdentificacao() {
		return numIdentificacao;
	}
	
	public void setNumIdentificacao(String numIdentificacao) {
		this.numIdentificacao = numIdentificacao;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public Secao getSecao() {
		return secao;
	}

	public void setSecao(Secao secao) {
		this.secao = secao;
	}
}
