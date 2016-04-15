package com.indracompany.stags.test;

import java.util.Date;
import java.util.List;
import com.indracompany.stags.bo.MidiaBO;
import com.indracompany.stags.bo.ab.MidiaBOIf;
import com.indracompany.stags.model.MidiaModel;
import com.indracompany.stags.model.TipoDeMidiaModel;

public class MidiaTest {
	
	private static MidiaBOIf midiaBO;
	
	static{
		midiaBO = new MidiaBO();
	}
		
	public void inserirMidia() throws Exception{
		
		MidiaModel lMidia1 = new MidiaModel();
		lMidia1.setNome("2013");
		lMidia1.setCodigo((long) 1);
		lMidia1.setDescricao("25");
		lMidia1.setCodigoBarras("7364736435246");
		lMidia1.setDataRegistro(new Date());
		lMidia1.setValorAluguel(3.50);
		lMidia1.setValorVenda(40.50);
		lMidia1.setTipoMidia(TipoDeMidiaModel.DVD);
		lMidia1.setQuantidadeEstoque(5);
		lMidia1.setAtivo(true);
			
		midiaBO.inserir(lMidia1);		
	}
	
	public void excluirMidia() throws Exception{
		MidiaModel lMidia = new MidiaModel();
		lMidia.setCodigo(2L);
		
		midiaBO.excluir(lMidia);
	}
	
	
	public void editarMidia() throws Exception{
		MidiaModel lMidia = new MidiaModel();
		lMidia.setCodigo(2L);		
		
		MidiaModel lMidiaBusca = midiaBO.buscar(lMidia);
		
		if(lMidiaBusca !=null){
			lMidiaBusca.setNome("Luis de Jah");
			midiaBO.editar(lMidiaBusca);
		}
	}
	
	public void buscarMidia() throws Exception{		
		midiaBO.buscarMidia("2013");	
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
