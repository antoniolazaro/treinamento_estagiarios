package com.indracompany.stags.test;

public class MainTest {
	private static ClienteTest clienteTest;
	
	static{
		clienteTest = new ClienteTest();
	}
	
	public static void main(String[] args) {
		try {
			
			testInserir();
			testExcluir();
			testEditar();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testInserir() throws Exception{
		clienteTest.inserirCliente();
		clienteTest.exibirCliente();
	}
	
	public static void testExcluir() throws Exception{
		clienteTest.inserirCliente();
		clienteTest.exibirCliente();
		clienteTest.excluirCliente();
		clienteTest.exibirCliente();
	}
	
	public static void testEditar() throws Exception{
		clienteTest.inserirCliente();
		clienteTest.exibirCliente();
		clienteTest.editarCliente();
		clienteTest.exibirCliente();
	}
	
}
