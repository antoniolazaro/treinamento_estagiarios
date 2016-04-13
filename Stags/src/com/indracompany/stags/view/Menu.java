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
					menuBuilder.listarCliente();

					break;
				case "6":
					menuBuilder.inserirProduto();
					break;

				case "7":
					menuBuilder.buscarProduto();
					break;

				case "8":
					menuBuilder.excluirProduto();
					break;

				case "9":
					menuBuilder.editarCliente();
					break;
				case "0":
					continuar = finalizarPrograma();
					break;
				default:
					System.out.printf("Você digitou uma opção inválida.");
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