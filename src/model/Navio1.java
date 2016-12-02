package model;

public class Navio1 {
	
	static int navio1[][];
	static int t;// tamanho
	static int i;
	static int j;
	
		
	public Navio1(int t){
		navio1 = new int[t][t];
		
	}
	public void alterar(int linha, int coluna){
		
	   navio1[linha][coluna]=1;
		
		
	}
	public boolean consultar(int linha, int coluna){
		
		if (navio1[linha][coluna]==1){
			return true;
			
			
		}
		else {
			
			
		return false;	
			
		}
	}
		public void reiniciar(){
			for(i=0; i<t;i++){
				
				for(j=0; j<t;j++){
					navio1[i][j]=0;
					
				}
				
			}
			
		}

}
