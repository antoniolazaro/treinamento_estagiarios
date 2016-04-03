package com.indracompany.stags.test;

import java.util.List;

import com.indracompany.stags.bo.MidiaBO;
import com.indracompany.stags.bo.ab.MidiaBOIf;
import com.indracompany.stags.model.MidiaModel;

public class MidiaTest {
	
	private static MidiaBOIf midiaBO;
	
	static{
		midiaBO = new MidiaBO();
	}
		
	public void inserirMidia() throws Exception{
		
		MidiaModel lMidia1 = new MidiaModel(null, null, null, null, null, null, null);
		lMidia1.setNome("Antônio Visionário");
		lMidia1.setCodigo((long) 1);
		lMidia1.setIdade("25");
		lMidia1.setCpf("7364736435246");
		lMidia1.setAtivo(true);
		
		MidiaModel lMidia2 = new MidiaModel(null, null, null, null, null);
		lMidia2.setNome("Luis Cardoso");
		lMidia2.setCodigo((long) 2);
		lMidia2.setIdade("45");
		lMidia2.setCpf("7364736435236");
		lMidia2.setAtivo(true);
		
		MidiaModel lMidia3 = new MidiaModel(null, null, null, null, null);
		lMidia3.setNome("Caio");
		lMidia3.setCodigo((long) 3);
		lMidia3.setIdade("23");
		lMidia3.setCpf("7364736433236");
		lMidia3.setAtivo(true);
		
		MidiaModel lMidia4 = new MidiaModel(null, null, null, null, null);
		lMidia4.setNome("Karen");
		lMidia4.setCodigo((long) 4);
		lMidia4.setIdade("24");
		lMidia4.setCpf("7363336433236");
		lMidia4.setAtivo(true);
		
		MidiaModel lMidia5 = new MidiaModel(null, null, null, null, null);
		lMidia5.setNome("Matheus");
		lMidia5.setCodigo((long) 5);
		lMidia5.setIdade("24");
		lMidia5.setCpf("1264736433236");
		lMidia5.setAtivo(true);
		
		midiaBO.inserir(lMidia1);
		midiaBO.inserir(lMidia2);
		midiaBO.inserir(lMidia3);
		midiaBO.inserir(lMidia4);
		midiaBO.inserir(lMidia5);
		
	}
	
	public void excluirMidia() throws Exception{
		MidiaModel lMidia = new MidiaModel(null, null, null, null, null);
		lMidia.setCodigo(2L);
		
		midiaBO.excluir(lMidia);
	}
	
	
	public void editarMidia() throws Exception{
		MidiaModel lMidia = new MidiaModel(null, null, null, null, null);
		lMidia.setCodigo(2L);		
		
		MidiaModel lMidiaBusca = midiaBO.buscar(lMidia);
		
		if(lMidiaBusca !=null){
			lMidiaBusca.setNome("Luis de Jah");
			midiaBO.editar(lMidiaBusca);
		}
	}
	
	public void exibirMidia()throws Exception{
		System.out.println("*******************************************************");
		List<MidiaModel> lListaMidia = midiaBO.listar();
		if(lListaMidia !=null && lListaMidia.size() > 0){
			for(MidiaModel lMidia:lListaMidia){
				System.out.println(lMidia);
			}
		}
	}
}
