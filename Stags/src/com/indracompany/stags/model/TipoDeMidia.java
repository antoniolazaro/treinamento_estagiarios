package com.indracompany.stags.model;

public enum TipoDeMidia {
		DVD(1L,"DVD"),CD(2L,"CD"), STREAMING(3L, "STREAMING");
		
		private Long codigo;
		private String descricao;	
		
		private TipoDeMidia(Long codigo, String descricao) {
			this.codigo = codigo;
			this.descricao = descricao;
		}
		
		public static TipoDeMidia getTipoDeMidiaPorCodigo(Long codigo){
			TipoDeMidia retorno = null;
			
			for(TipoDeMidia tipoDeMidia:TipoDeMidia.values()){
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
