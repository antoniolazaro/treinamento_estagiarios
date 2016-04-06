package com.indracompany.stags.model;

public class ProdutoModel extends ModelAB {

	private String nome;
	private Double precoVenda;
	private Double precoAluguel;
	// private boolean aluguel;
	// private boolean venda;
	private Integer quantidade = 0;
	private TipoProduto tipoProduto;

	public ProdutoModel() {

	}

	public ProdutoModel(String nome, Double precoVenda, Double precoAluguel, Integer quantidade,
			TipoProduto tipoProduto) {

		this.nome = nome;
		this.precoVenda = precoVenda;
		this.precoAluguel = precoAluguel;
		this.quantidade = quantidade;
		this.tipoProduto = tipoProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// public boolean isAluguel() {
	// return aluguel;
	// }
	//
	// public void setAluguel(boolean aluguel) {
	// this.aluguel = aluguel;
	// }
	//
	// public boolean isVenda() {
	// return venda;
	// }
	//
	// public void setVenda(boolean venda) {
	// this.venda = venda;
	// }

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public TipoProduto getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(TipoProduto tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Double getPrecoAluguel() {
		return precoAluguel;
	}

	public void setPrecoAluguel(Double precoAluguel) {
		this.precoAluguel = precoAluguel;
	}

}