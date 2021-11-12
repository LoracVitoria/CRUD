import java.util.Scanner;

public class Locadora {

	public static void main(String[] args) {
		Locadora loc = new Locadora();
		loc.menuPrincipal();
	}
	
	public void menuPrincipal(){
		int opcao = -1;
		Scanner scanner = new Scanner(System.in);
		while(opcao != 0){
			System.out.println("\n--------------------------------------------------------------");
			System.out.println("MENU PRINCIPAL");
			System.out.println("[1] Gerenciar Veiculos");
			System.out.println("[2] Gerenciar Clientes");
			System.out.println("[0] Sair");
			System.out.println("--------------------------------------------------------------\n");
			try{
				opcao = Integer.parseInt(scanner.nextLine());		
			} catch (Exception e) {
				System.out.println("Erro! \n Informe um número inteiro");
			}
			
			if(opcao == 1){
				GerenciadorVeiculo gVeiculo = new GerenciadorVeiculo();
				gVeiculo.menu();
			}else if(opcao == 2){
				System.out.println("Gerenciar clientes...");
			}else if(opcao == 0){
				System.out.println("Até logo!");
			}else{
				System.out.println("Opção inválida!");
			}
		}
		
	}	
}
