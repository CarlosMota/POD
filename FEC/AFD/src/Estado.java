import java.util.ArrayList;
import java.util.HashSet;


public class Estado {
	
	private String label;
	private boolean estadoInicial;
	private boolean estadoFinal;
	private boolean estadoAtual;
	private HashSet<Transicao> transicoes;
	
	public Estado(String label, boolean estadoInicial, boolean estadoFinal) {
		this.transicoes = new HashSet<>();
		this.label = label;
		this.estadoInicial = estadoInicial;
		this.estadoFinal = estadoFinal;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isEstadoInicial() {
		return estadoInicial;
	}

	public void setEstadoInicial(boolean estadoInicial) {
		this.estadoInicial = estadoInicial;
	}

	public boolean isEstadoFinal() {
		return estadoFinal;
	}

	public void setEstadoFinal(boolean estadoFinal) {
		this.estadoFinal = estadoFinal;
	}

	public boolean isEstadoAtual() {
		return estadoAtual;
	}

	public void setEstadoAtual(boolean estadoAtual) {
		this.estadoAtual = estadoAtual;
	}
	

	public HashSet<Transicao> getTransicoes() {
		return transicoes;
	}

	public void adicionarTransicao(Transicao transicao){
		this.transicoes.add(transicao);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
}
