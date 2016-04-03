package com.indracompany.stags.model;

public enum TipoProduto {

	DVD("dvd"), STREAM("stream"), BLURAY("blu-ray");

	private String tipoProduto;

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	private TipoProduto(String tipoProduto) {
		this.setTipoProduto(tipoProduto);
	}

	public String getTipoProduto() {
		return tipoProduto;
	}
}