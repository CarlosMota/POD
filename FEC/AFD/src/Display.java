import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;


public class Display {
	
	
	public static void mostrarMenuPrincipal(){
		System.out.println("------------------------------------------------------");
		System.out.println("Menu Automato Finito");
		System.out.println("Informe a Opção desejada:");
		System.out.println("0 - Adicionar Estados:");
		System.out.println("1 - Adicionar Transicão:");
		System.out.println("2 - Imprimir AFD");
		System.out.println("3 - Entrar com um string");
		System.out.println("4 - Sair");
		
	}
	
	public static void menuAdicionarEstado(){
		System.out.println("------------------------------------------------------");
		System.out.println("Menu adicionar Estado");
		System.out.println("Informe o opção desejada");
		System.out.println("0 - Estado Inicial");
		System.out.println("1 - Estado Final");
		System.out.println("2 - Estado inicial e final");
		System.out.println("3 - Estado normal");
		System.out.println("4 - voltar");
		
	}
	
	public static void menuAdicionarTransicao(String estado, ArrayList<Estado> estados){
		System.out.println("------------------------------------------------------");
		System.out.println("Menu adicionar Transição");
		System.out.println("Estados:");
		for (Estado estado2 : estados) {
			System.out.println(estado2.getLabel());
		}
		System.out.println("DIGITE 0 PARA VOLTAR");
		if(estado.equals("origem")){
			System.out.println("Informe o estado de origem");
		}else if(estado.equals("destino")){
			System.out.println("Informe o estado de destino");
		}
		
	}
	
	public static void menuImprimirAFD(ArrayList<Estado> estados, ArrayList<String> alfabeto){
		System.out.println("------------------------------------------------------");
		System.out.println("AFD");
		System.out.println("Estados:");
		for (Estado estado2 : estados) {
			System.out.println(estado2.getLabel());
		}
		System.out.println("------------------------------------------------------");
		System.out.println("Alfabeto:");
		for(String alfa: alfabeto){
			System.out.println(alfa);
		}
		System.out.println("------------------------------------------------------");
		System.out.println("Transições:");
		int contador = 1;
		for(int i = 0 ; i < estados.size(); i++){
			java.util.Iterator<Transicao> iterator = estados.get(i).getTransicoes().iterator();
			while(iterator.hasNext()){
				Transicao transicao = (Transicao) iterator.next();
				System.out.println("transição: "+(contador++));
				System.out.println(transicao.getOrigem().getLabel()+" "+transicao.getSimbolo()+" "+transicao.getDestino().getLabel());
			}
		}
		System.out.println("------------------------------------------------------");
		System.out.println("Estado Inicial:");
		for (Estado estado3 : estados) {
			if(estado3.isEstadoInicial()){
				System.out.println(estado3.getLabel());
			}
		}
		System.out.println("------------------------------------------------------");
		System.out.println("Estado Final:");
		for (Estado estado4 : estados) {
			if(estado4.isEstadoFinal()){
				System.out.println(estado4.getLabel());
			}
		}
		
	}
	
	public static void menuEntrada(){
		System.out.println("------------------------------------------------------");
		System.out.println("Informe a sua string:");
	}
	
	public static void mensagem(boolean aceita){
		if(aceita){
			System.out.println("A entrada foi aceita com sucesso");
		}else{
			System.out.println("A entrada não foi aceita");
		}
	}
	
	public void Menu(Automato automato){
		Scanner entrada = new Scanner(System.in);
		int escolhaMenu = -1;
		while(escolhaMenu!=4){
			Display.mostrarMenuPrincipal();
			escolhaMenu = entrada.nextInt();
			switch (escolhaMenu) {
			case 0:
				
				break;

			default:
				break;
			}
		}
	}
}
