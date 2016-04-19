package com.indracompany.stags.test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.indracompany.stags.bo.ClienteBO;
import com.indracompany.stags.bo.ab.ClienteBOIf;
import com.indracompany.stags.model.ClienteModel;
import com.indracompany.stags.model.MidiaModel;
import com.indracompany.stags.model.TipoDeMidiaModel;
import com.indracompany.stags.model.TransacaoModel;

public class TransacaoTest {

	private static ClienteBOIf clienteBO;
	private static List<MidiaModel> listaMidia;
	private static List<TransacaoModel> listaTransacao;
	
	static{
		clienteBO = new ClienteBO();
		listaMidia = new ArrayList<MidiaModel>();
		listaTransacao = new ArrayList<TransacaoModel>();
	}
		
	public void inserirTransacao() throws Exception{
		TransacaoModel ptransacao = new TransacaoModel();
//		Inserir cliente
		ClienteModel lCliente1 = new ClienteModel();
		lCliente1.setNome("Antônio Visionário");
		lCliente1.setCodigo((long) 1);
		lCliente1.setIdade(25);
		lCliente1.setCpf("7364736435246");
		lCliente1.setAtivo(true);
		
//		Inserir mídia	
		MidiaModel lMidia1 = new MidiaModel();
		lMidia1.setNome("2013");
		lMidia1.setCodigo((long) 1);
		lMidia1.setDescricao("25");
		lMidia1.setCodigoBarras("7364736435246");
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		lMidia1.setDataRegistro(dateFormat.format(date));		
		lMidia1.setValorAluguel(3.50);
		lMidia1.setValorVenda(40.50);
		lMidia1.setTipoMidia(TipoDeMidiaModel.DVD);
		lMidia1.setQuantidadeEstoque(5);
		lMidia1.setAtivo(true);
		

//		Inserir mídia	
		MidiaModel lMidia2 = new MidiaModel();
		lMidia2.setNome("2014");
		lMidia2.setCodigo((long) 2);
		lMidia2.setDescricao("25 gsdfg sdf");
		lMidia2.setCodigoBarras("736473643524dwd6");
//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date1 = new Date();
		lMidia2.setDataRegistro(dateFormat.format(date1));		
		lMidia2.setValorAluguel(3.70);
		lMidia2.setValorVenda(40.60);
		lMidia2.setTipoMidia(TipoDeMidiaModel.STREAMING);
		lMidia2.setQuantidadeEstoque(20);
		lMidia2.setAtivo(true);
		
		listaMidia.add(lMidia1);
		listaMidia.add(lMidia2);

			
//		listaTransacao.inserir(clienteBO, listaMidia);		
//	}
//	
//	public void exibirTransacao()throws Exception{
//		System.out.println("*******************************************************");
//		List<MidiaModel> lListaMidia = midiaBO.listar();
//		if(lListaMidia !=null && lListaMidia.size() > 0){
//			for(MidiaModel lMidia:lListaMidia){
//				System.out.println(lMidia);
//			}
//		}
	}
	
//	public void exibirCliente()throws Exception{
//		System.out.println("*******************************************************");
//		List<ClienteModel> lListaCliente = clienteBO.listar();
//		if(lListaCliente !=null && lListaCliente.size() > 0){
//			for(ClienteModel lCliente:lListaCliente){
//				System.out.println(lCliente);
//			}
//		}
//	}
}
