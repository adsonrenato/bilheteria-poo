package br.ufg.inf.verao.bilheteria.model;


public enum FormaPagamento {
	
	CARTAO(0.0f), 
	DINHEIRO(0.02f);
        
        private final float desconto;
        
        private FormaPagamento(float desconto){
            this.desconto = desconto;
        }
        
        public float getDesconto(){
            return desconto;
        }

}
