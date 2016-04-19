package com.indracompany.stags.dao.util;

import java.util.ArrayList;
import java.util.List;

import com.indracompany.stags.model.ClienteModel;
import com.indracompany.stags.model.MidiaModel;
import com.indracompany.stags.model.TransacaoModel;

public class DataBase {
	static{
		listaCliente = new ArrayList<ClienteModel>();
		listaMidia = new ArrayList<MidiaModel>();
		listaTransacao = new ArrayList<TransacaoModel>();
	}
		
	private static long sequencialCliente;
	private static long sequencialMidia;
	private static long sequencialTransacao;
	private static List<ClienteModel> listaCliente;
	private static List<MidiaModel> listaMidia;	
	private static List<TransacaoModel> listaTransacao;	
	
	public static long getCodigoCliente(){
		return ++sequencialCliente;
	}

	public static long getCodigoMidia() {
		return  ++sequencialMidia;
	}
	
	public static long getSequencialCliente() {
		return sequencialCliente;
	}
	
	public static long getCodigoTransacao() {
		return ++sequencialTransacao;
	}
	
	public static long getSequencialMidia() {
		return sequencialMidia;
	}

	public static long getSequencialTransacao() {
		return sequencialTransacao;
	}

	public static void setSequencialTransacao(long sequencialTransacao) {
		DataBase.sequencialTransacao = sequencialTransacao;
	}

	public static void setSequencialCliente(long sequencialCliente) {
		DataBase.sequencialCliente = sequencialCliente;
	}

	public static void setSequencialMidia(long sequencialMidia) {
		DataBase.sequencialMidia = sequencialMidia;
	}
	
	public static List<ClienteModel> getListaCliente() {
		return listaCliente;
	}

	public static List<MidiaModel> getListaMidia() {
		return listaMidia;
	}
	
	public static void setListaCliente(List<ClienteModel> listaCliente) {
		DataBase.listaCliente = listaCliente;
	}

	public static void setListaMidia(List<MidiaModel> listaMidia) {
		DataBase.listaMidia = listaMidia;
	}

	public static List<TransacaoModel> getListaTransacao() {
		return listaTransacao;
	}

	public static void setListaTransacao(List<TransacaoModel> listaTransacao) {
		DataBase.listaTransacao = listaTransacao;
	}
}
