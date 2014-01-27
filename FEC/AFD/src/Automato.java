import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;


public class Automato {
	
//	private final int MAX_VERTS = 20;
//	private Estado listaEstados[];
//	private String adjMat[][];
//	private int nEstados;
//	private String sortedArray[];
	//private ArrayList<Transicao> transicoes;
	private Estado estadoAtual;
	private ArrayList<Estado> estados;
	private static int contador;
	private boolean estadoInicialExiste = false;
	private ArrayList<String> alfabeto;
	
	public Automato(){
		estados = new ArrayList<>();
		//transicoes = new ArrayList<>();
//		listaEstados = new Estado[MAX_VERTS];
//		adjMat = new String[MAX_VERTS][MAX_VERTS];
//		nEstados = 0;
//		for (int i = 0; i < MAX_VERTS; i++) {
//			for (int j = 0; j < MAX_VERTS; j++) {
//				adjMat[i][j] = ""+-1;
//			}
//		}
	}
	
	public boolean addEstado(boolean estadoInicial, boolean estadoFinal){
		
		boolean aceitou = false;
		if(estadoInicialExiste==false && estadoInicial==true){
				estados.add(new Estado("q"+(contador++), estadoInicial, estadoFinal));
				estadoInicialExiste = true;
				aceitou = true;
		}else{
			if(estadoInicial==true && estadoInicialExiste==true){
				aceitou = false;
			}else{
				estados.add(new Estado("q"+(contador++), estadoInicial, estadoFinal));
				aceitou = true;
			}
		}
		return aceitou;
	}
	 
	
	public void addTransicao(Estado origem, Estado destino, String simbolo){
		Transicao transicao = new Transicao(origem, destino, simbolo);
		origem.adicionarTransicao(transicao);
		if(!alfabeto.contains(simbolo)){
			alfabeto.add(simbolo);
		}
	}
	
	public void funcaoTransicao(ArrayList<Estado> estados, String entrada){
		int contador = 1;
		for (Estado estado : estados) {
			if(estado.isEstadoInicial()==true){
				estadoAtual = estado;
				break;
			}
		}
		for(int i = 0; i < entrada.length(); i++){
			contador++;
			if(verificarTransicao(estadoAtual, ""+entrada.charAt(i)) == false){
				break;
			}
		}
		
		if(contador >= estados.size() && verificarAceitacao(estadoAtual)){
			Display.mensagem(true);
		}else{
			Display.mensagem(false);
		}
		
	}
	
	public boolean verificarTransicao(Estado estado, String simbolo){
		boolean passou = false;
		 Iterator<Transicao> iterator = estado.getTransicoes().iterator();
		 while(iterator.hasNext()){
			 Transicao transicao = iterator.next();
			 if(transicao.getSimbolo().equals(simbolo)){
				 estadoAtual = transicao.getDestino();
				 passou = true;
			 }
		 }
		return passou;
	}
	
	public boolean verificarAceitacao(Estado estado){
		boolean aceita = false;
		if(estado.isEstadoFinal()){
			aceita = true;
		}
		return aceita;
	}
	
	

}
