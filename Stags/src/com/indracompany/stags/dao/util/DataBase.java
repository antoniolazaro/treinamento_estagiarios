package com.indracompany.stags.dao.util;

import java.util.ArrayList;
import java.util.List;

import com.indracompany.stags.model.ClienteModel;

public class DataBase {
	static{
		listaCliente = new ArrayList<ClienteModel>();
	}
		
	private static long sequencialCliente;
	private static List<ClienteModel> listaCliente;
	
	
	public static long getCodigoCliente(){
		return ++sequencialCliente;
	}


	public static long getSequencialCliente() {
		return sequencialCliente;
	}


	public static void setSequencialCliente(long sequencialCliente) {
		DataBase.sequencialCliente = sequencialCliente;
	}


	public static List<ClienteModel> getListaCliente() {
		return listaCliente;
	}


	public static void setListaCliente(List<ClienteModel> listaCliente) {
		DataBase.listaCliente = listaCliente;
	}
	

}
