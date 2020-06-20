import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class aplicação_do_grafo {

	boolean orientado = false;
	boolean valorado = false;

	ArrayList<vertices> vertices = new ArrayList<vertices>();
	ArrayList<arestas> arestas = new ArrayList<arestas>();

	public boolean Valorado() {
		String val = JOptionPane.showInputDialog("Valorado? S/N");
		if (val.equalsIgnoreCase("S")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean Orientado() {
		String ori = JOptionPane.showInputDialog("Orientado? S/N");
		if (ori.equalsIgnoreCase("S")) {
			return true;
		} else {
			return false;
		}
	}

	public void addvertices() {
		String mostrar = "";
		String continua = "S";
		do {

			String vertice = JOptionPane.showInputDialog("Vértices:" + "\n" + mostrar + "\n" + "Informe o vertice");
			vertices v = new vertices();
			v.setNome(vertice);
			vertices.add(v);

			mostrar = "";
			for (vertices m : vertices) {
				mostrar += m.getNome() + " - ";
			}

			continua = JOptionPane.showInputDialog("Continuar? S/N");
		} while (continua.equalsIgnoreCase("S"));
	}

	public void addarestas() {
		String mostrar = "";
		String continua = "S";

		valorado = Valorado();
		orientado = Orientado();

		do {
			arestas a = new arestas();
			String seta = " - ";
			String aresta1 = JOptionPane
					.showInputDialog("Arestas:" + "\n" + mostrar + "\n" + "Vertice de SAIDA da arestas");
			a.setSaida(saida);
			String aresta2 = JOptionPane
					.showInputDialog("Arestas:" + "\n" + mostrar + "\n" + "Vertice de CHEGADA da aresta");
			a.setChegada(aresta2);
			if (orientado == true) {
				a.setOrientado(true);
				seta = " --> ";
			}
			if (valorado == true) {
				a.setValorado(true);
				a.setValor(Double.parseDouble(
						JOptionPane.showInputDialog("VALOR da Aresta " + aresta1 + seta + aresta2 + ": ")));
			}

			arestas.add(a);

			mostrar = "";
			for (arestas v : arestas) {
				mostrar += v.getSaida() + seta + v.getChegada() + "  //  ";
			}

			continua = JOptionPane.showInputDialog("Continuar? S/N");
		} while (continua.equalsIgnoreCase("S"));

	}

	public void mostrarGrafos() {
		//////// lista de arestas////////
		System.out.println("---- Lista de Arestas: ----");
		System.out.println("");

		for (arestas ar : arestas) {
			if (valorado) {
				System.out.println(ar.getSaida() + " - " + ar.getChegada() + " - V: " + ar.getValor());
			} else {
				System.out.println(ar.getSaida() + " - " + ar.getChegada());
			}
		}

		String vetorVertices[] = new String[vertices.size()];
		String matrizArestas[][] = new String[vertices.size()][vertices.size()];

		for (int i = 0; i < vertices.size(); i++) {
			vetorVertices[i] = vertices.get(i).getNome();

		}
		if (orientado == false) { // coloquei false pq bugou
			// System.out.println("");
			//////// matriz de adjcacência orientada////////
			// System.out.println("---- Matriz de Adjacência: ----");

			int c1 = 0;
			for (int i = 0; i < vetorVertices.length; i++) {
				if (c1 == 0) {
					// System.out.print(" " + "|" + vetorVertices[i] + "|");
					c1++;
				} else {
					// System.out.print("|" + vetorVertices[i] + "|");
				}

			}
			for (int i = 0; i < vetorVertices.length; i++) {
				// System.out.print("\n" + "|" + vetorVertices[i] + "|");
				for (int j = 0; j < vetorVertices.length; j++) {
					matrizArestas[i][j] = " 0 ";
					for (arestas ar : arestas) {

						if (ar.getSaida().equals(vertices.get(i).getNome())
								&& ar.getChegada().equals(vertices.get(j).getNome())
								|| ar.getSaida().equals(vertices.get(j).getNome())
										&& ar.getChegada().equals(vertices.get(i).getNome())) {
							if (ar.isValorado()) {
								matrizArestas[i][j] = ar.getValor().toString();
							} else {
								matrizArestas[i][j] = " 1 ";
							}
						} else {
							// matrizArestas[i][j] = "0";
						}

					}
					// System.out.print(matrizArestas[i][j]);

				}
			}

		} else {
			//////// matriz de adjcacência////////
			System.out.println("");
			System.out.println("---- Matriz de Adjacência: ----");
			System.out.println("");
			int c1 = 0;
			for (int i = 0; i < vetorVertices.length; i++) {
				if (c1 == 0) {
					// System.out.print(" " + "|" + vetorVertices[i] + "|");
					c1++;
				} else {
					// System.out.print("|" + vetorVertices[i] + "|");
				}

			}
			for (int i = 0; i < vetorVertices.length; i++) {
				// System.out.print("\n" + "|" + vetorVertices[i] + "|");
				for (int j = 0; j < vetorVertices.length; j++) {
					matrizArestas[i][j] = " 0 ";
					for (arestas ar : arestas) {

						if (ar.getSaida().equals(vertices.get(i).getNome())
								&& ar.getChegada().equals(vertices.get(j).getNome())) {

							if (ar.isValorado()) {
								matrizArestas[i][j] = ar.getValor().toString();
							} else {
								matrizArestas[i][j] = " 1 ";
							}
						} else {

						}

					}
					// System.out.print(matrizArestas[i][j]);

				}
			}

		}
		//////// lista de adjcacência////////
		// System.out.println("");
		String vetorAdjacencia[][] = new String[vetorVertices.length][arestas.size()];
		// System.out.println("\n ---- Lista de Adjacência: ----");

		if (orientado) {
			for (int i = 0; i < vetorVertices.length; i++) {
				// System.out.print("\n" + "(" + vetorVertices[i] + ")");
				int j = 0;
				for (arestas ar : arestas) {

					if (vetorVertices[i].equalsIgnoreCase(ar.getSaida())) {
						// System.out.print(" -> " + ar.getChegada());
//						j++;
//						vetorAdjacencia[i][j] = ar.getChegada();
//						System.out.print(" v* "+vetorAdjacencia[i][j]);
					}
				}

			}

		} else {

			for (int i = 0; i < vetorVertices.length; i++) {
				// System.out.print("\n" + "|" + vetorVertices[i] + "|");
				for (arestas ar : arestas) {

					if (vetorVertices[i].equalsIgnoreCase(ar.getSaida())) {
						// System.out.print(" -> " + ar.getChegada());

					} else if (vetorVertices[i].equalsIgnoreCase(ar.getChegada())) {
						// System.out.print(" -> " + ar.getSaida());
					}

				}
			}
		}

		//////// matriz de incidência orientada////////
		String vetorVertices2[] = new String[vertices.size()];
		String matrizArestas2[][] = new String[vertices.size()][arestas.size()];

		for (int i = 0; i < vertices.size(); i++) {
			vetorVertices2[i] = vertices.get(i).getNome();

		}
		if (orientado) {
			// System.out.println("");
			// System.out.println("\n ---- Matriz de Incidência: ----");
			// System.out.println("");
			int c1 = 0;
			if (valorado) {
				for (int i = 0; i < arestas.size(); i++) {
					if (c1 == 0) {
						// System.out.print(" " + "|" + arestas.get(i).getValor() + "|");
						c1++;
					} else {
						// System.out.print("|" + arestas.get(i).getValor() + "|");
					}

				}
			} else {
				for (int i = 0; i < arestas.size(); i++) {
					if (c1 == 0) {
						// System.out.print(
						// " " + "|" + arestas.get(i).getSaida() + "-" + arestas.get(i).getChegada() +
						// "|");
						c1++;
					} else {
						// System.out.print("|" + arestas.get(i).getSaida() + "-" +
						// arestas.get(i).getChegada() + "|");
					}

				}
			}
			for (int i = 0; i < vetorVertices2.length; i++) {
				System.out.print("\n" + "|" + vetorVertices2[i] + "|");
				for (int j = 0; j < arestas.size(); j++) {
					matrizArestas2[i][j] = "  0  ";

					if (arestas.get(j).getSaida().equalsIgnoreCase(vertices.get(i).getNome())) {

						matrizArestas2[i][j] = "  1  ";

					} else if (arestas.get(j).getChegada().equalsIgnoreCase(vertices.get(i).getNome())) {
						matrizArestas2[i][j] = "  -1  ";
					} else {

						matrizArestas2[i][j] = "  0  ";
					}

					// System.out.print(matrizArestas2[i][j]);

				}
			}

		} else {
			//////// matriz de incidência////////
			// System.out.println("");
			// System.out.println("\n ---- Matriz de Incidência: ----");
			// System.out.println("");
			int c1 = 0;

			for (int i = 0; i < arestas.size(); i++) {
				if (c1 == 0) {
					// System.out.print(" " + "|" + arestas.get(i).getSaida() + "-" +
					// arestas.get(i).getChegada() + "|");
					c1++;
				} else {
					// System.out.print("|" + arestas.get(i).getSaida() + "-" +
					// arestas.get(i).getChegada() + "|");
				}

			}

			for (int i = 0; i < vetorVertices2.length; i++) {
				// System.out.print("\n" + "|" + vetorVertices2[i] + "|");

				for (int j = 0; j < arestas.size(); j++) {

					matrizArestas2[i][j] = "  0  ";

					if (arestas.get(j).getSaida().equalsIgnoreCase(vertices.get(i).getNome())
							|| arestas.get(j).getChegada().equalsIgnoreCase(vertices.get(i).getNome())) {

						matrizArestas2[i][j] = "  1  ";

					} else if (arestas.get(j).getSaida().equalsIgnoreCase(vertices.get(i).getNome())
							&& arestas.get(j).getChegada().equalsIgnoreCase(vertices.get(i).getNome())) {
						matrizArestas2[i][j] = "  2  ";
					} else {

						matrizArestas2[i][j] = "  0  ";

					}
					// System.out.print(matrizArestas2[i][j]);

				}
			}

		}

	}

	ArrayList<arestas> arestasCrescente = new ArrayList<arestas>();
	ArrayList<arestas> arvoreGeradora = new ArrayList<arestas>();

	public void preencheCrescente() {

		for (arestas a : arestas) {
			arestasCrescente.add(a);
		}

		Collections.sort(arestasCrescente);
		System.out.println("\n Arestas em Ordem \n");
		for (arestas ac : arestasCrescente) {
			System.out.println(ac.getValor());
		}

	}
    
	arestas[][] conjunto;
	vertices ciclo[] = new vertices[vertices.size()+1]; 
	
	public void Kruskal() {
		
	for (arestas a : arestasCrescente) {
		if (a.getSaida().getNome() != a.getChegada().getNome()) {
			
		}
	}
		
	}
	
	public void unir(vertices v1, vertices v2) {
		
	}
	
	public vertices pai(vertices x) {
		
		return x;
	}
	
	public void criaConjunto(arestas a) {
	conjunto[0][0] = a;	
	}
	
	public void iniciaVetorDeCiclos() {
		for (vertices v : ciclo) {
			v.setPai(v);
		}
	}
	

	public void preencheGrafo() {
		addvertices();
		addarestas();
	}

}
