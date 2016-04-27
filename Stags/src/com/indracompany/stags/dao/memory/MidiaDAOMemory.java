package com.indracompany.stags.dao.memory;

import java.util.List;


import com.indracompany.stags.bo.MidiaBO;
import com.indracompany.stags.dao.MidiaDAOIf;
import com.indracompany.stags.dao.util.DataBase;
import com.indracompany.stags.model.MidiaModel;

public class MidiaDAOMemory implements MidiaDAOIf {
	
	@Override
	public void inserir(MidiaModel pModel) throws Exception {
		pModel.setCodigo(DataBase.getCodigoMidia());
		listar().add(pModel);
	}

	@Override
	public void editar(MidiaModel pModel) throws Exception {		
		int posicaoLista = listar().indexOf(pModel);	
		MidiaBO.validatePosicaoLista(posicaoLista);
		listar().set(posicaoLista, pModel);
	}

	@Override
	public void excluir(MidiaModel pModel) throws Exception {
		int posicaoLista = listar().indexOf(pModel);
		MidiaBO.validatePosicaoLista(posicaoLista);
		MidiaModel lModel = listar().get(posicaoLista);
		lModel.setAtivo(false);
	}

	@Override
	public List<MidiaModel> listar() throws Exception {
		return DataBase.getListaMidia();
	}

	@Override
	public MidiaModel buscar(MidiaModel pModel) throws Exception {
		MidiaModel lModel = null;		
		int posicaoLista = listar().indexOf(pModel);
		MidiaBO.validatePosicaoLista(posicaoLista);
		lModel = listar().get(posicaoLista);
		return lModel;		
	}
	
	@Override
	public MidiaModel buscarMidia(String nome) throws Exception {
		try {
			for(MidiaModel midia  : listar()){
				if(midia.getNome().equalsIgnoreCase(nome)){
					System.out.println("Mídia encontrado: "+midia.toString());
					return midia;
				}
			}
			throw new Exception("Mídia não encontrada. ");
		} catch (Exception e) {
			throw new Exception("Erro -> "+e.getMessage());
		}				
	}
	
	@Override
	public MidiaModel buscar(Long codigo) throws Exception {
		try {
			for(MidiaModel midia  : listar()){
				if(midia.getCodigo().equals(codigo)){
					System.out.println("Mídia encontrada: "+midia.toString());
					return midia;
				}
			}
			throw new Exception("Mídia não encontrada. ");
		} catch (Exception e) {
			throw new Exception("Erro -> "+e.getMessage());
		}
	}

	@Override
	public Double mediaPrecoVenda() throws Exception {
		int quantidadeMidia = listar().size();
		Double mediaPrecoVenda = (double) 0;
		for(Long a = (long) 1; a == quantidadeMidia; a++ ) {
			MidiaModel midia = buscar(a);
			mediaPrecoVenda += midia.getValorVenda();
		}
		return mediaPrecoVenda/quantidadeMidia;		
	}

	@Override
	public Double mediaPrecoAluguel() throws Exception {
		int quantidadeMidia = listar().size();
		Double mediaPrecoAluguel = (double) 0;
		for(Long a = (long) 1; a == quantidadeMidia; a++ ) {
			MidiaModel midia = buscar(a);
			mediaPrecoAluguel += midia.getValorAluguel();
		}
		return mediaPrecoAluguel/quantidadeMidia;
	}

	//precisa construir
	@Override
	public MidiaModel midiaMaisCaraVenda() throws Exception {
		Long codigo;
		return null;
		
	}

	@Override
	public MidiaModel midiaMaisCaraAluguel() throws Exception {
		Long codigo;
		return null;
		
	}

	//precisa construir
	@Override
	public MidiaModel midiaMaisBarataVenda() throws Exception {
		Long codigo;
		return null;
		
	}

	//precisa construir
	@Override
	public MidiaModel midiaMaisBarataAluguel() throws Exception {
		Long codigo;
		return null;
		
	}
	
	@Override
	public String exibirMidiaPrecoVendaAluguel() throws Exception {
		StringBuilder buffer = new StringBuilder();
		buffer.append("\n\nMédia de preço das mídias cadastradas para: ").append("\nVenda: ").append(mediaPrecoVenda() + "\n").append("\nAluguel: ").append(mediaPrecoAluguel() + "\n");
		return  buffer.toString();
	}
	
	@Override
	public String exibirMidiaPrecoMaisBaratoCaroVendaAluguel() throws Exception {
		StringBuilder buffer = new StringBuilder();
		buffer.append("\n\nMaior e menor preço da mídia para: ").append("\nVenda:\n").append("\nMais caro: ").append(midiaMaisCaraVenda()).append("\nMais barato: ").append(midiaMaisBarataVenda()).append("\nAluguel: ").append("\nMais caro: ").append(midiaMaisCaraAluguel()).append("\nMais barato: ").append(midiaMaisBarataAluguel());
		return  buffer.toString();
	}	
}
