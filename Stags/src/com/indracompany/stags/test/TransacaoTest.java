package com.indracompany.stags.test;

import java.util.ArrayList;
import java.util.List;

import com.indracompany.stags.bo.ClienteBO;
import com.indracompany.stags.bo.ab.ClienteBOIf;
import com.indracompany.stags.bo.ab.MidiaBOIf;
import com.indracompany.stags.model.MidiaModel;

public class TransacaoTest {

	private static ClienteBOIf clienteBO;
	private static List<MidiaModel> listaMidia;
	
	static{
		clienteBO = new ClienteBO();
		listaMidia = new ArrayList<MidiaModel>();
	}
		
	public void inserirCliente() throws Exception{
		
	}
}
