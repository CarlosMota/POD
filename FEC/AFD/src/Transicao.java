
public class Transicao {
	
	//Desenvolvido por Carlos Alberto Mota da Silva Filho")
	//"Versão: 1.0"
	//"github:CarlosMota"
	
	private Estado origem,destino;
	private String simbolo;
	
	public Transicao(Estado origem, Estado destino, String simbolo){
		this.origem = origem;
		this.destino = destino;
		this.simbolo = simbolo;
	}


	public Estado getOrigem() {
		return origem;
	}
	public void setOrigem(Estado origem) {
		this.origem = origem;
	}
	public Estado getDestino() {
		return destino;
	}
	public void setDestino(Estado destino) {
		this.destino = destino;
	}
	public String getSimbolo() {
		return simbolo;
	}
	public void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((origem == null) ? 0 : origem.hashCode());
		result = prime * result + ((simbolo == null) ? 0 : simbolo.hashCode());
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
		Transicao other = (Transicao) obj;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (origem == null) {
			if (other.origem != null)
				return false;
		} else if (!origem.equals(other.origem))
			return false;
		if (simbolo == null) {
			if (other.simbolo != null)
				return false;
		} else if (!simbolo.equals(other.simbolo))
			return false;
		return true;
	}
	
}
