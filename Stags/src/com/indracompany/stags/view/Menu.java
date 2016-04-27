package com.indracompany.stags.view;

public class Menu {

	public static void main(String[] Args) throws Exception {
		boolean continuar = true;
		String opcao;

		MenuBuilder menuBuilder = new MenuBuilder();
		do {
			opcao = menuBuilder.executarMenuInicial();

			try {
				switch (opcao) {
				case "1":
					menuBuilder.inserirCliente();
					break;

				case "2":
					menuBuilder.buscarCliente();
					break;

				case "3":
					menuBuilder.excluirCliente();
					break;

				case "4":
					menuBuilder.editarCliente();
					break;

				case "5":
					menuBuilder.reativarCliente();

					break;
				case "6":
					menuBuilder.listarCliente();
					break;

				case "7":
					menuBuilder.inserirProduto();
					break;

				case "8":
					menuBuilder.buscarProduto();
					break;

				case "9":
					menuBuilder.excluirProduto();
					break;

				case "10":
					menuBuilder.editarProduto();
					break;

				case "11":
					menuBuilder.comprar();
					break;

				case "12":
					menuBuilder.alugar();
					break;

				case "13":
					menuBuilder.listarCompras();
					break;

				case "14":
					menuBuilder.prudutoMaisCaro();
					break;

				case "15":
					menuBuilder.prudutoMaisBarato();
					break;

				case "16":
					menuBuilder.mediaPreco();
					break;

				case "17":
					menuBuilder.buscarProdutoCodigo();
					break;

				case "0":
					continuar = finalizarPrograma();
					break;
				default:
					System.out.println("Você digitou uma opção inválida.\n");
				}
			} catch (Exception ex) {
				System.out.println("Erro -> " + ex.getMessage());
			}
		} while (continuar);
	}

	private static boolean finalizarPrograma() throws InterruptedException {
		boolean continuar;
		continuar = false;
		System.out.print(":) ");

		Thread.sleep(2000);

		System.out.print("volte Sempre! ");

		Thread.sleep(2000);

		System.out.println(":)");
		return continuar;

	}
}