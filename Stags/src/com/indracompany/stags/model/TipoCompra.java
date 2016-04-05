package com.indracompany.stags.model;

public enum TipoCompra {

	COMPRA("compra"), ALUGUEL("aluguel");

	private String tipoCompra;

	private TipoCompra(String tipoCompra) {

		this.setTipoCompra(tipoCompra);

	}

	public String getTipoCompra() {
		return tipoCompra;
	}

	public void setTipoCompra(String tipoCompra) {
		this.tipoCompra = tipoCompra;
	}

}