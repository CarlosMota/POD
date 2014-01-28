import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;

//Desenvolvido por Carlos Alberto Mota da Silva Filho
//"Versão: 1.0"
//"github:CarlosMota"

public class Display {
	
	
	public static void mostrarMenuPrincipal(){
		System.out.println("------------------------------------------------------");
		System.out.println("Desenvolvido por Carlos Alberto Mota da Silva Filho");
		System.out.println("Versão: 1.0");
		System.out.println("github:CarlosMota");
		System.out.println("------------------------------------------------------");
		System.out.println("Menu Automato Finito");
		System.out.println("Informe a Opção desejada:");
		System.out.println("0 - Adicionar Estados:");
		System.out.println("1 - Adicionar Transicão:");
		System.out.println("2 - Imprimir AFD");
		System.out.println("3 - Entrar com um string");
		System.out.println("4 - Sair");
		
	}
	
	public static void menuAdicionarEstado(Automato automato){
		Scanner entrada = new Scanner(System.in);
		int escolhaMenu = -1;
		while(escolhaMenu!=4){
			System.out.println("------------------------------------------------------");
			System.out.println("Menu adicionar Estado");
			System.out.println("Informe o opção desejada");
			System.out.println("0 - Estado Inicial");
			System.out.println("1 - Estado Final");
			System.out.println("2 - Estado inicial e final");
			System.out.println("3 - Estado normal");
			System.out.println("4 - voltar");
			escolhaMenu = entrada.nextInt();
			switch (escolhaMenu) {
			case 0:
				automato.addEstado(true, false);
				imprimirEstados(automato);
				break;
			case 1:
				automato.addEstado(false, true);
				imprimirEstados(automato);
				break;
			case 2:
				automato.addEstado(true, true);
				imprimirEstados(automato);
				break;
			case 3:
				automato.addEstado(false, false);
				imprimirEstados(automato);
				break;
			case 4:
				System.out.println("Voltando");
				break;
			}
		}
		Menu(automato);
	}
	
	public static void imprimirEstados(Automato automato){
		if(automato.getEstados()!=null){
			for (Estado estado : automato.getEstados()) {
				System.out.println(estado.getLabel());
			}
		}
	}
	
	public static void imprimirTransicoes(Automato automato){
		int contador = 1;
		for(int i = 0; i < automato.getEstados().size(); i++){
			java.util.Iterator<Transicao> iterator = automato.getEstados().get(i).getTransicoes().iterator();
			while(iterator.hasNext()){
				Transicao transicao = iterator.next();
				System.out.println("transição: "+(contador++));
				System.out.println("Função de trnasição: ("+transicao.getOrigem().getLabel()+" "+transicao.getSimbolo()+" "+transicao.getDestino().getLabel()+")");
			}
		}
	}
	
	public static void menuAdicionarTransicao(Automato automato){
		Scanner entrada = new Scanner(System.in);
		System.out.println("------------------------------------------------------");
		System.out.println("Menu adicionar Transição");
		System.out.println("Estados:");
		int escolha = -1;
		while(escolha != 0)
		{
			imprimirEstados(automato);
			System.out.println("");
			System.out.println("Informe o estado de origem");
			Estado estadoOrigem = automato.procuraEstado(entrada.nextLine());
			if(estadoOrigem==null){
				estadoOrigem = automato.procuraEstado(entrada.nextLine());
			}
			System.out.println("Informe o Simbolo");
			String simbolo = entrada.nextLine();
			System.out.println("Informe o estado de destino");
			Estado estadoFinal = automato.procuraEstado(entrada.nextLine());
			System.out.println("Função de trnasição: ("+estadoOrigem.getLabel()+" "+simbolo+" "+estadoFinal.getLabel()+")");
			if(estadoOrigem!=null&&estadoFinal!=null){
				automato.addTransicao(estadoOrigem, estadoFinal, simbolo);
			}else{
				System.out.println("Erro: Voce digitou um estado que nao existe");
				Menu(automato);
			}
			System.out.println("Deseja adicionar nova transição");
			System.out.println("0 - para voltar ao menu principal");
			System.out.println("1 - para Continuar");
			escolha = entrada.nextInt();
		}
		Menu(automato);
		
	}
	
	public static void menuImprimirAFD(Automato automato){
		System.out.println("------------------------------------------------------");
		System.out.println("AFD");
		System.out.println("Estados:");
		imprimirEstados(automato);
		System.out.println("------------------------------------------------------");
		System.out.println("Alfabeto:");
		for(String alfa: automato.getAlfabeto()){
			System.out.println(alfa);
		}
		System.out.println("------------------------------------------------------");
		System.out.println("Transições:");
		imprimirTransicoes(automato);
		System.out.println("------------------------------------------------------");
		System.out.println("Estado Inicial:");
		for (Estado estado3 : automato.getEstados()) {
			if(estado3.isEstadoInicial()){
				System.out.println(estado3.getLabel());
			}
		}
		System.out.println("------------------------------------------------------");
		System.out.println("Estado Final:");
		for (Estado estado4 : automato.getEstados()) {
			if(estado4.isEstadoFinal()){
				System.out.println(estado4.getLabel());
			}
		}
		
		Menu(automato);
		
	}
	
	public static void menuEntrada(Automato automato){
		Scanner entrada = new Scanner(System.in);
		System.out.println("------------------------------------------------------");
		System.out.println("Informe a sua entrada:");
		String string = entrada.nextLine();
		automato.funcaoTransicao(automato.getEstados(), string);
	}
	
	public static void mensagem(boolean aceita){
		if(aceita){
			System.out.println("A entrada foi aceita com sucesso");
		}else{
			System.out.println("A entrada não foi aceita");
		}
	}
	
	public static void Menu(Automato automato){
		Scanner entrada = new Scanner(System.in);
		int escolhaMenu = -1;
		while(escolhaMenu!=4){
			Display.mostrarMenuPrincipal();
			escolhaMenu = entrada.nextInt();
			switch (escolhaMenu) {
			case 0:
				menuAdicionarEstado(automato);
				break;
			case 1:
				menuAdicionarTransicao(automato);
				break;
			case 2:
				menuImprimirAFD(automato);
				break;
			case 3:
				menuEntrada(automato);
			case 4:
				System.out.println("Saindo...");
				break;
			}
		}
		return;
	}
}
