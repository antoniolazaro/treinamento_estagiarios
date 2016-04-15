package com.indracompany.stags.test;

public class MainTestMidia {
	private static MidiaTest midiaTest;
	
	static{
		midiaTest = new MidiaTest();
	}
	
	public static void main(String[] args) {
		try {
			
			testInserir();
			testExcluir();
			testEditar();
			testBuscar();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void testInserir() throws Exception{
		midiaTest.inserirMidia();
		midiaTest.exibirMidia();
	}
	
	public static void testExcluir() throws Exception{
		midiaTest.inserirMidia();
		midiaTest.exibirMidia();
		midiaTest.excluirMidia();
		midiaTest.exibirMidia();
	}
	
	public static void testEditar() throws Exception{
		midiaTest.inserirMidia();
		midiaTest.exibirMidia();
		midiaTest.excluirMidia();
		midiaTest.exibirMidia();
	}
	
	public static void testBuscar() throws Exception{
		midiaTest.inserirMidia();
		midiaTest.buscarMidia();
	}
}
