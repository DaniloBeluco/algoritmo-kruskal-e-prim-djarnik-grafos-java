

public class arestas implements Comparable<arestas> {
		
	private vertices saida;
	private vertices chegada;
	private Double valor;
	private boolean valorado = false;
	private boolean orientado = false;
	
	public void setSaida(vertices saida) {
		this.saida = saida;
	}
	public void setChegada(vertices chegada) {
		this.chegada = chegada;
	}
	public boolean isOrientado() {
		return orientado;
	}
	public void setOrientado(boolean orientado) {
		this.orientado = orientado;
	}
	public boolean isValorado() {
		return valorado;
	}
	public void setValorado(boolean valorado) {
		this.valorado = valorado;
	}
	
	
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	@Override
	public int compareTo(arestas o) {
		if (this.getValor() > o.getValor()) {
			return 1;
		} else if (this.getValor() < o.getValor()) {
			return -1;
		}
		return 0;
	}
	
	
}
	
