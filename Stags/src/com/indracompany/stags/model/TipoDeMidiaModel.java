package com.indracompany.stags.model;

public enum TipoDeMidiaModel {
		DVD(1L,"DVD"), BLURAY(2L,"BLU-RAY"), STREAMING(3L, "STREAMING");
		
		private Long codigo;
		private String descricao;	
		
		private TipoDeMidiaModel(Long codigo, String descricao) {
			this.codigo = codigo;
			this.descricao = descricao;
		}		
		
		public static TipoDeMidiaModel getTipoDeMidiaPorCodigo(Long codigo){
			TipoDeMidiaModel retorno = null;
			
			for(TipoDeMidiaModel tipoDeMidia:TipoDeMidiaModel.values()){
				if(tipoDeMidia.getCodigo().equals(codigo)){
					retorno = tipoDeMidia;
					break;
				}
			}
			return retorno;
		}
		public Long getCodigo() {
			return codigo;
		}
		public void setCodigo(Long codigo) {
			this.codigo = codigo;
		}
		public String getDescricao() {
			return descricao;
		}
		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
}
