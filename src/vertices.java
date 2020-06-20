

//public class vertices implements Comparable<vertices> {
	public class vertices  {
		
	private String nome;
    private double distancia_aresta;
    private vertices pai;
    private String color = "white";
    
    
	public vertices getPai() {
		return pai;
	}

	public void setPai(vertices pai) {
		this.pai = pai;
	}

	public double getDistancia_aresta() {
		return distancia_aresta;
	}

	public void setDistancia_aresta(double distancia_aresta) {
		this.distancia_aresta = distancia_aresta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
//	@Override
//	public int compareTo(vertices o) {
//		if (this.getDistancia_aresta() > o.getDistancia_aresta()) {
//			return -1;
//		} else if (this.getDistancia_aresta() < o.getDistancia_aresta()) {
//			return 1;
//		}
//		return 0;
//	}
}