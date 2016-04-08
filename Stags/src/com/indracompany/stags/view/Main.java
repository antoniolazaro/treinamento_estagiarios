package com.indracompany.stags.view;

import java.util.List;

import com.indracompany.stags.bo.ClienteBO;
import com.indracompany.stags.bo.MidiaBO;
import com.indracompany.stags.bo.ab.ClienteBOIf;
import com.indracompany.stags.bo.ab.MidiaBOIf;
import com.indracompany.stags.model.ClienteModel;
import com.indracompany.stags.model.MidiaModel;

public class Main {
	private static ClienteBOIf clienteBO;
	private static MidiaBOIf midiaBO;
	
	static{
		clienteBO = new ClienteBO();
		midiaBO = new MidiaBO();
	}
	
	public static void main(String[] args) {
		try {
			inserirCliente();
			exibirCliente();
			
			inserirMidia();
			exibirMidia();
			
//			inserirCliente();
//			exibirCliente();
//			excluirCliente();
//			exibirCliente();
//			
//			inserirCliente();
//			exibirCliente();
//			editarCliente();
//			exibirCliente();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void inserirCliente() throws Exception{
		
		ClienteModel lCliente1 = new ClienteModel();
		lCliente1.setNome("Antônio Visionário");		
		
		ClienteModel lCliente2 = new ClienteModel();
		lCliente2.setNome("Luis Cardoso");
		
		ClienteModel lCliente3 = new ClienteModel();
		lCliente3.setNome("Caio");
		
		ClienteModel lCliente4 = new ClienteModel();
		lCliente4.setNome("Karen");
		
		ClienteModel lCliente5 = new ClienteModel();
		lCliente5.setNome("Matheus");
		
		clienteBO.inserir(lCliente1);
		clienteBO.inserir(lCliente2);
		clienteBO.inserir(lCliente3);
		clienteBO.inserir(lCliente4);
		clienteBO.inserir(lCliente5);
		
	}
	
	public static void inserirMidia() throws Exception{
		
		MidiaModel lMidia1 = new MidiaModel();
		lMidia1.setNome("Harry Potter");		
		
		MidiaModel lMidia2 = new MidiaModel();
		lMidia2.setNome("2012");
		
		MidiaModel lMidia3 = new MidiaModel();
		lMidia3.setNome("Avengers");
		
		MidiaModel lMidia4 = new MidiaModel();
		lMidia4.setNome("Thor: O Mundo Sombrio");
		
		MidiaModel lMidia5 = new MidiaModel();
		lMidia5.setNome("Batman vc Superman");
		
		midiaBO.inserir(lMidia1);
		midiaBO.inserir(lMidia2);
		midiaBO.inserir(lMidia3);
		midiaBO.inserir(lMidia4);
		midiaBO.inserir(lMidia5);
		
	}
	
	public static void excluirCliente() throws Exception{
		ClienteModel lCliente = new ClienteModel();
		lCliente.setCodigo(2L);
		
		clienteBO.excluir(lCliente);
	}
	
	public static void excluirMidia() throws Exception{
		MidiaModel lMidia = new MidiaModel();
		lMidia.setCodigo(2L);
		
		midiaBO.excluir(lMidia);
	}
	
	public static void editarCliente() throws Exception{
		ClienteModel lCliente = new ClienteModel();
		lCliente.setCodigo(2L);		
		
		ClienteModel lClienteBusca = clienteBO.buscar(lCliente);
		
		if(lClienteBusca !=null){
			lClienteBusca.setNome("Luis de Jah");
			clienteBO.editar(lClienteBusca);
		}
	}
	
	public static void editarMidia() throws Exception{
		MidiaModel lMidia = new MidiaModel();
		lMidia.setCodigo(2L);		
		
		MidiaModel lMidiaBusca = midiaBO.buscar(lMidia);
		
		if(lMidiaBusca !=null){
			lMidiaBusca.setNome("Luis de Jah");
			midiaBO.editar(lMidiaBusca);
		}
	}
	
	public static void exibirCliente()throws Exception{
		System.out.println("*******************************************************");
		List<ClienteModel> lListaCliente = clienteBO.listar();
		if(lListaCliente !=null && lListaCliente.size() > 0){
			for(ClienteModel lCliente:lListaCliente){
				System.out.println(lCliente);
			}
		}
	}
	
	public static void exibirMidia()throws Exception{
		System.out.println("*******************************************************");
		List<MidiaModel> lListaMidia = midiaBO.listar();
		if(lListaMidia !=null && lListaMidia.size() > 0){
			for(MidiaModel lMidia:lListaMidia){
				System.out.println(lMidia);
			}
		}
	}
}
