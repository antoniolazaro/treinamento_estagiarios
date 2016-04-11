package com.indracompany.stags.test;

public class MainTest {
	// private static ClienteTest clienteTest;
	private static ProdutoTest produtoTest;

	static {
		// clienteTest = new ClienteTest();
		produtoTest = new ProdutoTest();
	}

	public static void main(String[] args) {
		try {

			testInserir();
			// testExcluir();
			// testEditar();
			testListar();

			// testBuscar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void testInserir() throws Exception {
		// clienteTest.inserirCliente();
		// clienteTest.exibirCliente();

		produtoTest.inserir();

	}

	public static void testExcluir() throws Exception {

		produtoTest.excluir();
		// clienteTest.inserirCliente();
		// clienteTest.exibirCliente();
		// clienteTest.excluirCliente();
		// clienteTest.exibirCliente();
	}

	public static void testEditar() throws Exception {
		produtoTest.editar();
		// clienteTest.inserirCliente();
		// clienteTest.exibirCliente();
		// clienteTest.editarCliente();
		// clienteTest.exibirCliente();
	}

	public static void testListar() throws Exception {
		produtoTest.buscarPorNome();
	}

	public static void testBuscar() throws Exception {
		produtoTest.buscar();
	}

}
