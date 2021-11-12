import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;

public class GerenciadorVeiculo{
	Scanner scanner;
	DaoVeiculo daoVeiculo;
	
	public GerenciadorVeiculo(){
		scanner = new Scanner(System.in);
		daoVeiculo = new DaoVeiculo();
	}
	
	public void menu(){
		int opcao = -1;
		
		while(opcao != 0){
			System.out.println("\n--------------------------------------------------------------");
			System.out.println("GERENCIAMENTO DE VEICULOS");
			System.out.println("[1] Cadastrar");
			System.out.println("[2] Consultar");
			System.out.println("[3] Alterar");
			System.out.println("[4] Excluir");
			System.out.println("[5] Listar todos");
			System.out.println("[0] Voltar ao menu anterior");
			System.out.println("--------------------------------------------------------------\n");
			try{
				opcao = Integer.parseInt(scanner.nextLine());	
			} catch (Exception e) {
				System.out.println("Erro... informe um numero inteiro");
			}			

			if(opcao == 1){
				cadastrar();
			}else if(opcao == 2){
				consultar();
			}else if(opcao == 3){
				alterar();
			}else if(opcao == 4){
				excluir();
			}else if(opcao == 5){
				listarTodos();
			}else if(opcao != 0){
				System.out.println("Opcao invalida!");
			}
		}
	}
	
	public void cadastrar(){
		Veiculo veiculo = new Veiculo();
		
		System.out.println("\n--------------------------------------------------------------");
		System.out.println("[Cadastro de Veiculos]");
		System.out.println("Marca: ");
		veiculo.setMarca(scanner.nextLine());
		System.out.println("Modelo: ");
		veiculo.setModelo(scanner.nextLine());
		System.out.println("Chassi: ");
		veiculo.setChassi(scanner.nextLine());
		System.out.println("Ano: ");
		veiculo.setAno(Integer.parseInt(scanner.nextLine()));
		
		boolean inserido = daoVeiculo.inserir(veiculo);//passa o objeto para a camada model
		if(inserido){
			System.out.println("Inserido com sucesso.");
		}
	}

	private void listarTodos(){
		ArrayList<Veiculo> resultado = daoVeiculo.buscarTodos();
		System.out.println("\n--------------------------------------------------------------");
		System.out.println("[Veiculos cadastrados]");
		Iterator<Veiculo> itVeic = resultado.iterator();
		while(itVeic.hasNext()){
			Veiculo v = itVeic.next();
			System.out.println("Modelo: " + v.getModelo()
				+ ", Marca: " + v.getMarca()
				+ ", Chassi: " + v.getChassi()
				+ ", Ano: " + v.getAno()
				+ ", Codigo: " + v.getCodigo());
		}
	}
	
	public void excluir(){
		System.out.println("\n--------------------------------------------------------------");
		System.out.println("[Exclusao de Veiculos]");
		System.out.println("Codigo: ");
		int codigo = Integer.parseInt(scanner.nextLine());
		int qtde = daoVeiculo.excluir(codigo);

		if(qtde > 0){
			System.out.println("Excluido com sucesso.");
		}else{
			System.out.println("Nao encontrado...");
		}
	}
	public void consultar(){
		System.out.println("\n--------------------------------------------------------------");
		System.out.println("[Consulta de Veiculos]");
		System.out.println("Codigo: ");
		int codigo = Integer.parseInt(scanner.nextLine());
		Veiculo v = daoVeiculo.consultar(codigo);

		if(v != null){
			System.out.println("Dados do veiculo");
			System.out.println("Modelo: " + v.getModelo());
			System.out.println("Marca: " + v.getMarca());
			System.out.println("Chassi: " + v.getChassi());
			System.out.println("Ano: " + v.getAno());
			System.out.println("Codigo: " + v.getCodigo());
		}else{
			System.out.println("Nao encontrado...");
		}
	}

	private void alterar(){
		System.out.println("--------------------------------------------------------------");
		System.out.println("[ Alteracao de Veiculo ]");
		System.out.println("Codigo:");
		int codigo = Integer.parseInt(scanner.nextLine());

		Veiculo v = daoVeiculo.consultar(codigo);
		if(v != null){
			System.out.println("Codigo: [" + v.getCodigo() + "]");
			System.out.println("Marca: [" + v.getMarca() + "]");
			String marca = scanner.nextLine().trim();
			if(!marca.isEmpty()){
				v.setMarca(marca);
			}
			System.out.println("Modelo: [" + v.getModelo() + "]");
			String modelo = scanner.nextLine().trim();
			if(!modelo.isEmpty()){
				v.setModelo(modelo);
			}
			System.out.println("Chassi: [" + v.getChassi() + "]");
			String chassi = scanner.nextLine().trim();
			if(!chassi.isEmpty()){
				v.setChassi(chassi);
			}
			System.out.println("Ano: [" + v.getAno() + "]");
			String ano = scanner.nextLine().trim();
			if(!ano.isEmpty()){
				v.setAno(Integer.parseInt(ano));
			}
			int qtdeAlterado = daoVeiculo.alterar(v);
			if(qtdeAlterado > 0){
				System.out.println("Atualizado!");
			}
		}else{
			System.out.println("Nao encontrado...");
		}
	}


}