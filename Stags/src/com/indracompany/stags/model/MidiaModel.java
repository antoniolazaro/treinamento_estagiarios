package com.indracompany.stags.model;

public class MidiaModel extends ModelAB {
	private String nome;
	private String descricao;
	private String codigoBarras;
	private String dataRegistro;
	private Double valorAluguel;
	private Double valorVenda;
	private TipoDeMidiaModel tipoMidia;
	private Integer quantidadeEstoque;
	
	public MidiaModel(String nome, String descricao, String codigoBarras, String dataRegistro, Double valorAluguel,
			Double valorVenda, TipoDeMidiaModel tipoMidia, Integer quantidadeEstoque) {
		super();
		this.nome = nome;
		this.descricao = descricao;
		this.codigoBarras = codigoBarras;
		this.dataRegistro = dataRegistro;
		this.valorAluguel = valorAluguel;
		this.valorVenda = valorVenda;
		this.tipoMidia = tipoMidia;
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public MidiaModel() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(String dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Double getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(Double valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public Double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}

	public TipoDeMidiaModel getTipoMidia() {
		return tipoMidia;
	}

	public void setTipoMidia(TipoDeMidiaModel tipoMidia) {
		this.tipoMidia = tipoMidia;
	}
	
	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigoBarras == null) ? 0 : codigoBarras.hashCode());
		result = prime * result + ((dataRegistro == null) ? 0 : dataRegistro.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((tipoMidia == null) ? 0 : tipoMidia.hashCode());
		result = prime * result + ((valorAluguel == null) ? 0 : valorAluguel.hashCode());
		result = prime * result + ((valorVenda == null) ? 0 : valorVenda.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		MidiaModel other = (MidiaModel) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\n\nNome: " + getNome() + "\nDescrição: " + getDescricao() + "\nCodigo de Barras: " + getCodigoBarras() + "\nData da última modificação: " + getDataRegistro() + "\nValor de Venda: " + getValorVenda() + "\nValor de Aluguel: " + getValorAluguel() +  "\nTipo de mídia: " + getTipoMidia() + "\nQuantidade no estoque: " + getQuantidadeEstoque() + "\nCódigo: " + getCodigo() + "\nEstá ativo? " + getAtivo() + "\n";
	}
}
