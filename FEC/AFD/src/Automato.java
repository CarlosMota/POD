import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

//Desenvolvido por Carlos Alberto Mota da Silva Filho")
//"Versão: 1.0"
//"github:CarlosMota"


public class Automato {
	

	private Estado estadoAtual;
	private ArrayList<Estado> estados;
	private static int contador;
	private boolean estadoInicialExiste = false;
	private ArrayList<String> alfabeto;
	
	public Automato(){
		estados = new ArrayList<>();
		alfabeto = new ArrayList<>();
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
		int cont = 0;
		for (Estado estado : estados) {
			if(estado.isEstadoInicial()==true){
				estadoAtual = estado;
				break;
			}
		}
		for(int i = 0; i < entrada.length(); i++){
			cont++;
			if(verificarTransicao(estadoAtual, ""+entrada.charAt(i)) == false){
				break;
			}
		}
		
		if(cont == entrada.length() && verificarAceitacao(estadoAtual)){
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
	
	public Estado procuraEstado(String label){
		Estado estado = null;
		for (Estado est : estados) {
			if(est.getLabel().equals(label)){
				estado = est;
			}
		}
		return estado;
	}
	public Estado getEstadoAtual() {
		return estadoAtual;
	}

	public ArrayList<Estado> getEstados() {
		return estados;
	}

	public boolean isEstadoInicialExiste() {
		return estadoInicialExiste;
	}

	public ArrayList<String> getAlfabeto() {
		return alfabeto;
	}
	
	

}
